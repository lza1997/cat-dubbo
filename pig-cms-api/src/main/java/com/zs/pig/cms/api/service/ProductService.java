//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.api.service;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.Product;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

@Service("ProductService")
public interface ProductService extends BaseService<Product> {


	
	/**
	 * 保存或更新
	 * 
	 * @param Product
	 * @return
	 */
	public int saveproduct(Product Product);

	/**
	 * 删除
	* @param Product
	* @return
	 */
	public int deleteProduct(Product Product);


}
