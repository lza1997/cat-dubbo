//Powered By if, Since 2014 - 2020

package com.zs.pig.common.sys.model;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.zs.pig.common.base.BaseEntity;


/**
 * 
 * @author zsCat 2016-10-20 18:00:56
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的官网
 */
@SuppressWarnings({ "unused"})
@Table(name="t_demo")
public class Demo extends BaseEntity {

	private static final long serialVersionUID = 1L;

  		 private String name;
public String getName() {return this.getString("name");}
public void setName(String name) {this.set("name",name);}
private String password;
public String getPassword() {return this.getString("password");}
public void setPassword(String password) {this.set("password",password);}
@DateTimeFormat( pattern = "yyyy-MM-dd" )
private Date addtime;
public Date getAddtime() {return this.getDate("addtime");}
public void setAddtime(Date addtime) {this.set("addtime",addtime);}


}
