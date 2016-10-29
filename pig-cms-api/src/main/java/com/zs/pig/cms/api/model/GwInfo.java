//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.zs.pig.common.base.BaseEntity;

/**
 * 
 * @author zsCat 2016-10-13 14:40:15
 * @Email: 951449465@qq.com
 * @version 4.0v 我的官网
 */
@SuppressWarnings({ "unused" })
@Table(name = "gw_info")
public class GwInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Transient
	private List<String> imagesList=new LinkedList<String>(); // 博客里存在的图片 主要用于列表展示显示缩略图
	@Transient
	private String contentNoTag; // 博客内容 无网页标签 Lucene分词用
	
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public List<String> getImagesList() {
		return imagesList;
	}
	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}
	private String name;

	public String getName() {
		return this.getString("name");
	}

	public void setName(String name) {
		this.set("name", name);
	}

	private Boolean display;

	public Boolean getDisplay() {
		return this.getBoolean("display");
	}

	public void setDisplay(Boolean display) {
		this.set("display", display);
	}

	private String content;

	public String getContent() {
		return this.getString("content");
	}

	public void setContent(String content) {
		this.set("content", content);
	}

	private Date addtime;

	public Date getAddtime() {
		return this.getDate("addtime");
	}

	public void setAddtime(Date addtime) {
		this.set("addtime", addtime);
	}

}
