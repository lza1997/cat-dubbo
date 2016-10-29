//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import java.util.Date;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zs 2016-5-24 21:53:44
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的cms
 */
@SuppressWarnings({ "unused"})
@Table(name="cms_comment")
public class CmsComment extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private Date auditdate;
public Date getAuditdate() {return this.getDate("auditdate");}
public void setAuditdate(Date auditdate) {this.set("auditdate",auditdate);}
private String content;
public String getContent() {return this.getString("content");}
public void setContent(String content) {this.set("content",content);}
private Date createdate;
public Date getCreatedate() {return this.getDate("createdate");}
public void setCreatedate(Date createdate) {this.set("createdate",createdate);}
private Integer delflag;
public Integer getDelflag() {return this.getInteger("delflag");}
public void setDelflag(Integer delflag) {this.set("delflag",delflag);}
private String email;
public String getEmail() {return this.getString("email");}
public void setEmail(String email) {this.set("email",email);}
private String ip;
public String getIp() {return this.getString("ip");}
public void setIp(String ip) {this.set("ip",ip);}
private String name;
public String getName() {return this.getString("name");}
public void setName(String name) {this.set("name",name);}
private String url;
public String getUrl() {return this.getString("url");}
public void setUrl(String url) {this.set("url",url);}
private Long articleId;
public Long getArticleId() {return this.getLong("articleId");}
public void setArticleId(Long articleId) {this.set("articleId",articleId);}
private Long auditerId;
public Long getAuditerId() {return this.getLong("auditerId");}
public void setAuditerId(Long auditerId) {this.set("auditerId",auditerId);}
private String headpath;
public String getHeadpath() {return this.getString("headpath");}
public void setHeadpath(String headpath) {this.set("headpath",headpath);}


}
