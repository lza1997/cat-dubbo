//Powered By zsCat, Since 2016 - 2020

package com.zs.pig.blog.api.service;

import com.zs.pig.blog.api.model.Link;
import com.zs.pig.common.base.BaseService;

/**
* @author zsCat 2016-6-14 13:57:04
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

public interface LinkService extends BaseService<Link>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Link
	 * @return
	 */
	public int saveLink(Link record) ;
	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteLink(Link record);


}
