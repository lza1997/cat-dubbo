package com.zs.pig.web.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zs.pig.cms.api.model.CmsSite;
import com.zs.pig.cms.api.service.CmsSiteService;
import com.zs.pig.common.spring.utils.SpringContextUtil;

public class CmsUtil {
	
	private static final CmsSiteService siteService = SpringContextUtil.getBean(CmsSiteService.class);
	
	//保存在session中的当前站点key
	public static String CURRENT_SITE_STR = "cursite";
	//session中没有当前站点信息是根据name取出当期站点并设置进去
	public static final String DEF_SITE_NAME = "blog";
	
	
	/**
	 * 返回文章上传路径
	 */
	public static String getArticleFilePath(HttpServletRequest request){
		return ServletUtils.getRealPath(request)+"/"+CmsConstants.UPLOAD_FOLDER_NAME+"/"+CmsConstants.ARTICLE_FOLDER_NAME;
	}
	
	/**
	 * 获取当前站点没有就设置
	 */
	public static CmsSite getCurrentSite(){
		
		HttpSession session = getSession();
		if(null != session && null != session.getAttribute(CURRENT_SITE_STR)){
			return (CmsSite) session.getAttribute(CURRENT_SITE_STR);
		}
		CmsSite sCmsSite=new CmsSite();
		sCmsSite.setName(DEF_SITE_NAME);
		CmsSite site = (CmsSite) siteService.selectOne(sCmsSite);
		session.setAttribute(CURRENT_SITE_STR, site);
		return site;
	}

	/**
	 * 得到当前session
	 */
	public static HttpSession getSession() {
		HttpSession session = getCurRequest().getSession();
		return session;
	}
	/**
	 * @Title: getCurRequest
	 * @Description:(获得当前的request) 
	 * @param:@return 
	 * @return:HttpServletRequest
	 */
	public static HttpServletRequest getCurRequest(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if(requestAttributes != null && requestAttributes instanceof ServletRequestAttributes){
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
			return servletRequestAttributes.getRequest();
		}
		return null;
	}
	/**
	 * 切换站点
	 * @param request
	 * @param name
	 */
	public static void changeSite(String name) {
		CmsSite sCmsSite=new CmsSite();
		sCmsSite.setName(name);
		CmsSite site = (CmsSite) siteService.select(sCmsSite);
		getSession().setAttribute(CURRENT_SITE_STR, site);
	}

}
