package com.zs.cat.monitor.api.dto;
import java.io.Serializable;
public class TCscMonitorTemplateDTO implements Serializable {
	private static final long serialVersionUID = -1256908263946898203L;
	private String templateId;//模板ID
    private String templateName;//模板名称
    private String templateContent;//模板内容
    private String stat;//状态 S0A:有效 S0X：无效
    private String memo;//备注

   

    public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent == null ? null : templateContent.trim();
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