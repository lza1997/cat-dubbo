
1：在要使用定时器的项目里，添加依赖，如下
===================================
<!--bpcs-schedule，定时任务需要添加的依赖 -->
<dependency>
	<groupId>com.bestpay.bpcs</groupId>
	<artifactId>bpcs-schedule</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>


2：在要使用定时器项目的classpath里，需要添加以下定时器属性
请写在 classpath:/config/properties/app.properties 默认全部配置项写在该文件
===================================
zooKeeper.schedule.URL=172.26.7.113:21811
zooKeeper.schedule.groupPath=/scheduleLock
zooKeeper.schedule.subPath=/scheduleLock/sub
JOB_NAME=0
JOB_GROUP=BPCS_CSS
MODULE_ID=bpcs-inf
JOB_CLASS=com.bestpay.bpcs.schedule.frame.TaskMaster
JOB_CRON=0 0/1 *  * * ? *


3：在要使用定时器的项目里，引入定时器spring的相关配置
===================================
<import resource="classpath:/schedule-quartz.xml" />


4：在要使用定时器的项目里，配置mybatis.xml
===================================
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="configLocation" value="classpath:config/mybatis/inf-mybatis-config.xml"/>
    <property name="mapperLocations">
        <list>
            <value>classpath*:com/bestpay/bpcs/inf/base/dao/mapper/*.xml</value>
            <!-- 定时任务需要的mapper -->
            <value>classpath*:com/bestpay/bpcs/schedule/config/dao/mapper/*.xml</value>
        </list>
    </property>
</bean>

<bean id="scannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    <!-- 定时任务需要 -->
    <property name="basePackage" value="com.bestpay.bpcs.inf.base.dao; com.bestpay.bpcs.schedule.config.dao"/>
</bean>


5：在各项目，对schedule的东西，进行事务控制，例子如下
<bean id="schedule_transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>
<tx:advice id="schedule_txAdvice" transaction-manager="schedule_transactionManager">
    <tx:attributes>
        <tx:method name="delete*" propagation="REQUIRED" read-only="false" rollback-for="BusinessException.class"/>
        <tx:method name="insert*" propagation="REQUIRED" read-only="false" rollback-for="BusinessException.class" />
        <tx:method name="update*" propagation="REQUIRED" read-only="false" rollback-for="BusinessException.class"/>
        <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
        <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
        <tx:method name="select*" propagation="SUPPORTS" read-only="true"/>
        <tx:method name="query*" propagation="SUPPORTS" read-only="true"/>
        <tx:method name="add*" propagation="SUPPORTS" read-only="true"/>
    </tx:attributes>
</tx:advice>
<aop:config>
    <aop:pointcut expression="execution(* com.bestpay.bpcs.schedule.config.*.*(..))" id="allMethod"/><!-- 定时任务需要的 -->
    <aop:advisor pointcut-ref="allMethod" advice-ref="schedule_txAdvice"/>
</aop:config>


6：继承com.bestpay.bpcs.schedule.frame.AbstractTask类
实现doTask方法，在里面编写对应的业务逻辑代码
===================================
package com.bestpay.bpcs.inf.temp;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bestpay.bpcs.schedule.frame.AbstractTask;
//并发执行
public class TestTask1 extends AbstractTask {
	private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);
	public String doTask(JobExecutionContext context) throws Exception {
		String result = "测试的定时任务执行成功!";
		LOG.debug(result);
		return result;
	}
}

//串行执行
public class TestTask2 extends AbstractTask implements StatefulJob {
	private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);
	public String doTask(JobExecutionContext context) throws Exception {
		String result = "测试的定时任务执行成功!";
		LOG.debug(result);
		return result;
	}
}

7：在数据库表里，添加相应的配置信息;
T_CSM_TASK_CONFIG，T_CSM_TASK_PARAM表
===================================








