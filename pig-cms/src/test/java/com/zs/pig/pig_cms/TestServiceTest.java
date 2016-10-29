package com.zs.pig.pig_cms;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath*:config/spring/cms-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceTest.class);
//	@Resource
//	MaintainTaskDefinitionService maintainTaskDefinitionService;
//
//	
//	
//	@Test
//	public void transferTest() throws Exception {
//		MaintainTaskDefinition m=new MaintainTaskDefinition();
//	List<MaintainTaskDefinition> dd=	maintainTaskDefinitionService.select(m);
//	System.out.println(dd);
//	}
	
	
}
