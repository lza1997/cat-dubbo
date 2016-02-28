package monitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestpay.pay.foundation.service.SmsSendService;
import com.bestpay.pay.foundation.service.model.request.SmsSendByContentRequest;
@ContextConfiguration(locations = { "classpath:config/spring/monitor-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsSendTest { 
  @Autowired
  SmsSendService smsSendService;
  @Test
  public void smsSend(){
	  SmsSendByContentRequest request = new SmsSendByContentRequest();
	  request.setSource("BPCS");
	  request.setMobile("18680220995,13128202943");
	  request.setContent("邓联彬测试测试！");
	  request.setInitiationID("201601111444001");//日志流水
	  System.out.println("返回结果---"+smsSendService.smsSendMessage(request));
  }
}
