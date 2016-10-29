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
import com.zs.pig.cms.api.model.Nav;
import com.zs.pig.cms.api.service.NavService;
	/**
	 * 
	 * @author zsCat 2016-10-13 14:37:49
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("nav")
public class NavController {

	@Resource
	private NavService NavService;
	
	@RequestMapping
	public String toNav(Model model){
		return "gw/nav/nav";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute Nav Nav) {
		Nav.setAddtime(new Date());
		return NavService.savenav(Nav);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute Nav Nav){
		return NavService.deleteNav(Nav);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute Nav Nav, Model model) {
		PageInfo<Nav> page = NavService.selectPage(pageNum, pageSize, Nav);
		model.addAttribute("page", page);
		return "gw/nav/nav-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		Nav nav = NavService.selectByPrimaryKey(id);
		model.addAttribute("nav", nav);
		return "gw/nav/nav-save";
	}
	
}
