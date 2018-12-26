package io.choerodon.notify.websocket.relationship;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import io.choerodon.notify.api.service.WebSocketSendService;
import io.choerodon.notify.websocket.register.RedisChannelRegister;

public class DefaultRelationshipDefining implements RelationshipDefining {

    private static final Logger LOGGER = LoggerFactory.getLogger(RelationshipDefining.class);

    private Map<String, Set<WebSocketSession>> keySessionsMap = new ConcurrentHashMap<>();

    private Map<WebSocketSession, Set<String>> sessionKeysMap = new ConcurrentHashMap<>();

    private StringRedisTemplate redisTemplate;

    private RedisChannelRegister redisChannelRegister;

    private static Integer onlineCount = 0;

    private static Set<String> numberOfVisitorsToday = new HashSet<>();

    @Autowired
    private WebSocketSendService webSocketWsSendService;

    public DefaultRelationshipDefining(StringRedisTemplate redisTemplate,
                                       RedisChannelRegister redisChannelRegister) {
        this.redisTemplate = redisTemplate;
        this.redisChannelRegister = redisChannelRegister;
    }


    @Override
    public Set<WebSocketSession> getWebSocketSessionsByKey(String key) {
        return keySessionsMap.getOrDefault(key, Collections.emptySet());
    }

    @Override
    public Set<String> getKeysBySession(WebSocketSession session) {
        return sessionKeysMap.getOrDefault(session, Collections.emptySet());
    }

    @Override
    public Set<String> getRedisChannelsByKey(String key, boolean exceptSelf) {
        Set<String> set = new HashSet<>();
        Set<String> survivalChannels = redisChannelRegister.getSurvivalChannels();
        if (exceptSelf) {
            survivalChannels.remove(redisChannelRegister.channelName());
        }
        survivalChannels.forEach(t -> {
            if (redisTemplate.opsForSet().members(t).contains(key)) {
                set.add(t);
            }
        });
        return set;
    }

    @Override
    public void contact(String key, WebSocketSession session) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        if (session != null) {
            Set<WebSocketSession> sessions = keySessionsMap.computeIfAbsent(key, k -> new HashSet<>());
            sessions.add(session);
            Set<String> subKeys = sessionKeysMap.computeIfAbsent(session, k -> new HashSet<>());
            subKeys.add(key);
            LOGGER.info("webSocket subscribe sessionId is {}, subKeys is {}", session.getId(), subKeys);
        }
        redisTemplate.opsForSet().add(redisChannelRegister.channelName(), key);
    }

    @Override
    public void removeWebSocketSessionContact(WebSocketSession delSession) {
        if (delSession == null) {
            return;
        }
        sessionKeysMap.remove(delSession);
        Iterator<Map.Entry<String, Set<WebSocketSession>>> it = keySessionsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Set<WebSocketSession>> next = it.next();
            Set<WebSocketSession> sessions = next.getValue();
            sessions.removeIf(t -> t.equals(delSession));
            if (sessions.isEmpty()) {
                it.remove();
                redisTemplate.opsForSet().remove(redisChannelRegister.channelName(), next.getKey());
            }
        }
        //在线人数-1,发消息
        subOnlineCount();
        webSocketWsSendService.sendVisitorsInfo(getOnlineCount(), getNumberOfVisitorsToday().size());
    }


    public static synchronized Integer getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        DefaultRelationshipDefining.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        DefaultRelationshipDefining.onlineCount--;
    }

    public static synchronized Set<String> getNumberOfVisitorsToday() {
        return numberOfVisitorsToday;
    }

    public static synchronized void addNumberOfVisitorsToday(String id) {
        DefaultRelationshipDefining.numberOfVisitorsToday.add(id);
    }

    public static synchronized void clearNumberOfVisitorsToday() {
        DefaultRelationshipDefining.numberOfVisitorsToday.clear();
    }


}
