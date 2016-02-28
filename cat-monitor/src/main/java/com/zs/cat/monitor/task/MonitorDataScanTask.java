package com.zs.cat.monitor.task;

import com.bestpay.bpcs.commons.utils.IpGetter;
import com.bestpay.bpcs.schedule.config.service.ITaskParamService;
import com.bestpay.bpcs.schedule.frame.AbstractTask;
import com.bestpay.common.utils.DateUtil;
import com.zs.cat.monitor.handle.IMonitorDataHandler;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MonitorDataScanTask extends AbstractTask{
	
	private static final Logger logger = LoggerFactory.getLogger(MonitorDataScanTask.class);
	
	@Resource
	ITaskParamService taskParamService;
	
	@Resource
	IMonitorDataHandler monitorDataHandler;

	@Value("${zookeeper.distributedLock}")
	public String zookeeperConnectionString;
	@Value("${zookeeper.distributedLock.basePath}")
	public String lockPath;
	private static CuratorFramework client;

	private static String TASK_NAME="monitor_task_";

	public synchronized CuratorFramework getZkClient() {
		if (client == null) {
			RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
			client = CuratorFrameworkFactory.newClient(
					zookeeperConnectionString, 1800000, 100000, retryPolicy);
			client.start();
		}
		return client;
	}
	/**
	 * 任务实现方法
	 * 具体由子类实现
	 *
	 * @param context
	 */
	@Override
	public String doTask(JobExecutionContext context) throws Exception {
		try {
			try {
				//查询任务名称，即T_CSM_TASK_CONFIG表中的config_id
				JobDetail jobDetail = context.getJobDetail();
				String jobName = jobDetail.getName();
				logger.info("配置id为[" + jobName + "]的job开始执行!");
				//查询任务参数表
				Map<String, String> paramMap = new HashMap<String, String>();
				try {
					paramMap = taskParamService.queryParamsByTaskId(Long.parseLong(jobName));
				} catch (Exception e) {
					logger.error("配置id为[" + jobName + "]的job执行时查询参数信息出错!", e);
				}
				String monitorCode = (String) paramMap.get("monitorCode");
				if (StringUtils.isBlank(monitorCode)) {
					logger.error("未找到配置id为[" + jobName + "]的job执行时所需要的参数[" + monitorCode + "]配置!");
				}
				try {
					String lockNode = lockPath + TASK_NAME + monitorCode;
					CuratorFramework client = getZkClient();
					if (null == client.checkExists().forPath(lockNode)) {
						String nodeValue= IpGetter.getLocalIP()+" 创建时间："+ DateUtil.getNowTime();
						client.create().withMode(CreateMode.EPHEMERAL).forPath(lockNode,nodeValue.getBytes());
						monitorDataHandler.processFileByMonitorCode(monitorCode);
						finishAwaitTask(TASK_NAME + monitorCode);
					} else {
						log.debug("任务 " + TASK_NAME + monitorCode + " 正在运行 运行机器："+new String(client.getData().forPath(lockNode)));
					}
				} catch (Exception e) {
					logger.error("配置id为[" + jobName + "]的job执行时出错!", e);
				} finally {
					logger.info("配置id为[" + jobName + "]的job执行结束!");
				}

			} catch (Exception e) {
				log.error("风控异常，异常详情:{}", e);
			}

		} catch (Exception e) {
			log.error("创建风控请求{}锁异常",TASK_NAME,e);
		}
		return null;
	}

	/**
	 * 释放锁操作
	 * @param lockNode
	 */
	public void finishAwaitTask(String lockNode) {
		CuratorFramework client = getZkClient();
		lockNode = lockPath + lockNode;
		try {
			log.info("查看该锁是否存在==========lockNode==" + lockNode + "+" + client.checkExists().forPath(lockNode));
			if (null != client.checkExists().forPath(lockNode)) {
				client.delete().forPath(lockNode);
				log.info("释放锁========================" + lockNode);
			}
		} catch (Exception e) {
			log.error("释放勾对请求{}锁异常",lockNode,e);
		}
		log.info(" 结束 task end===============================");
	}
	
}
