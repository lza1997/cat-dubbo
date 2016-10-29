//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zs 2016-5-24 21:51:02
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的cms
 */
@SuppressWarnings({ "unused"})
@Table(name="cms_site")
public class CmsSite extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String copyright;
public String getCopyright() {return this.getString("copyright");}
public void setCopyright(String copyright) {this.set("copyright",copyright);}
private String description;
public String getDescription() {return this.getString("description");}
public void setDescription(String description) {this.set("description",description);}
private String keywords;
public String getKeywords() {return this.getString("keywords");}
public void setKeywords(String keywords) {this.set("keywords",keywords);}
private String logo;
public String getLogo() {return this.getString("logo");}
public void setLogo(String logo) {this.set("logo",logo);}
private String name;
public String getName() {return this.getString("name");}
public void setName(String name) {this.set("name",name);}
private String theme;
public String getTheme() {return this.getString("theme");}
public void setTheme(String theme) {this.set("theme",theme);}
private String title;
public String getTitle() {return this.getString("title");}
public void setTitle(String title) {this.set("title",title);}


}
