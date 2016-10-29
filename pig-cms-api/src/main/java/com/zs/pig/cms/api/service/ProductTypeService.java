//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import com.zs.pig.cms.api.model.ProductType;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */


public interface ProductTypeService extends BaseService<ProductType> {

	
	
	/**
	 * 保存或更新
	 * 
	 * @param ProductType
	 * @return
	 */
	public int saveproductType(ProductType ProductType) ;

	/**
	 * 删除
	* @param ProductType
	* @return
	 */
	public int deleteProductType(ProductType ProductType) ;


}
