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
import com.zs.pig.cms.api.model.Product;
import com.zs.pig.cms.api.service.ProductService;
	/**
	 * 
	 * @author zsCat 2016-10-13 14:38:37
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("product")
public class ProductController {

	@Resource
	private ProductService ProductService;
	
	@RequestMapping
	public String toProduct(Model model){
		return "gw/product/product";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute Product Product) {
		Product.setAddtime(new Date());
		Product.setClickhit(0);
		return ProductService.saveproduct(Product);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute Product Product){
		return ProductService.deleteProduct(Product);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute Product Product, Model model) {
		PageInfo<Product> page = ProductService.selectPage(pageNum, pageSize, Product);
		model.addAttribute("page", page);
		return "gw/product/product-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		Product product = ProductService.selectByPrimaryKey(id);
		model.addAttribute("product", product);
		return "gw/product/product-save";
	}
	
}
