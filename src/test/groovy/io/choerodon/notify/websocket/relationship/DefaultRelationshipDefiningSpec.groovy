package io.choerodon.notify.websocket.relationship

import io.choerodon.notify.api.service.WebSocketSendService
import io.choerodon.notify.websocket.register.RedisChannelRegister
import org.springframework.data.redis.core.SetOperations
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.socket.WebSocketSession
import spock.lang.Specification

import java.lang.reflect.Field
import java.util.concurrent.ConcurrentHashMap

/**
 * @author dengyouquan
 * */
class DefaultRelationshipDefiningSpec extends Specification {
    private StringRedisTemplate redisTemplate = Mock(StringRedisTemplate)
    private RedisChannelRegister redisChannelRegister = Mock(RedisChannelRegister)
    private WebSocketSendService webSocketSendService=Mock(WebSocketSendService)
    private DefaultRelationshipDefining relationshipDefining =
            new DefaultRelationshipDefining(redisTemplate, redisChannelRegister)

    def "GetWebSocketSessionsByKey"() {
        when: "调用方法"
        relationshipDefining.getWebSocketSessionsByKey("key")
        then: "校验结果"
        noExceptionThrown()
    }

    def "GetRedisChannelsByKey"() {
        given: "构造请求参数"
        Set<String> survivalChannels = new HashSet<>()
        survivalChannels.add("notify-service")
        survivalChannels.add("iam-service")
        SetOperations<String, Object> setOperations = Mock(SetOperations)

        when: "调用方法"
        relationshipDefining.getRedisChannelsByKey("key", true)
        then: "校验结果"
        noExceptionThrown()
        redisChannelRegister.getSurvivalChannels() >> survivalChannels
        1 * redisChannelRegister.channelName() >> "notify-service"
        1 * redisTemplate.opsForSet() >> setOperations
        1 * setOperations.members(_) >> { new HashSet<>() }
    }

    def "Contact"() {
        given: "构造请求参数"
        SetOperations<String, Object> setOperations = Mock(SetOperations)
        WebSocketSession session = Mock(WebSocketSession)

        when: "调用方法[null]"
        relationshipDefining.contact(null, null)
        then: "校验结果"
        noExceptionThrown()

        when: "调用方法"
        relationshipDefining.contact("key", session)
        then: "校验结果"
        noExceptionThrown()
        1 * redisChannelRegister.channelName() >> "notify-service"
        1 * redisTemplate.opsForSet() >> setOperations
    }

    def "RemoveWebSocketSessionContact"() {
        given: "构造请求参数"
        SetOperations<String, Object> setOperations = Mock(SetOperations)
        setOperations.members(_) >> { return new HashSet<>() }
        WebSocketSession session = Mock(WebSocketSession)
        Map<String, Set<WebSocketSession>> keySessionsMap = new ConcurrentHashMap<>()
        Set<WebSocketSession> set = new HashSet<>()
        set.add(session)
        keySessionsMap.put("iam-service", set)

        relationshipDefining.setWebSocketWsSendService(webSocketSendService)


        when: "调用方法[null]"
        relationshipDefining.removeWebSocketSessionContact(null)
        then: "校验结果"
        noExceptionThrown()

        when: "调用方法"
        relationshipDefining.removeWebSocketSessionContact(session)
        then: "校验结果"
        noExceptionThrown()

        when: "调用方法"
        Field field = relationshipDefining.getClass().getDeclaredField("keySessionsMap")
        field.setAccessible(true)
        field.set(relationshipDefining, keySessionsMap)
        relationshipDefining.removeWebSocketSessionContact(session)
        then: "校验结果"
        noExceptionThrown()
        redisTemplate.opsForSet() >> setOperations
        redisTemplate.keys(_) >> new HashSet<String>()
    }
}
