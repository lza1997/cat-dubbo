package com.pig.web.oa.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pig.web.oa.api.service.NavService;
import com.github.pagehelper.PageInfo;
import com.pig.web.oa.api.model.Nav;
	/**
	 * 
	 * @author zsCat 2016-11-4 17:15:30
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	优惠劵管理
	 */
@Controller
@RequestMapping("nav")
public class NavController {

	@Resource
	private NavService NavService;
	
	@RequestMapping
	public String toNav(Model model){
		return "oa/nav/nav";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute Nav Nav) {
		return NavService.saveNav(Nav);
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
		return "oa/nav/nav-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		Nav nav = NavService.selectByPrimaryKey(id);
		model.addAttribute("nav", nav);
		return "oa/nav/nav-save";
	}
	
}
