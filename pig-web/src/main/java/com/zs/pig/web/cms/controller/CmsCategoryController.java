package com.zs.pig.web.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsCategory;
import com.zs.pig.cms.api.service.CmsCategoryService;
	/**
	 * 
	 * @author zs 2016-5-24 21:52:07
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsCategory")
public class CmsCategoryController {

	@Resource
	private CmsCategoryService CmsCategoryService;
	
	@RequestMapping
	public String toCmsCategory(Model model){
		return "cms/cmsCategory/cmsCategory";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsCategory CmsCategory) {
		return CmsCategoryService.savecmsCategory(CmsCategory);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsCategory CmsCategory){
		return CmsCategoryService.deleteCmsCategory(CmsCategory);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsCategory CmsCategory, Model model) {
		PageInfo<CmsCategory> page = CmsCategoryService.selectPage(pageNum, pageSize, CmsCategory);
		model.addAttribute("page", page);
		return "cms/cmsCategory/cmsCategory-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsCategory cmsCategory = CmsCategoryService.selectByPrimaryKey(id);
		model.addAttribute("cmsCategory", cmsCategory);
		return "cms/cmsCategory/cmsCategory-save";
	}
	
}
