package com.zs.pig.web.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsSite;
import com.zs.pig.cms.api.service.CmsSiteService;
	/**
	 * 
	 * @author zs 2016-5-24 21:51:02
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsSite")
public class CmsSiteController {

	@Resource
	private CmsSiteService CmsSiteService;
	
	@RequestMapping
	public String toCmsSite(Model model){
		return "cms/cmsSite/cmsSite";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsSite CmsSite) {
		return CmsSiteService.savecmsSite(CmsSite);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsSite CmsSite){
		return CmsSiteService.deleteCmsSite(CmsSite);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsSite CmsSite, Model model) {
		PageInfo<CmsSite> page = CmsSiteService.selectPage(pageNum, pageSize, CmsSite);
		model.addAttribute("page", page);
		return "cms/cmsSite/cmsSite-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsSite cmsSite = CmsSiteService.selectByPrimaryKey(id);
		model.addAttribute("cmsSite", cmsSite);
		return "cms/cmsSite/cmsSite-save";
	}
	
}
