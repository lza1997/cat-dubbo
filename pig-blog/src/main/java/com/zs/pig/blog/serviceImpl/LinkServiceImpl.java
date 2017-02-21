//Powered By zsCat, Since 2014 - 2020

package com.zs.pig.blog.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.blog.api.model.Link;
import com.zs.pig.blog.api.service.LinkService;
import com.zs.pig.blog.mapper.LinkMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
* @author zsCat 2016-6-14 13:57:04
 * @Email: 951449465@qq.com
 * @version 4.0v
 *	我的blog
 */

@Service("LinkService")
public class LinkServiceImpl extends ServiceMybatis<Link> implements LinkService {

	@Resource
	private LinkMapper LinkMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Link
	 * @return
	 */
	public int saveLink(Link record) {
		return this.save(record);
	}

	/**
	 * 删除
	* @param CmsArticle
	* @return
	 */
	public int deleteLink(Link record) {
		return this.delete(record);
	}


}
