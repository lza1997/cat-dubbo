package com.zs.cat.monitor.base.bean;

import java.util.Date;

public class TSmsTempSend {
    private Date createTime;

    private String receiver;

    private String content;

    private String wFlag;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getwFlag() {
        return wFlag;
    }

    public void setwFlag(String wFlag) {
        this.wFlag = wFlag == null ? null : wFlag.trim();
    }
}