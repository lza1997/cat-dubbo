package com.zs.pig.web.cms.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsCategory;
import com.zs.pig.cms.api.service.CmsCategoryService;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;
import com.zs.pig.web.cms.util.CmsUtil;
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
	public String toArea(Model model) {
		CmsCategory CmsCategory =new CmsCategory();
		CmsCategory.setSiteId(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
	//	CmsCategory.setSiteId(CmsUtil.getCurrentSite().getId());
		model.addAttribute("treeList", JSON.toJSONString(CmsCategoryService.select(CmsCategory)));
		return "cms/cmsCategory/cmsCategory";
	}

	/**
	 * 区域树
	 * @return
	 */
	@RequestMapping(value = "tree", method = RequestMethod.POST)
	public @ResponseBody List<CmsCategory> getAreaTreeList() {
		CmsCategory CmsCategory =new CmsCategory();
		//CmsCategory.setSiteId(CmsUtil.getCurrentSite().getId());
		CmsCategory.setSiteId(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
		List<CmsCategory> list = CmsCategoryService.select(CmsCategory);
		return list;
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsCategory CmsCategory,HttpServletRequest request) {
		//CmsCategory.setSiteId(CmsUtil.getCurrentSite().getId());
		CmsCategory.setParentIds(CmsCategory.getParentIds()+CmsCategory.getParentId()+","); 
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
		CmsCategory.setSiteId(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
		PageInfo<CmsCategory> page = CmsCategoryService.selectPage(pageNum, pageSize, CmsCategory);
		model.addAttribute("page", page);
		return "cms/cmsCategory/cmsCategory-list";
	}
	

	@RequestMapping(value = "{mode}/showlayer", method = RequestMethod.POST)
	public String showLayer(Long id, Long parentId,
			@PathVariable("mode") String mode, Model model) {
		CmsCategory cmsCategory = null, pCmsCategory = null;
		if (StringUtils.equalsIgnoreCase(mode, "add")) {
			pCmsCategory = CmsCategoryService.selectByPrimaryKey(parentId);
		} else if (StringUtils.equalsIgnoreCase(mode, "edit")) {
			cmsCategory = CmsCategoryService.selectByPrimaryKey(id);
			pCmsCategory = CmsCategoryService.selectByPrimaryKey(parentId);
		} else if (StringUtils.equalsIgnoreCase(mode, "detail")) {
			cmsCategory = CmsCategoryService.selectByPrimaryKey(id);
			pCmsCategory = CmsCategoryService.selectByPrimaryKey(cmsCategory.getParentId());
		}
		model.addAttribute("pCmsCategory", pCmsCategory).addAttribute("cmsCategory", cmsCategory);
		return mode.equals("detail") ? "cms/cmsCategory/cmsCategory-detail"
				: "cms/cmsCategory/cmsCategory-save";
	}
	
}
