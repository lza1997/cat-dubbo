//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.Product;
import com.zs.pig.cms.api.service.ProductService;
import com.zs.pig.cms.mapper.ProductMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("ProductService")
public class ProductServiceImpl extends ServiceMybatis<Product> implements ProductService{

	@Resource
	private ProductMapper ProductMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Product
	 * @return
	 */
	public int saveproduct(Product Product) {
		return this.save(Product);
	}

	/**
	 * 删除
	* @param Product
	* @return
	 */
	public int deleteProduct(Product Product) {
		return this.delete(Product);
	}


}
