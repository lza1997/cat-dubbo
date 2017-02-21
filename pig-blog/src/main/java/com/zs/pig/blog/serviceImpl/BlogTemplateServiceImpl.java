//Powered By ZSCAT, Since 2014 - 2020

package com.zs.pig.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.blog.api.model.BlogTemplate;
import com.zs.pig.blog.api.service.BlogTemplateService;
import com.zs.pig.blog.mapper.BlogTemplateMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("BlogTemplateService")
public class BlogTemplateServiceImpl extends ServiceMybatis<BlogTemplate> implements BlogTemplateService {

	@Resource
	private BlogTemplateMapper BlogTemplateMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param BlogTemplate
	 * @return
	 */
	public int saveBlogTemplate(BlogTemplate BlogTemplate) {
		return this.save(BlogTemplate);
	}

	/**
	 * 删除
	* @param BlogTemplate
	* @return
	 */
	public int deleteBlogTemplate(BlogTemplate BlogTemplate) {
		return this.delete(BlogTemplate);
	}


}
