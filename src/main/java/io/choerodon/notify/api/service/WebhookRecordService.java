package io.choerodon.notify.api.service;

import com.github.pagehelper.PageInfo;
import io.choerodon.notify.api.dto.WebhookRecordVO;
import io.choerodon.notify.infra.dto.WebhookRecordDTO;
import org.springframework.data.domain.Pageable;

/**
 * @author jiameng.cao
 * @date 2019/11/4
 */
public interface WebhookRecordService {

    WebhookRecordVO queryById(Long id);

    PageInfo<WebhookRecordDTO> pagingWebHookRecord(Pageable pageable, Long sourceId, Long webhookId, String status, String sendSettingCode, String webhookType);

}
