//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.zs.pig.common.base.BaseEntity;

/**
 * 
 * @author zs 2016-5-24 21:51:40
 * @Email: 951449465@qq.com
 * @version 4.0v 我的cms
 */
@SuppressWarnings({ "unused" })
@Table(name = "cms_article")
public class CmsArticle extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Transient
	List<String> imgList;
	
	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	private String color;
	private String moreimage;
	private String categoryname;
	
	public String getCategoryname() {
		return this.getString("categoryname");
	}

	public void setCategoryname(String categoryname) {
		this.set("categoryname", categoryname);
	}
	
	public String getMoreimage() {
		return this.getString("moreimage");
	}

	public void setMoreimage(String moreimage) {
		this.set("moreimage", moreimage);
	}
	public String getColor() {
		return this.getString("color");
	}

	public void setColor(String color) {
		this.set("color", color);
	}

	private String content;

	public String getContent() {
		return this.getString("content");
	}

	public void setContent(String content) {
		this.set("content", content);
	}

	private Date createdate;

	public Date getCreatedate() {
		return this.getDate("createdate");
	}

	public void setCreatedate(Date createdate) {
		this.set("createdate", createdate);
	}

	private String description;

	public String getDescription() {
		return this.getString("description");
	}

	public void setDescription(String description) {
		this.set("description", description);
	}

	private Integer hits;

	public Integer getHits() {
		return this.getInteger("hits");
	}

	public void setHits(Integer hits) {
		this.set("hits", hits);
	}

	private String htmlid;

	public String getHtmlid() {
		return this.getString("htmlid");
	}

	public void setHtmlid(String htmlid) {
		this.set("htmlid", htmlid);
	}

	private String image;

	public String getImage() {
		return this.getString("image");
	}

	public void setImage(String image) {
		this.set("image", image);
	}

	private Integer isword;

	public Integer getIsword() {
		return this.getInteger("isword");
	}

	public void setIsword(Integer isword) {
		this.set("isword", isword);
	}

	private String keywords;

	public String getKeywords() {
		return this.getString("keywords");
	}

	public void setKeywords(String keywords) {
		this.set("keywords", keywords);
	}

	private String title;

	public String getTitle() {
		return this.getString("title");
	}

	public void setTitle(String title) {
		this.set("title", title);
	}

	private Integer weight;

	public Integer getWeight() {
		return this.getInteger("weight");
	}

	public void setWeight(Integer weight) {
		this.set("weight", weight);
	}

	private Long siteid;

	public Long getSiteid() {
		return this.getLong("siteid");
	}

	public void setSiteid(Long siteid) {
		this.set("siteid", siteid);
	}
	private Long categoryId;

	public Long getCategoryId() {
		return this.getLong("categoryId");
	}

	public void setCategoryId(Long categoryId) {
		this.set("categoryId", categoryId);
	}

	private Integer delflag;

	public Integer getDelflag() {
		return this.getInteger("delflag");
	}

	public void setDelflag(Integer delflag) {
		this.set("delflag", delflag);
	}

	private Date updatedate;

	public Date getUpdatedate() {
		return this.getDate("updatedate");
	}

	public void setUpdatedate(Date updatedate) {
		this.set("updatedate", updatedate);
	}

	private Long createbyId;

	public Long getCreatebyId() {
		return this.getLong("createbyId");
	}

	public void setCreatebyId(Long createbyId) {
		this.set("createbyId", createbyId);
	}

	private Long updatebyId;

	public Long getUpdatebyId() {
		return this.getLong("updatebyId");
	}

	public void setUpdatebyId(Long updatebyId) {
		this.set("updatebyId", updatebyId);
	}

}
