package com.zs.pig.web.showcase.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zs.pig.common.sys.model.SysArea;

@Controller
@RequestMapping("cms/article")
public class ArticleController {

	@RequestMapping
	public String toArticle(){
		return "cms/article/article";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(HttpServletRequest req) {
		String am=req.getParameter("content");
		
		System.out.println(am);
		return null;
	}
}
