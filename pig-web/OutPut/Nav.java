//Powered By ZSCAT, Since 2014 - 2020

package com.zs.pig.oa.api.model;

import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zsCat 2016-11-4 17:15:30
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	优惠劵管理
 */
@SuppressWarnings({ "unused"})
@Table(name="gw_nav")
public class Nav extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 @DateTimeFormat( pattern = "yyyy-MM-dd" )
private Date addtime;
public Date getAddtime() {return this.getDate("addtime");}
public void setAddtime(Date addtime) {this.set("addtime",addtime);}
private Boolean display;
public Boolean getDisplay() {return this.getBoolean("display");}
public void setDisplay(Boolean display) {this.set("display",display);}
private Integer location;
public Integer getLocation() {return this.getInteger("location");}
public void setLocation(Integer location) {this.set("location",location);}
private Integer newWin;
public Integer getNewWin() {return this.getInteger("newWin");}
public void setNewWin(Integer newWin) {this.set("newWin",newWin);}
private Integer sequence;
public Integer getSequence() {return this.getInteger("sequence");}
public void setSequence(Integer sequence) {this.set("sequence",sequence);}
private String title;
public String getTitle() {return this.getString("title");}
public void setTitle(String title) {this.set("title",title);}
private String type;
public String getType() {return this.getString("type");}
public void setType(String type) {this.set("type",type);}
private String url;
public String getUrl() {return this.getString("url");}
public void setUrl(String url) {this.set("url",url);}
private String originalUrl;
public String getOriginalUrl() {return this.getString("originalUrl");}
public void setOriginalUrl(String originalUrl) {this.set("originalUrl",originalUrl);}


}