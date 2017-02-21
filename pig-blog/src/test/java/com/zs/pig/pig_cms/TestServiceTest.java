package com.zs.pig.pig_cms;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath*:config/spring/blog-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceTest.class);
//	@Resource
//	CmsArticleService cmsArticleService;
//	
//	@Resource
//	CmsCategoryService cmsCategoryService;
//
//	
//	
//	@Test
//	public void transferTest() throws Exception {
//		CmsArticle m=new CmsArticle();
//	List<CmsArticle> dd=	cmsArticleService.select(m);
//	System.out.println(dd);
//	}
//	/**
//	 * 事务测试
//	 * @throws Exception
//	 */
//	@Test
//	public void TransTest() throws Exception {
//		CmsArticle m=new CmsArticle();
//		CmsCategory c=new CmsCategory();
//		c.setName("cate3");
//		cmsCategoryService.insertSelective(c);
//		
//		m.setContent("cate3");
//		cmsArticleService.insertSelective(m);
//		
//	}
	
}
