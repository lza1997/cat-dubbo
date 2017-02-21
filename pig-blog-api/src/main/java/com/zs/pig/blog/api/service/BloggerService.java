//Powered By zsCat, Since 2016 - 2020

package com.zs.pig.blog.api.service;

import com.zs.pig.blog.api.model.Blogger;
import com.zs.pig.common.base.BaseService;

/**
* @author zsCat 2016-6-14 13:56:18
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

public interface BloggerService extends BaseService<Blogger>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Blogger
	 * @return
	 */
	public int saveBlogger(Blogger record) ;
	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteBlogger(Blogger record);
	public Blogger checkBlogger(String username, String password);


}
