package monitor;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.cat.monitor.handle.IMonitorDataHandler;

@ContextConfiguration(locations = { "classpath:config/spring/monitor-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Mytest3{
	@Resource(name = "MonitorDataHandler")
	IMonitorDataHandler MonitorDataHandler;
	@Test
	public void queryMonitorList(){
		MonitorDataHandler.processFileByMonitorCode("M001");
	}
}
