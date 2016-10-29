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
 * @author zsCat 2016-10-13 14:38:37
 * @Email: 951449465@qq.com
 * @version 4.0v 我的官网
 */
@SuppressWarnings({ "unused" })
@Table(name = "gw_product")
public class Product extends BaseEntity {

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
	private String title;

	public String getTitle() {
		return this.getString("title");
	}

	public void setTitle(String title) {
		this.set("title", title);
	}

	private String tag;
	private String typename;

	public String getTypename() {
		return this.getString("typename");
	}

	public void setTypename(String typename) {
		this.set("typename", typename);
	}
	public String getTag() {
		return this.getString("tag");
	}

	public void setTag(String tag) {
		this.set("tag", tag);
	}

	private String remark;

	public String getRemark() {
		return this.getString("remark");
	}

	public void setRemark(String remark) {
		this.set("remark", remark);
	}

	private String summary;

	public String getSummary() {
		return this.getString("summary");
	}

	public void setSummary(String summary) {
		this.set("summary", summary);
	}

	private Date addtime;

	public Date getAddtime() {
		return this.getDate("addtime");
	}

	public void setAddtime(Date addtime) {
		this.set("addtime", addtime);
	}

	private int clickhit;

	public int getClickhit() {
		return this.getInteger("clickhit");
	}

	public void setClickhit(int clickhit) {
		this.set("clickhit", clickhit);
	}

	private String type;

	public String getType() {
		return this.getString("type");
	}

	public void setType(String type) {
		this.set("type", type);
	}

	private String img;

	public String getImg() {
		return this.getString("img");
	}

	public void setImg(String img) {
		this.set("img", img);
	}

}
