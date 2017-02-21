package com.zs.pig.web.cms.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.CmsImg;
import com.zs.pig.cms.api.service.CmsImgService;
import com.zs.pig.common.utils.DateUtils;
import com.zs.pig.common.utils.FileUpload;
import com.zs.pig.common.utils.PathUtil;
	/**
	 * 
	 * @author zsCat 2016-10-18 19:49:20
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("cmsImg")
public class CmsImgController {

	@Resource
	private CmsImgService CmsImgService;
	
	@RequestMapping
	public String toCmsImg(Model model){
		return "cms/cmsImg/cmsImg";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save")
	public @ResponseBody Object save(@RequestParam(required=false) MultipartFile file,@RequestParam(required=false)String callback) {
		CmsImg CmsImg=new CmsImg();
		String  ffile = DateUtils.getDay(), fileName = null;
		if (null != file && !file.isEmpty()) {
			String filePath = PathUtil.getClasspath() +"uploadFiles/uploadImgs/" + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(file, filePath, System.currentTimeMillis()+"");				//执行上传
		}else{
			System.out.println("上传失败");
		}
		CmsImg.setTitle("tu");
		CmsImg.setName(fileName);
		CmsImg.setPath(ffile + "/" + fileName);
		CmsImg.setAddtime(new Date());
		CmsImgService.savecmsImg(CmsImg);
		Map<String,String> map=new HashMap<String,String>();
		map.put("result", "ok");
		return returnObject(map);
	}

	public static Object returnObject(Map map){
			return map;
		
	}
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CmsImg CmsImg){
		
		return CmsImgService.deleteCmsImg(CmsImg);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CmsImg CmsImg, Model model) {
		PageInfo<CmsImg> page = CmsImgService.selectPage(pageNum, pageSize, CmsImg);
		model.addAttribute("page", page);
		return "cms/cmsImg/cmsImg-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CmsImg cmsImg = CmsImgService.selectByPrimaryKey(id);
		model.addAttribute("cmsImg", cmsImg);
		return "cms/cmsImg/cmsImg-save";
	}
	
}
