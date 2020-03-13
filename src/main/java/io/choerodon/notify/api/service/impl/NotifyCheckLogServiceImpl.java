package io.choerodon.notify.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.zaxxer.hikari.util.UtilityElf;
import io.choerodon.notify.api.dto.CheckLog;
import io.choerodon.notify.api.service.NotifyCheckLogService;
import io.choerodon.notify.infra.dto.NotifyCheckLogDTO;
import io.choerodon.notify.infra.mapper.NotifyCheckLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Service
public class NotifyCheckLogServiceImpl implements NotifyCheckLogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyCheckLogServiceImpl.class);
    private static final ExecutorService executorService = new ThreadPoolExecutor(0, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new UtilityElf.DefaultThreadFactory("notify-upgrade", false));

    private static final Map<String, String> codeMap = new HashMap<>(3);
    private static final Map<String, String> targetUserType = new HashMap<>(5);

    static {
        codeMap.put("issue_assigneed", "issueAssignee");
        codeMap.put("issue_solved", "issueSolve");
        codeMap.put("issue_created", "issueCreate");

        targetUserType.put("assigneer", "assignee");
        targetUserType.put("reporter", "reporter");
        targetUserType.put("users", "specifier");
        targetUserType.put("project_owner", "projectOwner");
    }

    @Autowired
    private NotifyCheckLogMapper notifyCheckLogMapper;

    @Override
    public void checkLog(String version, String type) {
        LOGGER.info("start upgrade task");
        executorService.execute(new UpgradeTask(version, type));
    }

    class UpgradeTask implements Runnable {
        private String version;
        private String type;

        UpgradeTask(String version, String type) {
            this.version = version;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                NotifyCheckLogDTO notifyCheckLogDTO = new NotifyCheckLogDTO();
                List<CheckLog> logs = new ArrayList<>();
                notifyCheckLogDTO.setBeginCheckDate(new Date());


                notifyCheckLogDTO.setLog(JSON.toJSONString(logs));
                notifyCheckLogDTO.setEndCheckDate(new Date());
                notifyCheckLogMapper.insert(notifyCheckLogDTO);
            } catch (Throwable ex) {
                LOGGER.warn("Exception occurred when applying data migration. The ex is: {}", ex);
            }
        }
    }
}
