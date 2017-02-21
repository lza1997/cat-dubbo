//Powered By zsCat, Since 2014 - 2020

package com.zs.pig.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.blog.api.model.Blog;
import com.zs.pig.blog.api.service.BlogService;
import com.zs.pig.blog.mapper.BlogMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
* @author zsCat 2016-6-14 13:56:03
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

@Service("BlogService")
public class BlogServiceImpl extends ServiceMybatis<Blog> implements BlogService {

	@Resource
	private BlogMapper BlogMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Blog
	 * @return
	 */
	public int saveBlog(Blog record) {
		return this.save(record);
	}

	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteBlog(Blog record) {
		return this.delete(record);
	}

	/**
	 * 获取上一个博客
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Long id){
		return BlogMapper.getLastBlog(id);
	}
	
	/**
	 * 获取下一个博客
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Long id){
		return BlogMapper.getNextBlog(id);
	}

}
