package monitor;

import javax.annotation.Resource;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.zs.cat.monitor.handle.impl.MonitorDataHandlerImpl;


@ContextConfiguration(locations = {"classpath:config/spring/monitor-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataHandleTest {
	@Resource(name = "mailSender")
	private JavaMailSender mailSender;
	@Resource(name = "MonitorDataHandler")
	private MonitorDataHandlerImpl MonitorDataHandler;
	
    @Test
	public void runTxtJob() {
    	MonitorDataHandler.processFileByMonitorCode("M001");
	}
    
}

