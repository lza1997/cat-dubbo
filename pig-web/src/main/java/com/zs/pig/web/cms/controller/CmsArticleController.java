package com.zs.pig.web.cms.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zs.pig.blog.api.model.Blog;
import com.zs.pig.cms.api.model.CmsArticle;
import com.zs.pig.cms.api.service.CmsArticleService;
import com.zs.pig.common.Symphonys;
import com.zs.pig.common.constant.ZsCatConstant;
import com.zs.pig.common.redis.test.RedisUtils;
import com.zs.pig.common.utils.FileUtils;
	/**
	 * 
	 * @author zs 2016-5-24 21:51:40
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的cms
	 */
@Controller
@RequestMapping("cmsArticle")
public class CmsArticleController {

	@Resource
	private CmsArticleService CmsArticleService;
	
	@RequestMapping
	public String toCmsArticle(Model model){
		return "cms/cmsArticle/cmsArticle";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public  String save(@ModelAttribute CmsArticle CmsArticle,HttpServletRequest request,@RequestParam(value="img",required=false) MultipartFile img) {
		//图片上传
		
		String pictureSaveFilePath=ZsCatConstant.pictureSaveFilePath;
		//=request.getRealPath("ZSCAT");
		if (null != img && !img.isEmpty()) {
			try {
				UUID id = UUID.randomUUID();
				// 扩展名格式：
				String extName = "";
				if (img.getOriginalFilename().lastIndexOf(".") >= 0) {
					extName = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));
				}
				CmsArticle.setImage(id+extName);
				System.out.println("pictureSaveFilePath:"+pictureSaveFilePath+",extName:"+extName);
				FileUtils.copyFile(img.getInputStream(), pictureSaveFilePath,id+extName).replaceAll("-", "");
			
			} catch (IOException e) {
			
			}
		}
			String imges="";
			String blogInfo=CmsArticle.getContent();
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src]"); //　查找扩展名是jpg的图片
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				
				if(jpg!=null && jpg!=null){
					String linkHref = jpg.attr("src");
					imges+=linkHref+",";
				}
				if(i==5){
					break;
				}
			}
			CmsArticle.setMoreimage(imges);
			CmsArticle.setCreatedate(new Date());
		    CmsArticleService.savecmsArticle(CmsArticle);
			return "redirect:/index#/ajax/cmsArticle";
	}
	
	//删除图片
		@RequestMapping(value="/deltp")
		public void deltp(PrintWriter out,HttpServletRequest request) {
			try{
				ModelAndView mv = new ModelAndView();
				
//				String tpurl = pd.getString("tpurl");													//图片路径
//				if(tpurl != null){
//					//删除硬盘上的文件 start
//					String xmpath =request.getRealPath("TP");
//					//String xmpath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
//					tpurl = xmpath.trim() + "TP/" + tpurl.trim();
//					//tpurl = tpurl.substring(6);															//去掉 'file:/'
//					File f = new File(tpurl.trim()); 
//					if(f.exists()){
//						f.delete();
//					}else{
//						System.out.println("===="+tpurl+"不存在");
//					}
//					//删除硬盘上的文件 end
//					advService.delTp(pd);														//删除数据中图片数据
//				}	
//					
					out.write("success");
					out.close();
			}catch(Exception e){
			}
		}
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsArticle CmsArticle){
		return CmsArticleService.deleteCmsArticle(CmsArticle);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsArticle CmsArticle, Model model) {
		CmsArticle.setSiteid(Long.parseLong(RedisUtils.get(ZsCatConstant.SITEID,"1")));
		PageInfo<CmsArticle> page = CmsArticleService.selectPage(pageNum, pageSize, CmsArticle,"createDate desc");
		model.addAttribute("page", page);
		return "cms/cmsArticle/cmsArticle-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsArticle cmsArticle = CmsArticleService.selectByPrimaryKey(id);
		model.addAttribute("cmsArticle", cmsArticle);
		
		return "cms/cmsArticle/cmsArticle-save";
	}
	
}
