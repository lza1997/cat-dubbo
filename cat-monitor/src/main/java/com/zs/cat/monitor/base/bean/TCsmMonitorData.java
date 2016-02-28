package com.zs.cat.monitor.base.bean;
import java.util.Date;
import com.bestpay.bpcs.commons.common.page.BaseBean;
public class TCsmMonitorData extends BaseBean{
	private static final long serialVersionUID = -393269925082767298L;

	private String dataId;

    private String monitorCode;

    private String monitorObj;

    private String monitorSegment;

    private Date monitorTime;

    private String prtnId;

    private String objType;




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

	public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType == null ? null : objType.trim();
    }
}