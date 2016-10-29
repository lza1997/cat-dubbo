package com.zs.pig.web.gw.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zs.pig.cms.api.model.ProductType;
import com.zs.pig.cms.api.service.ProductTypeService;
	/**
	 * 
	 * @author zsCat 2016-10-13 14:38:48
	 * @Email: 951449465@qq.com
	 * @version 4.0v
	 *	我的官网
	 */
@Controller
@RequestMapping("productType")
public class ProductTypeController {

	@Resource
	private ProductTypeService ProductTypeService;
	
	@RequestMapping
	public String toProductType(Model model){
		return "gw/productType/productType";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute ProductType ProductType) {
		return ProductTypeService.saveproductType(ProductType);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute ProductType ProductType){
		return ProductTypeService.deleteProductType(ProductType);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute ProductType ProductType, Model model) {
		PageInfo<ProductType> page = ProductTypeService.selectPage(pageNum, pageSize, ProductType);
		model.addAttribute("page", page);
		return "gw/productType/productType-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		ProductType productType = ProductTypeService.selectByPrimaryKey(id);
		model.addAttribute("productType", productType);
		return "gw/productType/productType-save";
	}
	
}
