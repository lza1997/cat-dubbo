package com.zs.cat.monitor.sendnotice.email;

import java.io.File;

public interface ISpringMailSenderService {

	/**
	 * 传入收件人地址、邮件主题、邮件内容进行发送（无附件）
	 * 
	 * @version: 1.00
	 * @history: 2015年6月18日 下午4:30:14 [created]
	 * @author hx 黄湘
	 * @param setTo
	 * @param setSubject
	 * @param sendText
	 * @see
	 */
	public boolean simpleSend(String setTo,String setSubject,String sendText);
	
	/**
	 * 传入收件人地址、邮件主题、邮件内容、附件进行发送（带附件）
	 * 
	 * @version: 1.00
	 * @history: 2015年6月25日 上午10:43:21 [created]
	 * @author hx 黄湘
	 * @param setTo
	 * @param setSubject
	 * @param setText
	 * @param file
	 * @see
	 */
	public boolean annexSend(String setTo,String setSubject,String setText,File file);
}
