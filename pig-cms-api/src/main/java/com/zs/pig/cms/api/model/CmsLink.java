//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import java.util.Date;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zs 2016-5-24 22:01:02
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的cms
 */
@SuppressWarnings({ "unused"})
@Table(name="cms_link")
public class CmsLink extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String color;
public String getColor() {return this.getString("color");}
public void setColor(String color) {this.set("color",color);}
private String href;
public String getHref() {return this.getString("href");}
public void setHref(String href) {this.set("href",href);}
private String image;
public String getImage() {return this.getString("image");}
public void setImage(String image) {this.set("image",image);}
private String title;
public String getTitle() {return this.getString("title");}
public void setTitle(String title) {this.set("title",title);}
private Integer weight;
public Integer getWeight() {return this.getInteger("weight");}
public void setWeight(Integer weight) {this.set("weight",weight);}
private Date weightdate;
public Date getWeightdate() {return this.getDate("weightdate");}
public void setWeightdate(Date weightdate) {this.set("weightdate",weightdate);}
private Long categoryId;
public Long getCategoryId() {return this.getLong("categoryId");}
public void setCategoryId(Long categoryId) {this.set("categoryId",categoryId);}


}
