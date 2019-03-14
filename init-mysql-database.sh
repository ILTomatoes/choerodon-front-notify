#!/usr/bin/env bash
mkdir -p choerodon_temp
if [ ! -f choerodon_temp/choerodon-tool-liquibase.jar ]
then
    curl http://nexus.choerodon.com.cn/repository/choerodon-release/io/choerodon/choerodon-tool-liquibase/0.6.3.RELEASE/choerodon-tool-liquibase-0.6.3.RELEASE.jar -L  -o choerodon_temp/choerodon-tool-liquibase.jar
fi
java -Dspring.datasource.url="jdbc:mysql://localhost/notify_service?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=choerodon \
 -Dspring.datasource.password=123456 \
 -Ddata.drop=false -Ddata.init=true \
 -Ddata.dir=src/main/resources \
 -jar choerodon_temp/choerodon-tool-liquibase.jar