//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.ProductType;
import com.zs.pig.cms.api.service.ProductTypeService;
import com.zs.pig.cms.mapper.ProductTypeMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("ProductTypeService")
public class ProductTypeServiceImpl extends ServiceMybatis<ProductType> implements ProductTypeService {

	@Resource
	private ProductTypeMapper ProductTypeMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param ProductType
	 * @return
	 */
	public int saveproductType(ProductType ProductType) {
		return this.save(ProductType);
	}

	/**
	 * 删除
	* @param ProductType
	* @return
	 */
	public int deleteProductType(ProductType ProductType) {
		return this.delete(ProductType);
	}


}
