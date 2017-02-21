//Powered By zsCat, Since 2014 - 2020

package com.zs.pig.blog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.blog.api.model.Blogger;
import com.zs.pig.blog.api.service.BloggerService;
import com.zs.pig.blog.mapper.BloggerMapper;
import com.zs.pig.common.base.ServiceMybatis;
import com.zs.pig.common.utils.PasswordEncoder;

/**
* @author zsCat 2016-6-14 13:56:18
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

@Service("BloggerService")
public class BloggerServiceImpl extends ServiceMybatis<Blogger> implements BloggerService {

	@Resource
	private BloggerMapper BloggerMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Blogger
	 * @return
	 */
	public int saveBlogger(Blogger record) {
		return this.save(record);
	}

	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteBlogger(Blogger record) {
		return this.delete(record);
	}

	@Override
	public Blogger checkBlogger(String username, String password) {
		Blogger sysUser = new Blogger();
		String secPwd = PasswordEncoder.encrypt(password, username);
		sysUser.setUsername(username);
		sysUser.setPassword(secPwd);
		List<Blogger> users = this.select(sysUser);
		if(users != null && users.size() == 1 && users.get(0) != null) {
			return users.get(0);
		}
		return null;
	}


}
