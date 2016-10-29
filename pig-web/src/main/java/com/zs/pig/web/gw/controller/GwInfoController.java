package com.zs.pig.web.gw.controller;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.GwInfo;
import com.zs.pig.cms.api.service.GwInfoService;
	/**
	 * 
	 * @author zsCat 2016-10-13 14:40:15
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("gwInfo")
public class GwInfoController {

	@Resource
	private GwInfoService GwInfoService;
	
	@RequestMapping
	public String toGwInfo(Model model){
		return "gw/gwInfo/gwInfo";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute GwInfo GwInfo) {
		GwInfo.setAddtime(new Date());
		return GwInfoService.savegwInfo(GwInfo);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute GwInfo GwInfo){
		return GwInfoService.deleteGwInfo(GwInfo);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute GwInfo GwInfo, Model model) {
		PageInfo<GwInfo> page = GwInfoService.selectPage(pageNum, pageSize, GwInfo);
		model.addAttribute("page", page);
		return "gw/gwInfo/gwInfo-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		GwInfo gwInfo = GwInfoService.selectByPrimaryKey(id);
		model.addAttribute("gwInfo", gwInfo);
		return "gw/gwInfo/gwInfo-save";
	}
	
}
