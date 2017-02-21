//Powered By zsCat, Since 2016 - 2020

package com.zs.pig.blog.api.service;

import com.zs.pig.blog.api.model.Comment;
import com.zs.pig.common.base.BaseService;

/**
* @author zsCat 2016-6-14 13:56:49
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

public interface CommentService extends BaseService<Comment>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Comment
	 * @return
	 */
	public int saveComment(Comment record) ;
	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteComment(Comment record);


}
