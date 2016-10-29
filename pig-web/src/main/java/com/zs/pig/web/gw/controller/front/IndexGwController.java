package com.zs.pig.web.gw.controller.front;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.GwInfo;
import com.zs.pig.cms.api.model.Nav;
import com.zs.pig.cms.api.model.Product;
import com.zs.pig.cms.api.service.GwInfoService;
import com.zs.pig.cms.api.service.NavService;
import com.zs.pig.cms.api.service.ProductService;
import com.zs.pig.cms.api.service.ProductTypeService;
	/**
	 * 
	 * @author zs 2016-5-5 11:33:51
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的blog
	 */
@Controller
@RequestMapping("gw")
public class IndexGwController {

	@Resource
	private GwInfoService GwInfoService;
	@Resource
	private NavService NavService;
	@Resource
	private ProductService ProductService;
	@Resource
	private ProductTypeService ProductTypeService;
	/**
	 * 请求主页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView index()throws Exception{
		ModelAndView mav=new ModelAndView();
		//首页顶部导航
		Nav nav=new Nav();
		nav.setDisplay(true);
		nav.setType("0");
		mav.addObject("navList", NavService.select(nav, "sequence asc"));
		
		//项目
		PageInfo<Product> page = ProductService.selectPage(1, 9, null);
		for(Product blog:page.getList()){
			List<String> imagesList=blog.getImagesList();
			String blogInfo=blog.getRemark();
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src]"); //　查找扩展名是jpg的图片
			if(jpgs!=null && jpgs.size()>0){
			Element jpg=jpgs.get(0);
				if(jpgs!=null && jpg!=null){
					String linkHref = jpg.attr("src");
					blog.setImg(linkHref);
				}
			}
			
		}
		mav.addObject("productList", page.getList());
		//信息
		GwInfo gwInfo=new GwInfo();
		gwInfo.setDisplay(true);
		mav.addObject("infoList", GwInfoService.select(gwInfo, "addTime"));
		mav.setViewName("gw/index");
		return mav;
	}
	
	@RequestMapping(value = "productList")
	public String productList(int pageNum,int pageSize,@ModelAttribute Product Product, Model model) {
		PageInfo<Product> page = ProductService.selectPage(pageNum, pageSize, Product);
		model.addAttribute("page", page);
		return "gw/productList";
	}
	/**
	 * 产品详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/{id}")
	public ModelAndView productDetails(@PathVariable("id") Long id,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		Product product=ProductService.selectByPrimaryKey(id);
		mav.addObject("product", product);
		product.setClickhit(product.getClickhit()+1); // 博客点击次数加1
		ProductService.updateByPrimaryKeySelective(product);
		
		mav.setViewName("gw/productDetail");
		return mav;
	}
	
	@RequestMapping("/gwInfo/{id}")
	public ModelAndView gwInfoDetails(@PathVariable("id") Long id,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		GwInfo info=GwInfoService.selectByPrimaryKey(id);
		mav.addObject("info", info);
		
		mav.setViewName("gw/info");
		return mav;
	}
	
	
}
