package com.zs.cat.monitor.api.dto;
import java.io.Serializable;
import java.util.Date;
public class TCsmMonitorDataDTO implements Serializable{
	private static final long serialVersionUID = 9085755760506729591L;

	private String dataId;

    private String monitorCode;//监控编码

    private String monitorObj;//监控对象

    private String monitorSegment;//监控环节

    private Date monitorTime;//监控时间

    private String prtnId;//合作伙伴标识

    private String objType;//对象类型
    
    public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getPrtnId() {
		return prtnId;
	}

	public void setPrtnId(String prtnId) {
		this.prtnId = prtnId;
	}

	public String getMonitorCode() {
        return monitorCode;
    }

    public void setMonitorCode(String monitorCode) {
        this.monitorCode = monitorCode == null ? null : monitorCode.trim();
    }

    public String getMonitorObj() {
        return monitorObj;
    }

    public void setMonitorObj(String monitorObj) {
        this.monitorObj = monitorObj == null ? null : monitorObj.trim();
    }

    public String getMonitorSegment() {
        return monitorSegment;
    }

    public void setMonitorSegment(String monitorSegment) {
        this.monitorSegment = monitorSegment == null ? null : monitorSegment.trim();
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }


    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType == null ? null : objType.trim();
    }
}