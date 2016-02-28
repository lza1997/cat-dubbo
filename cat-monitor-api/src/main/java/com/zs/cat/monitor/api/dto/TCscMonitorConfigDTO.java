package com.zs.cat.monitor.api.dto;

import java.io.Serializable;

public class TCscMonitorConfigDTO  implements Serializable{
    private String monitorId;

    private String monitorCode;

    private String monitorSegment;

    private String monitorName;

    private String monitorDesc;

    private String monitorScript;

    private Long threshold;

    private String compareType;

    private Long noticeNum;

    private String stat;

    private String memo;

    

    public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getMonitorCode() {
        return monitorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode == null ? null : monitorCode.trim();
    }

    public String getMonitorSegment() {
        return monitorSegment;
    }

    public void setMonitorSegment(String monitorSegment) {
        this.monitorSegment = monitorSegment == null ? null : monitorSegment.trim();
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName == null ? null : monitorName.trim();
    }

    public String getMonitorDesc() {
        return monitorDesc;
    }

    public void setMonitorDesc(String monitorDesc) {
        this.monitorDesc = monitorDesc == null ? null : monitorDesc.trim();
    }

    public String getMonitorScript() {
        return monitorScript;
    }

    public void setMonitorScript(String monitorScript) {
        this.monitorScript = monitorScript == null ? null : monitorScript.trim();
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    public String getCompareType() {
        return compareType;
    }

    public void setCompareType(String compareType) {
        this.compareType = compareType == null ? null : compareType.trim();
    }

    public Long getNoticeNum() {
        return noticeNum;
    }

    public void setNoticeNum(Long noticeNum) {
        this.noticeNum = noticeNum;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}
