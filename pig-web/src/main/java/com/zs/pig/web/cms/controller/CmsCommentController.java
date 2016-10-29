package com.zs.pig.web.cms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsComment;
import com.zs.pig.cms.api.service.CmsCommentService;
	/**
	 * 
	 * @author zs 2016-5-24 21:53:44
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsComment")
public class CmsCommentController {

	@Resource
	private CmsCommentService CmsCommentService;
	
	@RequestMapping
	public String toCmsComment(Model model){
		return "cms/cmsComment/cmsComment";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CmsComment CmsComment) {
		return CmsCommentService.savecmsComment(CmsComment);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsComment CmsComment){
		return CmsCommentService.deleteCmsComment(CmsComment);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsComment CmsComment, Model model) {
		PageInfo<CmsComment> page = CmsCommentService.selectPage(pageNum, pageSize, CmsComment);
		model.addAttribute("page", page);
		return "cms/cmsComment/cmsComment-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsComment cmsComment = CmsCommentService.selectByPrimaryKey(id);
		model.addAttribute("cmsComment", cmsComment);
		return "cms/cmsComment/cmsComment-save";
	}
	
}
