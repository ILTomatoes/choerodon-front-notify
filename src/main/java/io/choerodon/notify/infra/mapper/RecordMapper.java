package io.choerodon.notify.infra.mapper;

import io.choerodon.mybatis.common.Mapper;
import io.choerodon.notify.api.dto.RecordListDTO;
import io.choerodon.notify.api.pojo.RecordQueryParam;
import io.choerodon.notify.domain.Record;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RecordMapper extends Mapper<Record> {

    List<RecordListDTO> fulltextSearchEmail(@Param("query") final RecordQueryParam param);

    void updateRecordStatusAndIncreaseCount(@Param("id") long id,
                                            @Param("status") String status,
                                            @Param("reason") String reason,
                                            @Param("increase") boolean increase,
                                            @Param("date") Date date);
}
