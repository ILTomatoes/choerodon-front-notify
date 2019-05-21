package io.choerodon.notify.domain;

import io.choerodon.mybatis.entity.BaseDTO;
import io.choerodon.notify.api.pojo.RecordSendData;

import javax.persistence.*;

@Table(name = "notify_record")
public class Record extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String receiveAccount;
    private String failedReason;
    private String businessType;
    private Integer retryCount;
    private String messageType;
    private String variables;
    private Long templateId;

    @Transient
    private RecordSendData sendData;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

    public RecordSendData getSendData() {
        return sendData;
    }

    public void setSendData(RecordSendData sendData) {
        this.sendData = sendData;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", receiveAccount='" + receiveAccount + '\'' +
                ", failedReason='" + failedReason + '\'' +
                ", businessType='" + businessType + '\'' +
                ", retryCount=" + retryCount +
                ", messageType='" + messageType + '\'' +
                ", variables='" + variables + '\'' +
                ", templateId=" + templateId +
                ", sendData=" + sendData +
                '}';
    }
}
