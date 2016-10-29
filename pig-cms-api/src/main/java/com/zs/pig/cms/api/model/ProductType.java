//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import javax.persistence.Table;

import com.zs.pig.common.base.BaseEntity;

/**
 * 
 * @author zsCat 2016-10-13 14:38:48
 * @Email: 951449465@qq.com
 * @version 4.0v 我的官网
 */
@SuppressWarnings({ "unused" })
@Table(name = "gw_productType")
public class ProductType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return this.getString("name");
	}

	public void setName(String name) {
		this.set("name", name);
	}

}
