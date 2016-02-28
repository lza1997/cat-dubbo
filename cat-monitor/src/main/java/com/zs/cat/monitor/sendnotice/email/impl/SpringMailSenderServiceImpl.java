package com.zs.cat.monitor.sendnotice.email.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.zs.cat.monitor.sendnotice.email.ISpringMailSenderService;

@Service("springMailSenderService")
public class SpringMailSenderServiceImpl implements ISpringMailSenderService{

	@Resource(name = "mailSender")
	private JavaMailSender mailSender;

	@Override
	public boolean simpleSend(String setTo, String setSubject, String sendText) {
		boolean flag;
		try{
			// 构建简单邮件对象
			SimpleMailMessage smm = new SimpleMailMessage();
			// 设定邮件参数
			smm.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
			smm.setTo(setTo);
			smm.setSubject(setSubject);
			smm.setText(sendText);
			// 发送邮件
			mailSender.send(smm);
			flag=true;
		} catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean annexSend(String setTo, String setSubject, String setText,File file) {
		boolean flag;
		try {
			// 构建简单邮件对象
			MimeMessage mailMessage = mailSender.createMimeMessage();
			//设置utf-8或GBK编码，否则邮件会有乱码
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
			messageHelper.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
			messageHelper.setTo(setTo);
			messageHelper.setSubject(setSubject);
			messageHelper.setText(setText);
			// 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
			messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
			mailSender.send(mailMessage);
			flag=true;
		  } catch (Exception e) {
			flag=false;
		    e.printStackTrace();
		  }
		return flag;
		}

	}


