package com.zs.pig.web.sys.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zs.pig.common.sys.model.Demo;
import com.zs.pig.web.sys.service.DemoService;
	/**
	 * 
	 * @author zsCat 2016-10-20 18:00:56
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("demo")
public class DemoController {

	@Resource
	private DemoService DemoService;
	
	@RequestMapping
	public String toDemo(Model model){
		return "demo/demo/demo";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(HttpServletRequest request,@RequestParam(value="img",required=false) MultipartFile img,@ModelAttribute Demo Demo) {
		//图片上传
				String pictureSaveFilePath =request.getRealPath("TP");
				if (null != img && !img.isEmpty()) {
					try {
						UUID id = UUID.randomUUID();
						// 扩展名格式：
						String extName = "";
						if (img.getOriginalFilename().lastIndexOf(".") >= 0) {
							extName = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));
						}
						Demo.setName(id+extName);
						System.out.println("pictureSaveFilePath:"+pictureSaveFilePath+",extName:"+extName);
						this.copyFile(img.getInputStream(), pictureSaveFilePath,id+extName).replaceAll("-", "");
					
					} catch (IOException e) {
					
					}
				}
					 DemoService.savedemo(Demo);
					return "redirect:/index#/ajax/demo";
	}
	
				/**
				 * 写文件到当前目录的upload目录中
				 * 
				 * @param in
				 * @param fileName
				 * @throws IOException
				 */
				private String copyFile(InputStream in, String dir, String realName)
						throws IOException {
					File file = new File(dir, realName);
					if (!file.exists()) {
						if (!file.getParentFile().exists()) {
							file.getParentFile().mkdirs();
						}
						file.createNewFile();
					}
					FileUtils.copyInputStreamToFile(in, file);
					return realName;
				}
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute Demo Demo){
		return DemoService.deleteDemo(Demo);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute Demo Demo, Model model) {
		PageInfo<Demo> page = DemoService.selectPage(pageNum, pageSize, Demo);
		model.addAttribute("page", page);
		return "demo/demo/demo-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		Demo demo = DemoService.selectByPrimaryKey(id);
		model.addAttribute("demo", demo);
		return "demo/demo/demo-save";
	}
	
}
