package com.zs.pig.web.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.cms.api.service.CmsArticleService;
	/**
	 * 
	 * @author zs 2016-5-24 21:51:40
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsArticle")
public class CmsArticleController {

	@Resource
	private CmsArticleService CmsArticleService;
	
	@RequestMapping
	public String toCmsArticle(Model model){
		return "cms/cmsArticle/cmsArticle";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsArticle CmsArticle) {
		return CmsArticleService.savecmsArticle(CmsArticle);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsArticle CmsArticle){
		return CmsArticleService.deleteCmsArticle(CmsArticle);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsArticle CmsArticle, Model model) {
		PageInfo<CmsArticle> page = CmsArticleService.selectPage(pageNum, pageSize, CmsArticle);
		model.addAttribute("page", page);
		return "cms/cmsArticle/cmsArticle-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsArticle cmsArticle = CmsArticleService.selectByPrimaryKey(id);
		model.addAttribute("cmsArticle", cmsArticle);
		return "cms/cmsArticle/cmsArticle-save";
	}
	
}
