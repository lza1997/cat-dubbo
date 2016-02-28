package monitor;

import java.io.File;

import javax.annotation.Resource;


import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = { "classpath:config/spring/monitor-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMailSenderTest {
    // Spring的邮件工具类，实现了MailSender和JavaMailSender接口
    @Resource(name = "mailSender")
	private JavaMailSender mailSender;
    public void simpleSend() {
	    // 构建简单邮件对象，见名知意
	    SimpleMailMessage smm = new SimpleMailMessage();
	    // 设定邮件参数
	    smm.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
	    smm.setTo("342094280@qq.com");
	    smm.setSubject("test");
	    smm.setText("Hello world via spring mail sender");
	    // 发送邮件
	    mailSender.send(smm);


	}
    
    public void annexSend() {
	      // 构建简单邮件对象
		  MimeMessage mailMessage = mailSender.createMimeMessage();
		  //设置utf-8或GBK编码，否则邮件会有乱码
		  try {
			  MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
			  messageHelper.setFrom(((JavaMailSenderImpl) mailSender).getUsername());
			  messageHelper.setTo("342094280@qq.com");
			  messageHelper.setSubject("test");
			  messageHelper.setText("<html><head></head><body><h1>hello!!spring html Mail</h1></body></html>",true);
			// true 表示启动HTML格式的邮件  
		      messageHelper.setText("<html><head></head><body><h1>hello!!spring image html mail</h1><img src=\"cid:aaa\"/></body></html>", true);  
//		      FileSystemResource img = new FileSystemResource(new File("D:/Desert.jpg"));  
		      messageHelper.addInline("aaa", new File("D:/Desert.jpg"));  
			  
			  //附件内容
//			  messageHelper.addInline("a", new File("D:/Desert.jpg"));
//			  messageHelper.addInline("b", new File("D:/Chrysanthemum.jpg")); 
			  File file=new File("D:/BANK_NH_20150610.txt");  
			  // 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
			  messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file); 
			  mailSender.send(mailMessage);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		}
    @Test
	public void runTxtJob() {
    	simpleSend();
//    	annexSend();
	}
    
}

