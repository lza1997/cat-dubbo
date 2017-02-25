#cat

motan版本  http://git.oschina.net/catshen/zsWing
学习资料和视频  https://pan.baidu.com/s/1jIoLf9O
演示地址  http://www.zscat.top/gw/index
演示地址  http://www.zscat.top/front
前端注册
后端 演示地址  http://www.zscat.top/login
http://www.zscat.top/web1
http://www.zscat.top/wap1


zscat普通群
<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=091b808b670b3f825b101f386ad6e0a7a0b1d7cef1f11a66120c866affcac80c"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="开源分布式框架(2) zsCat" title="开源分布式框架(2) zsCat"></a>

zsCat vip群 
<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=3440b6c11bbf3562bf38ea117cad2573188f1158a15d5397e48b6d4eb48fe587"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="zsCat vip群" title="zsCat vip群"></a>

部署dubboAdmin 监控dubbo服务
![输入图片说明](http://git.oschina.net/uploads/images/2017/0221/165923_17cb6ef1_134431.png "在这里输入图片标题")

更新
 添加kafka  storm
文档地址   http://git.oschina.net/catshen/zscatDocument
![输入图片说明](http://git.oschina.net/uploads/images/2016/1029/122812_c0278625_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/1029/122847_c1c15724_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/1029/122910_6eb4beec_134431.png "在这里输入图片标题")
          分布式框架架构设计
1.架构截图

Api接口  

![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013501_1f9f938e_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013511_b180d076_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013523_08038c7d_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013534_c978b065_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013544_d544ee61_134431.png "在这里输入图片标题")
![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013557_01273477_134431.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013608_4854e48f_134431.png "在这里输入图片标题")










打包命令 
开发环境  mvn -P dev clean package   -Dmaven.test.skip=true
测试环境  mvn -P testclean package   -Dmaven.test.skip=true
生产环境  mvn -P uat clean package   -Dmaven.test.skip=true



2.分布式定时器

![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013619_cbf3be05_134431.png "在这里输入图片标题")






2.


自定义工作流 主要是将流程分成节点跟路由，节点即具体动作，而路由为方向，流程流向。
每一个流程树：节点——路由——节点——路由——结束 （节点和路由 都有权限控制）




自定义表单  设计一个业务表的布局，流程节点的表单。
流程跟表单都可以通过权限控制，可以具体到表单字段的增删改查。流程可以绑定事件，使流程的大体执行情况可以确定。（表单可以是单表，也可以是父子表）
3.


![输入图片说明](http://git.oschina.net/uploads/images/2016/0226/013633_fd4a9e3e_134431.png "在这里输入图片标题")






技术选型
1、后端
核心框架：Spring Framework 4.0
       分布式框架： zookeeper dubbo 分布式锁
安全框架：Apache Shiro 1.2
视图框架：Spring MVC 4.0
服务端验证：Hibernate Validator 5.1
任务调度：Spring Task 4.0
持久层框架：MyBatis 3.2
数据库连接池：Alibaba Druid 1.0
缓存框架：Ehcache 2.6、Redis
Luence搜索引擎
日志管理：SLF4J 1.7、Log4j   logback
工具类：Apache Commons、Jackson 2.2、Xstream 1.4、Dozer 5.3、POI 3.9
2、前端
JS框架：jQuery 1.9。
CSS框架：bootstrap ace admin框架界面。
客户端验证：JQuery Validation Plugin 1.11。
富文本：CKEcitor
文件管理：CKFinder
百度 web upload 图片上传插件手机端框架：Jingle
数据表格：jqGrid
对话框：jQuery jBox
下拉选择框：jQuery Select2
树结构控件：jQuery zTree
日期控件： My97DatePicker






![输入图片说明](http://git.oschina.net/uploads/images/2016/0514/232902_d1be466f_134431.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/0514/232921_ff330f8c_134431.jpeg "在这里输入图片标题")





设计者：zs
qq：951449465
qq群：473023475 559182393