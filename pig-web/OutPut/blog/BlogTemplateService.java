//Powered By if, Since 2014 - 2020

package com.zs.pig.blog.api.service;

import com.zs.pig.blog.api.model.BlogTemplate;
import com.zs.pig.common.base.BaseService;

/**
 * 
 * @author
 */

public interface BlogTemplateService extends BaseService<BlogTemplate>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param BlogTemplate
	 * @return
	 */
	public int save(BlogTemplate BlogTemplate) ;
	/**
	 * 删除
	* @param BlogTemplate
	* @return
	 */
	public int deleteBlogTemplate(BlogTemplate BlogTemplate);


}
