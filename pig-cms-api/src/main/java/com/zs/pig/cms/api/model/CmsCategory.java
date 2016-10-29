//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zs 2016-5-24 21:52:07
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的cms
 */
@SuppressWarnings({ "unused"})
@Table(name="cms_category")
public class CmsCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String description;
public String getDescription() {return this.getString("description");}
public void setDescription(String description) {this.set("description",description);}
private String image;
public String getImage() {return this.getString("image");}
public void setImage(String image) {this.set("image",image);}
private String keywords;
public String getKeywords() {return this.getString("keywords");}
public void setKeywords(String keywords) {this.set("keywords",keywords);}
private String module;
public String getModule() {return this.getString("module");}
public void setModule(String module) {this.set("module",module);}
private String name;
public String getName() {return this.getString("name");}
public void setName(String name) {this.set("name",name);}
private Long parentId;
public Long getParentId() {return this.getLong("parentId");}
public void setParentId(Long parentId) {this.set("parentId",parentId);}
private Integer grade;
public Integer getGrade() {return this.getInteger("grade");}
public void setGrade(Integer grade) {this.set("grade",grade);}
private Integer isshow;
public Integer getIsshow() {return this.getInteger("isshow");}
public void setIsshow(Integer isshow) {this.set("isshow",isshow);}
private Integer orderno;
public Integer getOrderno() {return this.getInteger("orderno");}
public void setOrderno(Integer orderno) {this.set("orderno",orderno);}
private Long siteId;
public Long getSiteId() {return this.getLong("siteId");}
public void setSiteId(Long siteId) {this.set("siteId",siteId);}
private String url;
public String getUrl() {return this.getString("url");}
public void setUrl(String url) {this.set("url",url);}


}
