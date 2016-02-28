package monitor;

import com.zs.cat.monitor.base.service.ISmsTempSendService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * File                 : SmsTempSendService
 * Copy Right           : 天翼电子商户有限公司 www.bestpay.com.cn
 * Project              : bpcs
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2016/1/19 11:56 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@bestpay.com.cn
 */
@ContextConfiguration(locations = {"classpath:config/spring/monitor-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsTempSendService {
    @Resource
    private ISmsTempSendService smsTempSendService;
    @Test
    public void test(){
        smsTempSendService.doTask();
    }
}
