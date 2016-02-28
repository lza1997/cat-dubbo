package monitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = { "classpath:config/spring/monitor-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class
        DubboTest {
	@Test
	public void run(){
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
	}
	
}
