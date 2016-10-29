package com.zs.pig.web.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsLink;
import com.zs.pig.cms.api.service.CmsLinkService;
	/**
	 * 
	 * @author zs 2016-5-24 22:01:02
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsLink")
public class CmsLinkController {

	@Resource
	private CmsLinkService CmsLinkService;
	
	@RequestMapping
	public String toCmsLink(Model model){
		return "cms/cmsLink/cmsLink";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsLink CmsLink) {
		return CmsLinkService.savecmsLink(CmsLink);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsLink CmsLink){
		return CmsLinkService.deleteCmsLink(CmsLink);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsLink CmsLink, Model model) {
		PageInfo<CmsLink> page = CmsLinkService.selectPage(pageNum, pageSize, CmsLink);
		model.addAttribute("page", page);
		return "cms/cmsLink/cmsLink-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsLink cmsLink = CmsLinkService.selectByPrimaryKey(id);
		model.addAttribute("cmsLink", cmsLink);
		return "cms/cmsLink/cmsLink-save";
	}
	
}
