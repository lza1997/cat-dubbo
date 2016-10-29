//Powered By if, Since 2014 - 2020

package com.zs.pig.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.pig.cms.api.model.CmsLink;
import com.zs.pig.cms.api.service.CmsLinkService;
import com.zs.pig.cms.mapper.CmsLinkMapper;
import com.zs.pig.common.base.ServiceMybatis;

/**
 * 
 * @author
 */

@Service("CmsLinkService")
public class CmsLinkServiceImpl extends ServiceMybatis<CmsLink> implements CmsLinkService {

	@Resource
	private CmsLinkMapper CmsLinkMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param CmsLink
	 * @return
	 */
	public int savecmsLink(CmsLink CmsLink) {
		return this.save(CmsLink);
	}

	/**
	 * 删除
	* @param CmsLink
	* @return
	 */
	public int deleteCmsLink(CmsLink CmsLink) {
		return this.delete(CmsLink);
	}


}
