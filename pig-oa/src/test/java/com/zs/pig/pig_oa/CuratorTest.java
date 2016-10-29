/*package com.zs.pig.pig_oa;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

*//**
 * File                 : CuratorTest
 * Copy Right           : 天翼电子商户有限公司 www.pig.com.cn
 * Project              : pig
 * JDK version used     : JDK 1.6
 * Comments             :
 * Version              : 1.00
 * Modification history : 2015/11/20 11:54 [created]
 * Author               : Xiang Huang 黄湘
 * Email                : huangxiang-it@pig.com.cn
 *//*
@Slf4j
public class CuratorTest {
    *//**
     * 删除zookeeper节点
     * @throws InterruptedException
     *//*
    @Test
    public void getData() throws InterruptedException {

        String zookeeperConnectionString = "172.26.7.113:21811,172.26.7.113:21822,172.26.7.113:21833";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework  client = CuratorFrameworkFactory.newClient(
                zookeeperConnectionString, 20000, 100000, retryPolicy);
        client.start();
        String base = "/scheduleLock";//可以直接删掉次目录下 所以节点
        String path = "/sub0000078594";
        System.out.println("客户端启动。。。。");
        String[] nodes={};
        //for (int i = 0; i < nodes.length; i++) {
        	//path=nodes[i];
			String lockNode = base + path;
			try {
				//            client.delete().forPath(lockNode);
				System.out.println("lockNode====" + lockNode);
				if (null != client.checkExists().forPath(lockNode)) {
					List<String> children = client.getChildren().forPath(
							lockNode);
					System.out.println(client.checkExists().forPath(lockNode));
					System.out.println("---->");
					//client.delete().forPath(lockNode);
					for (String s : children) {
						System.out.println("---->" + s);
						client.delete().forPath(lockNode + "/" + s);
					}
				}
				//            if (null == client.checkExists().forPath(lockNode)) {
				//                String nodeValue="127.0.0.1"+" 创建时间："+DateUtil.getNowTime();
				//                client.create().withMode(CreateMode.EPHEMERAL).forPath(lockNode,nodeValue.getBytes());
				//                log.debug("创建任务 " + path + "  value："+nodeValue);
				//            } else {
				//
				//                log.debug("任务 " + path + " 正在运行 运行机器："+new String(client.getData().forPath(lockNode)));
				//                for(String node)
				//                client.delete().forPath(lockNode);
				//                for(int i=0;i<100;i++){
				//                    Thread.sleep(1000);
				//                    System.out.println("测试节点是否释放："+client.checkExists().forPath(lockNode));
				//                }
				//            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
		

//		client.close();

        System.out.println("客户端关闭。。。。");

    }

    static class MyLock implements Runnable {

        private String name;

        private CuratorFramework client;

        private CountDownLatch latch;

        public MyLock(String name, CuratorFramework client, CountDownLatch latch) {
            this.name = name;
            this.client = client;
            this.latch = latch;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {

                System.out.println("client.checkExists()"
                        + client.checkExists().forPath("/test_group"));
                if (null != client.checkExists().forPath("/test_group")) {
                    // client.delete().forPath("/test_group");
                }
                // client.create().withMode(CreateMode.EPHEMERAL).forPath("/test_group");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
*/