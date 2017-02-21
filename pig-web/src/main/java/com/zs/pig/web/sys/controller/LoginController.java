package com.zs.pig.web.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.cms.api.model.CmsSite;
import com.zs.pig.cms.api.service.CmsSiteService;
import com.zs.pig.common.constant.Constant;
import com.zs.pig.common.sys.model.SysResource;
import com.zs.pig.common.sys.model.SysUser;
import com.zs.pig.common.utils.IPUtils;
import com.zs.pig.web.sys.service.SysResourceService;
import com.zs.pig.web.sys.service.SysUserService;
import com.zs.pig.web.sys.utils.SysUserUtils;

@Controller
public class LoginController {

	@Resource
	private SysResourceService sysResourceService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private CmsSiteService CmsSiteService;
	
	/**
	 * 管理主页
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/index")
	public String toIndex(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("code"); // 清除code
		if( SysUserUtils.getSessionLoginUser() == null || 
				SysUserUtils.getCacheLoginUser() ==null ){
			return "login";
		}
		model.addAttribute("siteLists", CmsSiteService.select(new CmsSite()));
		model.addAttribute("pmenuList", sysResourceService.selectTop(0L));
		model.addAttribute("menuLists", SysUserUtils.getUserMenus());
		String id = request.getParameter("order");
		if (id != null && !id.equals("")) {
			SysResource record=new SysResource();
			record.setParentId(Long.parseLong(id));
			List<SysResource> resourceList=sysResourceService.select(record, "sort");
			
			request.setAttribute("menuList", resourceList);
		}else{
			SysResource record=new SysResource();
			record.setParentId(Long.parseLong("188"));
			List<SysResource> resourceList=sysResourceService.select(record, "sort");
			
			request.setAttribute("menuList", resourceList);
		}
		return "index";
	}
	@RequestMapping(value="/indexBak")
	public String toIndexBak(Model model, HttpServletRequest request) {
		request.getSession().removeAttribute("code"); // 清除code
		if( SysUserUtils.getSessionLoginUser() == null || 
				SysUserUtils.getCacheLoginUser() ==null ){
			return "login";
		}
		model.addAttribute("siteLists", CmsSiteService.select(new CmsSite()));
		model.addAttribute("pmenuList", sysResourceService.selectTop(0L));
		model.addAttribute("menuLists", SysUserUtils.getUserMenus());
		return "index";
	}
	@RequestMapping("/ajax-bna")
	public String ajaxindex(HttpServletRequest request) {
		try {
			String id = request.getParameter("order");
			if (id != null && !id.equals("")) {
				SysResource record=new SysResource();
				record.setParentId(Long.parseLong(id));
				List<SysResource> resourceList=sysResourceService.select(record, "sort");
				
				request.setAttribute("menuList", resourceList);
			}
		} catch (Exception e) {

		}
		return "ajax-index";
	}
	@Deprecated
	@RequestMapping("/ajax-bnaBak")
	public @ResponseBody List<SysResource> bnaBak(HttpServletRequest request) {
		List<SysResource> resourceList=null;
		try {
			String id = request.getParameter("order");
			if (id != null && !id.equals("")) {
				SysResource record=new SysResource();
				record.setParentId(Long.parseLong(id));
				 resourceList=sysResourceService.select(record, "sort");
				
			//	request.setAttribute("menuList", resourceList);
			}
		} catch (Exception e) {

		}
		return resourceList;
	}
	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin() {
		if( SysUserUtils.getSessionLoginUser() != null && SysUserUtils.getCacheLoginUser() !=null ){
			return "redirect:/index";
		}
		return "login";
	}
	
	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkLogin(String username,
			String password, String code, HttpServletRequest request) {

		Map<String, Object> msg = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		code = StringUtils.trim(code);
		username = StringUtils.trim(username);
		password = StringUtils.trim(password);
		Object scode = session.getAttribute("code");
		String sessionCode = null;
		if (scode != null)
			sessionCode = scode.toString();
		if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {
			msg.put("error", "验证码错误");
			return msg;
		}
		SysUser user = sysUserService.checkUser(username, password);
		if (null != user) {
			
			session.setAttribute(Constant.SESSION_LOGIN_USER, user);
			
			//缓存用户
			SysUserUtils.cacheLoginUser(user);
			
			//设置并缓存用户认证
			SysUserUtils.setUserAuth();
			
			//TODO 暂时，后续移动到日志中
			//更新用户最后登录ip和date
			SysUser newUser = new SysUser();
			newUser.setLoginDate(new Date());
			newUser.setLoginIp(IPUtils.getClientAddress(request));
			newUser.setId(user.getId());
			sysUserService.updateByPrimaryKeySelective(newUser);
		} else {
			msg.put("error", "用户名或密码错误");
		}
		return msg;
	}

	/**
	 * 用户退出
	 * 
	 * @return 跳转到登录页面
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		SysUserUtils.clearCacheUser(SysUserUtils.getSessionLoginUser().getId());
		request.getSession().invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping("notauth")
	public String notAuth(){
		return "notauth";
	}
	
	@RequestMapping("notlogin")
	public String notLogin(){
		return "notlogin";
	}

}
