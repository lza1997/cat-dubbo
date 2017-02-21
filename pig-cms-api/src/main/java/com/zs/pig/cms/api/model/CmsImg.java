//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import java.util.Date;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zsCat 2016-10-18 19:49:20
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的官网
 */
@SuppressWarnings({ "unused"})
@Table(name="cms_img")
public class CmsImg extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String title;
public String getTitle() {return this.getString("title");}
public void setTitle(String title) {this.set("title",title);}
private String name;
public String getName() {return this.getString("name");}
public void setName(String name) {this.set("name",name);}
private String path;
public String getPath() {return this.getString("path");}
public void setPath(String path) {this.set("path",path);}
private Date addtime;
public Date getAddtime() {return this.getDate("addtime");}
public void setAddtime(Date addtime) {this.set("addtime",addtime);}
private Long typeid;
public Long getTypeid() {return this.getLong("typeid");}
public void setTypeid(Long typeid) {this.set("typeid",typeid);}


}
