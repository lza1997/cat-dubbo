package com.zs.pig.common.beetl.function;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zs.pig.blog.api.model.Blog;
import com.zs.pig.blog.api.model.BlogType;
import com.zs.pig.blog.api.service.BlogService;
import com.zs.pig.blog.api.service.BlogTemplateService;
import com.zs.pig.blog.api.service.BlogTypeService;
import com.zs.pig.blog.api.service.BloggerService;
import com.zs.pig.blog.api.service.CommentService;
import com.zs.pig.blog.api.service.LinkService;

@Component
public class BlogFunction {

	@Resource
	private BlogTemplateService BlogTemplateService;

	
		
	@Resource
	private BlogService blogService;
	@Resource
	private CommentService CommentService;
	@Resource
	private BlogTypeService BlogTypeService;
	@Resource
	private BloggerService BloggerService;
	@Resource
	private LinkService LinkService;
	
	public List<BlogType> getAllType(){
		return BlogTypeService.select(new BlogType());
	}
	public List<Blog> getAllBlog(){
		return blogService.select(new Blog());
	}
	
	

}
