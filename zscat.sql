/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : numysql

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-02-27 17:41:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bl_blog
-- ----------------------------
DROP TABLE IF EXISTS `bl_blog`;
CREATE TABLE `bl_blog` (
  `BLOG_ID` varchar(100) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `AGE` varchar(255) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`BLOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bl_blog
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `SFID` varchar(100) DEFAULT NULL,
  `START_TIME` varchar(100) DEFAULT NULL,
  `END_TIME` varchar(100) DEFAULT NULL,
  `YEARS` int(10) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
INSERT INTO `sys_app_user` VALUES ('04762c0b28b643939455c7800c2e2412', 'dsfsd', 'f1290186a5d0b1ceab27f4e77c0c5d68', 'w', '', '55896f5ce3c0494fa6850775a4e29ff6', '', '', '1', '', '18766666666', '', '', '', '0', '001', '18766666666@qq.com');
INSERT INTO `sys_app_user` VALUES ('3faac8fe5c0241e593e0f9ea6f2d5870', 'dsfsdf', 'f1290186a5d0b1ceab27f4e77c0c5d68', 'wewe', '', '68f23fc0caee475bae8d52244dea8444', '', '', '1', '', '18767676767', '', '', '', '0', 'wqwe', 'qweqwe@qq.com');

-- ----------------------------
-- Table structure for sys_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionaries`;
CREATE TABLE `sys_dictionaries` (
  `ZD_ID` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `BIANMA` varchar(100) DEFAULT NULL,
  `ORDY_BY` int(10) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `JB` int(10) DEFAULT NULL,
  `P_BM` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ZD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionaries
-- ----------------------------
INSERT INTO `sys_dictionaries` VALUES ('212a6765fddc4430941469e1ec8c8e6c', '人事部', '001', '1', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_001');
INSERT INTO `sys_dictionaries` VALUES ('3cec73a7cc8a4cb79e3f6ccc7fc8858c', '行政部', '002', '2', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_002');
INSERT INTO `sys_dictionaries` VALUES ('48724375640341deb5ef01ac51a89c34', '北京', 'dq001', '1', 'cdba0b5ef20e4fc0a5231fa3e9ae246a', '2', 'DQ_dq001');
INSERT INTO `sys_dictionaries` VALUES ('5a1547632cca449db378fbb9a042b336', '研发部', '004', '4', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_004');
INSERT INTO `sys_dictionaries` VALUES ('7f9cd74e60a140b0aea5095faa95cda3', '财务部', '003', '3', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_003');
INSERT INTO `sys_dictionaries` VALUES ('b861bd1c3aba4934acdb5054dd0d0c6e', '科技不', 'kj', '7', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_kj');
INSERT INTO `sys_dictionaries` VALUES ('c067fdaf51a141aeaa56ed26b70de863', '部门', 'BM', '1', '0', '1', 'BM');
INSERT INTO `sys_dictionaries` VALUES ('cdba0b5ef20e4fc0a5231fa3e9ae246a', '地区', 'DQ', '2', '0', '1', 'DQ');
INSERT INTO `sys_dictionaries` VALUES ('f184bff5081d452489271a1bd57599ed', '上海', 'SH', '2', 'cdba0b5ef20e4fc0a5231fa3e9ae246a', '2', 'DQ_SH');
INSERT INTO `sys_dictionaries` VALUES ('f30bf95e216d4ebb8169ff0c86330b8f', '客服部', '006', '6', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_006');

-- ----------------------------
-- Table structure for sys_gl_qx
-- ----------------------------
DROP TABLE IF EXISTS `sys_gl_qx`;
CREATE TABLE `sys_gl_qx` (
  `GL_ID` varchar(100) NOT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `FX_QX` int(10) DEFAULT NULL,
  `FW_QX` int(10) DEFAULT NULL,
  `QX1` int(10) DEFAULT NULL,
  `QX2` int(10) DEFAULT NULL,
  `QX3` int(10) DEFAULT NULL,
  `QX4` int(10) DEFAULT NULL,
  PRIMARY KEY (`GL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_gl_qx
-- ----------------------------
INSERT INTO `sys_gl_qx` VALUES ('1', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO `sys_gl_qx` VALUES ('2', '1', '0', '0', '1', '1', '1', '1');
INSERT INTO `sys_gl_qx` VALUES ('55896f5ce3c0494fa6850775a4e29ff6', '7', '0', '0', '1', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('68f23fc0caee475bae8d52244dea8444', '7', '0', '0', '1', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('7dfd8d1f7b6245d283217b7e63eec9b2', '1', '1', '1', '1', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('ac66961adaa2426da4470c72ffeec117', '1', '1', '0', '1', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('b0c77c29dfa140dc9b14a29c056f824f', '7', '1', '0', '1', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('e74f713314154c35bd7fc98897859fe3', '6', '1', '1', '1', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('f944a9df72634249bbcb8cb73b0c9b86', '7', '1', '1', '1', '1', '0', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(30) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '#', '0', '1', 'icon-desktop', '1');
INSERT INTO `sys_menu` VALUES ('2', '组织管理', 'role.do', '1', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('4', '会员管理', 'happuser/listUsers.do', '1', '4', null, '1');
INSERT INTO `sys_menu` VALUES ('5', '系统用户', 'user/listUsers.do', '1', '3', null, '1');
INSERT INTO `sys_menu` VALUES ('6', '信息管理', '#', '0', '2', 'icon-list-alt', '2');
INSERT INTO `sys_menu` VALUES ('7', '图片管理', 'pictures/list.do', '6', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('8', '性能监控', 'druid/index.html', '9', '1', null, '1');
INSERT INTO `sys_menu` VALUES ('9', '系统工具', '#', '0', '3', 'icon-th', '1');
INSERT INTO `sys_menu` VALUES ('10', '接口测试', 'tool/interfaceTest.do', '9', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('11', '发送邮件', 'tool/goSendEmail.do', '9', '3', null, '1');
INSERT INTO `sys_menu` VALUES ('12', '置二维码', 'tool/goTwoDimensionCode.do', '9', '4', null, '1');
INSERT INTO `sys_menu` VALUES ('13', '多级别树', 'tool/ztree.do', '9', '5', null, '1');
INSERT INTO `sys_menu` VALUES ('14', '地图工具', 'tool/map.do', '9', '6', null, '1');
INSERT INTO `sys_menu` VALUES ('15', '微信管理', '#', '0', '2', 'icon-comments', '2');
INSERT INTO `sys_menu` VALUES ('16', '文本回复', 'textmsg/list.do', '15', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('17', '应用命令', 'command/list.do', '15', '4', null, '2');
INSERT INTO `sys_menu` VALUES ('18', '图文回复', 'imgmsg/list.do', '15', '3', null, '2');
INSERT INTO `sys_menu` VALUES ('19', '关注回复', 'textmsg/goSubscribe.do', '15', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('20', '在线管理', 'onlinemanager/list.do', '1', '5', null, '1');
INSERT INTO `sys_menu` VALUES ('21', '打印测试', 'tool/printTest.do', '9', '7', null, '1');
INSERT INTO `sys_menu` VALUES ('22', 'test', 'test/list.do', '6', '5', null, '2');
INSERT INTO `sys_menu` VALUES ('23', 'people', 'people/list.do', '6', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('24', 'demo', 'demo/list.do', '6', '3', null, '2');
INSERT INTO `sys_menu` VALUES ('25', '博客', 'blog/list.do', '6', '5', null, '2');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  `QX_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '67108854', '0', '1', '1', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('2', '超级管理员', '67108854', '1', '230', '50', '34', '54', '2');
INSERT INTO `sys_role` VALUES ('4', '用户组', '118', '0', '0', '0', '0', '0', null);
INSERT INTO `sys_role` VALUES ('55896f5ce3c0494fa6850775a4e29ff6', '特级会员', '498', '7', '0', '0', '0', '0', '55896f5ce3c0494fa6850775a4e29ff6');
INSERT INTO `sys_role` VALUES ('6', '客户组', '18', '0', '1', '1', '1', '1', null);
INSERT INTO `sys_role` VALUES ('68f23fc0caee475bae8d52244dea8444', '中级会员', '498', '7', '0', '0', '0', '0', '68f23fc0caee475bae8d52244dea8444');
INSERT INTO `sys_role` VALUES ('7', '会员组', '498', '0', '0', '0', '0', '1', null);
INSERT INTO `sys_role` VALUES ('7dfd8d1f7b6245d283217b7e63eec9b2', '管理员B', '67108854', '1', '246', '0', '0', '0', '7dfd8d1f7b6245d283217b7e63eec9b2');
INSERT INTO `sys_role` VALUES ('ac66961adaa2426da4470c72ffeec117', '管理员A', '67108854', '1', '54', '54', '0', '246', 'ac66961adaa2426da4470c72ffeec117');
INSERT INTO `sys_role` VALUES ('b0c77c29dfa140dc9b14a29c056f824f', '高级会员', '498', '7', '0', '0', '0', '0', 'b0c77c29dfa140dc9b14a29c056f824f');
INSERT INTO `sys_role` VALUES ('e74f713314154c35bd7fc98897859fe3', '黄金客户', '18', '6', '1', '1', '1', '1', 'e74f713314154c35bd7fc98897859fe3');
INSERT INTO `sys_role` VALUES ('f944a9df72634249bbcb8cb73b0c9b86', '初级会员', '498', '7', '1', '1', '1', '1', 'f944a9df72634249bbcb8cb73b0c9b86');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', '系统管理员', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2016-02-27 17:29:58', '0:0:0:0:0:0:0:1', '0', '最高统治者', 'default', 'admin@main.com', '001', '18788888888');
INSERT INTO `sys_user` VALUES ('c9bde3a2da6f4479881a5f9797a3a542', 'demo', '5863d9e4cbdf522eaa62e0747fceb1c5b249ba13', 'test', '', '7dfd8d1f7b6245d283217b7e63eec9b2', '2016-02-22 17:23:02', '0:0:0:0:0:0:0:1', '0', 'test', 'default', '1439226811@qq.com', '1', '15989289524');

-- ----------------------------
-- Table structure for sys_user_qx
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_qx`;
CREATE TABLE `sys_user_qx` (
  `U_ID` varchar(100) NOT NULL,
  `C1` int(10) DEFAULT NULL,
  `C2` int(10) DEFAULT NULL,
  `C3` int(10) DEFAULT NULL,
  `C4` int(10) DEFAULT NULL,
  `Q1` int(10) DEFAULT NULL,
  `Q2` int(10) DEFAULT NULL,
  `Q3` int(10) DEFAULT NULL,
  `Q4` int(10) DEFAULT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_qx
-- ----------------------------
INSERT INTO `sys_user_qx` VALUES ('1', '1', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('2', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `sys_user_qx` VALUES ('55896f5ce3c0494fa6850775a4e29ff6', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('68f23fc0caee475bae8d52244dea8444', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('7dfd8d1f7b6245d283217b7e63eec9b2', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('ac66961adaa2426da4470c72ffeec117', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('b0c77c29dfa140dc9b14a29c056f824f', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('e74f713314154c35bd7fc98897859fe3', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('f944a9df72634249bbcb8cb73b0c9b86', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for tb_demo
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo`;
CREATE TABLE `tb_demo` (
  `DEMO_ID` varchar(100) NOT NULL,
  `AGE` int(11) NOT NULL COMMENT '年龄',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`DEMO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo
-- ----------------------------
INSERT INTO `tb_demo` VALUES ('f1a17d1f82ea445696c19ee9a6450452', '2', '333');

-- ----------------------------
-- Table structure for tb_peoplepeople
-- ----------------------------
DROP TABLE IF EXISTS `tb_peoplepeople`;
CREATE TABLE `tb_peoplepeople` (
  `PEOPLE_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `CREATEDATE` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `AGE` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`PEOPLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_peoplepeople
-- ----------------------------
INSERT INTO `tb_peoplepeople` VALUES ('3c31b6c480c34220b0490af6ec5d4c55', '111', '222', '2016-02-09', '3');

-- ----------------------------
-- Table structure for tb_pictures
-- ----------------------------
DROP TABLE IF EXISTS `tb_pictures`;
CREATE TABLE `tb_pictures` (
  `PICTURES_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `NAME` varchar(255) DEFAULT NULL COMMENT '文件名',
  `PATH` varchar(255) DEFAULT NULL COMMENT '路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `MASTER_ID` varchar(255) DEFAULT NULL COMMENT '属于',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`PICTURES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pictures
-- ----------------------------
INSERT INTO `tb_pictures` VALUES ('a2e8289d54254717b10834f9f251f784', '图片', 'd77e068977ac403ba762725b6283fbc1.png', '20160123/d77e068977ac403ba762725b6283fbc1.png', '2016-01-23 13:11:49', '1', '图片管理处上传');

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test` (
  `TEST_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `AGE` int(11) NOT NULL COMMENT '年龄',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`TEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_test
-- ----------------------------
INSERT INTO `tb_test` VALUES ('0a2c55d52478415b8db553a25d0605ff', '11', '2', '22', '2016-01-04');

-- ----------------------------
-- Table structure for t_csc_monitor_config
-- ----------------------------
DROP TABLE IF EXISTS `t_csc_monitor_config`;
CREATE TABLE `t_csc_monitor_config` (
  `monitor_id` varchar(20) NOT NULL,
  `monitor_code` varchar(32) DEFAULT NULL,
  `monitor_segment` varchar(8) DEFAULT NULL,
  `monitor_name` varchar(64) DEFAULT NULL,
  `monitor_desc` varchar(128) DEFAULT NULL,
  `monitor_script` varchar(4000) DEFAULT NULL,
  `threshold` int(10) DEFAULT NULL,
  `compare_type` varchar(8) DEFAULT NULL,
  `notice_num` int(10) DEFAULT NULL,
  `stat` varchar(8) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csc_monitor_config
-- ----------------------------

-- ----------------------------
-- Table structure for t_csc_monitor_noticereal
-- ----------------------------
DROP TABLE IF EXISTS `t_csc_monitor_noticereal`;
CREATE TABLE `t_csc_monitor_noticereal` (
  `real_id` varchar(20) NOT NULL,
  `monitor_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(64) DEFAULT NULL,
  `notice_type` varchar(8) DEFAULT NULL,
  `stat` varchar(8) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL,
  `template_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csc_monitor_noticereal
-- ----------------------------

-- ----------------------------
-- Table structure for t_csc_monitor_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_csc_monitor_staff`;
CREATE TABLE `t_csc_monitor_staff` (
  `staff_id` varchar(20) NOT NULL,
  `staff_name` varchar(64) DEFAULT NULL,
  `staff_tel` varchar(32) DEFAULT NULL,
  `staff_email` varchar(64) DEFAULT NULL,
  `stat` varchar(8) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csc_monitor_staff
-- ----------------------------

-- ----------------------------
-- Table structure for t_csc_monitor_template
-- ----------------------------
DROP TABLE IF EXISTS `t_csc_monitor_template`;
CREATE TABLE `t_csc_monitor_template` (
  `template_id` varchar(20) NOT NULL,
  `template_name` varchar(64) DEFAULT NULL,
  `template_content` varchar(4000) DEFAULT NULL,
  `stat` varchar(8) DEFAULT NULL,
  `memo` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csc_monitor_template
-- ----------------------------

-- ----------------------------
-- Table structure for t_csm_task_config
-- ----------------------------
DROP TABLE IF EXISTS `t_csm_task_config`;
CREATE TABLE `t_csm_task_config` (
  `config_id` int(10) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(51) NOT NULL,
  `task_type` int(2) NOT NULL,
  `task_class` varchar(250) NOT NULL,
  `task_cron` varchar(30) NOT NULL,
  `run_state` int(2) NOT NULL,
  `task_state` int(2) NOT NULL,
  `task_date` varchar(20) DEFAULT NULL,
  `task_time` varchar(20) DEFAULT NULL,
  `last_run_date` datetime DEFAULT NULL,
  `run_num` int(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `creater_id` varchar(10) DEFAULT NULL,
  `creater_name` varchar(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `updater_id` varchar(10) DEFAULT NULL,
  `updater_name` varchar(20) DEFAULT NULL,
  `remark` varchar(150) DEFAULT NULL,
  `module_id` varchar(150) DEFAULT NULL,
  `priority` int(3) DEFAULT NULL,
  `task_group_flag` varchar(200) NOT NULL,
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csm_task_config
-- ----------------------------
INSERT INTO `t_csm_task_config` VALUES ('1', 'test', '2', 'com.zs.cat.cms.task.PEfilePushTask', '0 0/1 *  * * ? *', '2', '1', null, null, '2016-02-25 13:52:00', '1', '2016-02-23 14:12:32', '1', '1', '2016-02-23 14:12:40', '1', '1', null, 'cat-cms', '5', 'cat-cms_group_1');

-- ----------------------------
-- Table structure for t_csm_task_log
-- ----------------------------
DROP TABLE IF EXISTS `t_csm_task_log`;
CREATE TABLE `t_csm_task_log` (
  `log_id` int(10) NOT NULL AUTO_INCREMENT,
  `config_id` int(10) NOT NULL,
  `state` int(2) NOT NULL,
  `results` varchar(100) DEFAULT NULL,
  `sucess_num` int(10) DEFAULT NULL,
  `fail_num` int(10) DEFAULT NULL,
  `begin_date` datetime NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csm_task_log
-- ----------------------------
INSERT INTO `t_csm_task_log` VALUES ('4', '1', '1', null, null, null, '2016-02-24 10:37:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('5', '1', '1', null, null, null, '2016-02-24 10:38:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('6', '1', '1', null, '0', '0', '2016-02-24 10:44:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('7', '1', '1', null, '0', '0', '2016-02-24 10:45:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('8', '1', '1', null, '0', '0', '2016-02-24 10:46:31', null, null);
INSERT INTO `t_csm_task_log` VALUES ('9', '1', '1', null, '0', '0', '2016-02-24 10:49:12', null, null);
INSERT INTO `t_csm_task_log` VALUES ('10', '1', '1', null, '0', '0', '2016-02-24 10:55:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('11', '1', '1', null, '0', '0', '2016-02-24 10:56:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('12', '1', '1', null, '0', '0', '2016-02-24 10:57:00', null, null);
INSERT INTO `t_csm_task_log` VALUES ('13', '1', '1', null, '0', '0', '2016-02-24 10:58:54', null, null);
INSERT INTO `t_csm_task_log` VALUES ('14', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:06:10', '2016-02-24 11:06:30', null);
INSERT INTO `t_csm_task_log` VALUES ('15', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:07:00', '2016-02-24 11:07:00', null);
INSERT INTO `t_csm_task_log` VALUES ('16', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:08:00', '2016-02-24 11:08:00', null);
INSERT INTO `t_csm_task_log` VALUES ('17', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:09:00', '2016-02-24 11:09:00', null);
INSERT INTO `t_csm_task_log` VALUES ('18', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:10:00', '2016-02-24 11:10:00', null);
INSERT INTO `t_csm_task_log` VALUES ('19', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:11:00', '2016-02-24 11:11:00', null);
INSERT INTO `t_csm_task_log` VALUES ('20', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:12:00', '2016-02-24 11:12:00', null);
INSERT INTO `t_csm_task_log` VALUES ('21', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:13:00', '2016-02-24 11:13:00', null);
INSERT INTO `t_csm_task_log` VALUES ('22', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:14:00', '2016-02-24 11:14:00', null);
INSERT INTO `t_csm_task_log` VALUES ('23', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:15:00', '2016-02-24 11:15:00', null);
INSERT INTO `t_csm_task_log` VALUES ('24', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:16:00', '2016-02-24 11:16:00', null);
INSERT INTO `t_csm_task_log` VALUES ('25', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:17:00', '2016-02-24 11:17:00', null);
INSERT INTO `t_csm_task_log` VALUES ('26', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:18:00', '2016-02-24 11:18:00', null);
INSERT INTO `t_csm_task_log` VALUES ('27', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:19:00', '2016-02-24 11:19:00', null);
INSERT INTO `t_csm_task_log` VALUES ('28', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:20:00', '2016-02-24 11:20:00', null);
INSERT INTO `t_csm_task_log` VALUES ('29', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:21:00', '2016-02-24 11:21:00', null);
INSERT INTO `t_csm_task_log` VALUES ('30', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:22:00', '2016-02-24 11:22:00', null);
INSERT INTO `t_csm_task_log` VALUES ('31', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:23:00', '2016-02-24 11:23:00', null);
INSERT INTO `t_csm_task_log` VALUES ('32', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:24:00', '2016-02-24 11:24:00', null);
INSERT INTO `t_csm_task_log` VALUES ('33', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:25:00', '2016-02-24 11:25:00', null);
INSERT INTO `t_csm_task_log` VALUES ('34', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:26:00', '2016-02-24 11:26:00', null);
INSERT INTO `t_csm_task_log` VALUES ('35', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:27:00', '2016-02-24 11:27:00', null);
INSERT INTO `t_csm_task_log` VALUES ('36', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:28:00', '2016-02-24 11:28:00', null);
INSERT INTO `t_csm_task_log` VALUES ('37', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:29:00', '2016-02-24 11:29:00', null);
INSERT INTO `t_csm_task_log` VALUES ('38', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 11:30:00', '2016-02-24 11:30:00', null);
INSERT INTO `t_csm_task_log` VALUES ('39', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:14:00', '2016-02-24 18:14:00', null);
INSERT INTO `t_csm_task_log` VALUES ('40', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:15:00', '2016-02-24 18:15:00', null);
INSERT INTO `t_csm_task_log` VALUES ('41', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:21:00', '2016-02-24 18:21:00', null);
INSERT INTO `t_csm_task_log` VALUES ('42', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:22:00', '2016-02-24 18:22:00', null);
INSERT INTO `t_csm_task_log` VALUES ('43', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:23:00', '2016-02-24 18:23:00', null);
INSERT INTO `t_csm_task_log` VALUES ('44', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:24:00', '2016-02-24 18:24:01', null);
INSERT INTO `t_csm_task_log` VALUES ('45', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:25:00', '2016-02-24 18:25:01', null);
INSERT INTO `t_csm_task_log` VALUES ('46', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:26:00', '2016-02-24 18:26:00', null);
INSERT INTO `t_csm_task_log` VALUES ('47', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:27:00', '2016-02-24 18:27:00', null);
INSERT INTO `t_csm_task_log` VALUES ('48', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:28:00', '2016-02-24 18:28:01', null);
INSERT INTO `t_csm_task_log` VALUES ('49', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:29:00', '2016-02-24 18:29:00', null);
INSERT INTO `t_csm_task_log` VALUES ('50', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:30:00', '2016-02-24 18:30:00', null);
INSERT INTO `t_csm_task_log` VALUES ('51', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:31:00', '2016-02-24 18:31:00', null);
INSERT INTO `t_csm_task_log` VALUES ('52', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:32:00', '2016-02-24 18:32:00', null);
INSERT INTO `t_csm_task_log` VALUES ('53', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:33:00', '2016-02-24 18:33:00', null);
INSERT INTO `t_csm_task_log` VALUES ('54', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:34:00', '2016-02-24 18:34:00', null);
INSERT INTO `t_csm_task_log` VALUES ('55', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:35:00', '2016-02-24 18:35:00', null);
INSERT INTO `t_csm_task_log` VALUES ('56', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:36:00', '2016-02-24 18:36:00', null);
INSERT INTO `t_csm_task_log` VALUES ('57', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:37:00', '2016-02-24 18:37:01', null);
INSERT INTO `t_csm_task_log` VALUES ('58', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:38:00', '2016-02-24 18:38:00', null);
INSERT INTO `t_csm_task_log` VALUES ('59', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:39:00', '2016-02-24 18:39:00', null);
INSERT INTO `t_csm_task_log` VALUES ('60', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:40:00', '2016-02-24 18:40:00', null);
INSERT INTO `t_csm_task_log` VALUES ('61', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:41:00', '2016-02-24 18:41:00', null);
INSERT INTO `t_csm_task_log` VALUES ('62', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:42:00', '2016-02-24 18:42:00', null);
INSERT INTO `t_csm_task_log` VALUES ('63', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:43:00', '2016-02-24 18:43:00', null);
INSERT INTO `t_csm_task_log` VALUES ('64', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:44:00', '2016-02-24 18:44:00', null);
INSERT INTO `t_csm_task_log` VALUES ('65', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:45:00', '2016-02-24 18:45:00', null);
INSERT INTO `t_csm_task_log` VALUES ('66', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:46:00', '2016-02-24 18:46:00', null);
INSERT INTO `t_csm_task_log` VALUES ('67', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:47:00', '2016-02-24 18:47:00', null);
INSERT INTO `t_csm_task_log` VALUES ('68', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:48:00', '2016-02-24 18:48:00', null);
INSERT INTO `t_csm_task_log` VALUES ('69', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:49:00', '2016-02-24 18:49:00', null);
INSERT INTO `t_csm_task_log` VALUES ('70', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:50:00', '2016-02-24 18:50:00', null);
INSERT INTO `t_csm_task_log` VALUES ('71', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:51:00', '2016-02-24 18:51:01', null);
INSERT INTO `t_csm_task_log` VALUES ('72', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:52:00', '2016-02-24 18:52:00', null);
INSERT INTO `t_csm_task_log` VALUES ('73', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:53:00', '2016-02-24 18:53:00', null);
INSERT INTO `t_csm_task_log` VALUES ('74', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:54:00', '2016-02-24 18:54:00', null);
INSERT INTO `t_csm_task_log` VALUES ('75', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:55:00', '2016-02-24 18:55:00', null);
INSERT INTO `t_csm_task_log` VALUES ('76', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:56:00', '2016-02-24 18:56:00', null);
INSERT INTO `t_csm_task_log` VALUES ('77', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:57:00', '2016-02-24 18:57:00', null);
INSERT INTO `t_csm_task_log` VALUES ('78', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:58:00', '2016-02-24 18:58:00', null);
INSERT INTO `t_csm_task_log` VALUES ('79', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 18:59:00', '2016-02-24 18:59:00', null);
INSERT INTO `t_csm_task_log` VALUES ('80', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:00:00', '2016-02-24 19:00:00', null);
INSERT INTO `t_csm_task_log` VALUES ('81', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:01:00', '2016-02-24 19:01:00', null);
INSERT INTO `t_csm_task_log` VALUES ('82', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:02:00', '2016-02-24 19:02:00', null);
INSERT INTO `t_csm_task_log` VALUES ('83', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:03:00', '2016-02-24 19:03:00', null);
INSERT INTO `t_csm_task_log` VALUES ('84', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:04:00', '2016-02-24 19:04:00', null);
INSERT INTO `t_csm_task_log` VALUES ('85', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:05:00', '2016-02-24 19:05:00', null);
INSERT INTO `t_csm_task_log` VALUES ('86', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:06:00', '2016-02-24 19:06:01', null);
INSERT INTO `t_csm_task_log` VALUES ('87', '1', '2', '任务执行成功!', '0', '0', '2016-02-24 19:07:00', '2016-02-24 19:07:00', null);
INSERT INTO `t_csm_task_log` VALUES ('88', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:30:00', '2016-02-25 13:30:00', null);
INSERT INTO `t_csm_task_log` VALUES ('89', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:31:00', '2016-02-25 13:31:00', null);
INSERT INTO `t_csm_task_log` VALUES ('90', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:32:00', '2016-02-25 13:32:00', null);
INSERT INTO `t_csm_task_log` VALUES ('91', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:45:00', '2016-02-25 13:45:00', null);
INSERT INTO `t_csm_task_log` VALUES ('92', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:46:00', '2016-02-25 13:46:00', null);
INSERT INTO `t_csm_task_log` VALUES ('93', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:47:00', '2016-02-25 13:47:00', null);
INSERT INTO `t_csm_task_log` VALUES ('94', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:48:00', '2016-02-25 13:48:00', null);
INSERT INTO `t_csm_task_log` VALUES ('95', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:49:00', '2016-02-25 13:49:00', null);
INSERT INTO `t_csm_task_log` VALUES ('96', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:50:00', '2016-02-25 13:50:00', null);
INSERT INTO `t_csm_task_log` VALUES ('97', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:51:00', '2016-02-25 13:51:00', null);
INSERT INTO `t_csm_task_log` VALUES ('98', '1', '2', '任务执行成功!', '0', '0', '2016-02-25 13:52:00', '2016-02-25 13:52:00', null);

-- ----------------------------
-- Table structure for t_csm_task_param
-- ----------------------------
DROP TABLE IF EXISTS `t_csm_task_param`;
CREATE TABLE `t_csm_task_param` (
  `param_id` int(10) NOT NULL AUTO_INCREMENT,
  `config_id` int(10) NOT NULL,
  `param_name` varchar(32) NOT NULL,
  `param_value` varchar(64) NOT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csm_task_param
-- ----------------------------

-- ----------------------------
-- Table structure for t_csm_task_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `t_csm_task_scheduler`;
CREATE TABLE `t_csm_task_scheduler` (
  `scheduler_id` int(10) NOT NULL AUTO_INCREMENT,
  `module_id` varchar(200) NOT NULL,
  `task_group_flag` varchar(200) NOT NULL,
  `host_ip` varchar(200) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `is_share` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`scheduler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_csm_task_scheduler
-- ----------------------------
INSERT INTO `t_csm_task_scheduler` VALUES ('1', 'cat-cms', 'cat-cms_group_1', '192.168.95.7', '2016-02-25 14:40:39', 'N');

-- ----------------------------
-- Table structure for weixin_command
-- ----------------------------
DROP TABLE IF EXISTS `weixin_command`;
CREATE TABLE `weixin_command` (
  `COMMAND_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `COMMANDCODE` varchar(255) DEFAULT NULL COMMENT '应用路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(1) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`COMMAND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_command
-- ----------------------------
INSERT INTO `weixin_command` VALUES ('2636750f6978451b8330874c9be042c2', '锁定服务器', 'rundll32.exe user32.dll,LockWorkStation', '2015-05-10 21:25:06', '1', '锁定计算机');
INSERT INTO `weixin_command` VALUES ('46217c6d44354010823241ef484f7214', '打开浏览器', 'C:/Program Files/Internet Explorer/iexplore.exe', '2015-05-09 02:43:02', '1', '打开浏览器操作');
INSERT INTO `weixin_command` VALUES ('576adcecce504bf3bb34c6b4da79a177', '关闭浏览器', 'taskkill /f /im iexplore.exe', '2015-05-09 02:36:48', '1', '关闭浏览器操作');
INSERT INTO `weixin_command` VALUES ('854a157c6d99499493f4cc303674c01f', '关闭QQ', 'taskkill /f /im qq.exe', '2015-05-10 21:25:46', '1', '关闭QQ');
INSERT INTO `weixin_command` VALUES ('ab3a8c6310ca4dc8b803ecc547e55ae7', '打开QQ', 'D:/SOFT/QQ/QQ/Bin/qq.exe', '2015-05-10 21:25:25', '1', '打开QQ');

-- ----------------------------
-- Table structure for weixin_imgmsg
-- ----------------------------
DROP TABLE IF EXISTS `weixin_imgmsg`;
CREATE TABLE `weixin_imgmsg` (
  `IMGMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TITLE1` varchar(255) DEFAULT NULL COMMENT '标题1',
  `DESCRIPTION1` varchar(255) DEFAULT NULL COMMENT '描述1',
  `IMGURL1` varchar(255) DEFAULT NULL COMMENT '图片地址1',
  `TOURL1` varchar(255) DEFAULT NULL COMMENT '超链接1',
  `TITLE2` varchar(255) DEFAULT NULL COMMENT '标题2',
  `DESCRIPTION2` varchar(255) DEFAULT NULL COMMENT '描述2',
  `IMGURL2` varchar(255) DEFAULT NULL COMMENT '图片地址2',
  `TOURL2` varchar(255) DEFAULT NULL COMMENT '超链接2',
  `TITLE3` varchar(255) DEFAULT NULL COMMENT '标题3',
  `DESCRIPTION3` varchar(255) DEFAULT NULL COMMENT '描述3',
  `IMGURL3` varchar(255) DEFAULT NULL COMMENT '图片地址3',
  `TOURL3` varchar(255) DEFAULT NULL COMMENT '超链接3',
  `TITLE4` varchar(255) DEFAULT NULL COMMENT '标题4',
  `DESCRIPTION4` varchar(255) DEFAULT NULL COMMENT '描述4',
  `IMGURL4` varchar(255) DEFAULT NULL COMMENT '图片地址4',
  `TOURL4` varchar(255) DEFAULT NULL COMMENT '超链接4',
  `TITLE5` varchar(255) DEFAULT NULL COMMENT '标题5',
  `DESCRIPTION5` varchar(255) DEFAULT NULL COMMENT '描述5',
  `IMGURL5` varchar(255) DEFAULT NULL COMMENT '图片地址5',
  `TOURL5` varchar(255) DEFAULT NULL COMMENT '超链接5',
  `TITLE6` varchar(255) DEFAULT NULL COMMENT '标题6',
  `DESCRIPTION6` varchar(255) DEFAULT NULL COMMENT '描述6',
  `IMGURL6` varchar(255) DEFAULT NULL COMMENT '图片地址6',
  `TOURL6` varchar(255) DEFAULT NULL COMMENT '超链接6',
  `TITLE7` varchar(255) DEFAULT NULL COMMENT '标题7',
  `DESCRIPTION7` varchar(255) DEFAULT NULL COMMENT '描述7',
  `IMGURL7` varchar(255) DEFAULT NULL COMMENT '图片地址7',
  `TOURL7` varchar(255) DEFAULT NULL COMMENT '超链接7',
  `TITLE8` varchar(255) DEFAULT NULL COMMENT '标题8',
  `DESCRIPTION8` varchar(255) DEFAULT NULL COMMENT '描述8',
  `IMGURL8` varchar(255) DEFAULT NULL COMMENT '图片地址8',
  `TOURL8` varchar(255) DEFAULT NULL COMMENT '超链接8',
  PRIMARY KEY (`IMGMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_imgmsg
-- ----------------------------
INSERT INTO `weixin_imgmsg` VALUES ('380b2cb1f4954315b0e20618f7b5bd8f', '首页', '2015-05-10 20:51:09', '1', '图文回复', '图文回复标题', '图文回复描述', 'http://a.hiphotos.baidu.com/image/h%3D360/sign=c6c7e73ebc389b5027ffe654b535e5f1/a686c9177f3e6709392bb8df3ec79f3df8dc55e3.jpg', 'www.baidu.com', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for weixin_textmsg
-- ----------------------------
DROP TABLE IF EXISTS `weixin_textmsg`;
CREATE TABLE `weixin_textmsg` (
  `TEXTMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '内容',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TEXTMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_textmsg
-- ----------------------------
INSERT INTO `weixin_textmsg` VALUES ('303c190498a045bdbba4c940c2f0d9f9', '1ss', '1ssddd', '2015-05-18 20:17:02', '1', '1ssdddsd');
INSERT INTO `weixin_textmsg` VALUES ('63681adbe7144f10b66d6863e07f23c2', '你好', '你也好', '2015-05-09 02:39:23', '1', '文本回复');
INSERT INTO `weixin_textmsg` VALUES ('695cd74779734231928a253107ab0eeb', '吃饭', '吃了噢噢噢噢', '2015-05-10 22:52:27', '1', '文本回复');
INSERT INTO `weixin_textmsg` VALUES ('d4738af7aea74a6ca1a5fb25a98f9acb', '关注', '关注', '2015-05-11 02:12:36', '1', '关注回复');
