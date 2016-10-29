package com.zs.pig.common.beetl.function;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zs.pig.cms.api.model.ProductType;
import com.zs.pig.cms.api.service.ProductTypeService;

@Component
public class SelectFunctions {
	
	@Resource
	private ProductTypeService ProductTypeService;
	
	/**
	 * 得到所有产品类型
	 */
	public List<ProductType> getProductType(){
		return ProductTypeService.select(null);
	}
	
	
	
}
