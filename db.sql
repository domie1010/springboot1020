/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.7.32-log : Database - fangwujiaoyipingtai
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fangwujiaoyipingtai` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fangwujiaoyipingtai`;

/*Table structure for table `chushoufangwu` */

DROP TABLE IF EXISTS `chushoufangwu`;

CREATE TABLE `chushoufangwu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `chushoufangwu_name` varchar(200) DEFAULT NULL COMMENT '出售房屋名称  Search111 ',
  `chushoufangwu_uuid_number` varchar(200) DEFAULT NULL COMMENT '出售房屋编号  Search111 ',
  `chushoufangwu_photo` varchar(200) DEFAULT NULL COMMENT '出售房屋照片',
  `chushoufangwu_types` int(11) DEFAULT NULL COMMENT '房屋类型 Search111',
  `chushoufangwu_xinjiu_types` int(11) DEFAULT NULL COMMENT '新房旧房 Search111 ',
  `quyu_types` int(11) DEFAULT NULL COMMENT '区域 Search111',
  `chushoufangwu_xiaoqu` varchar(200) DEFAULT NULL COMMENT '所在小区',
  `chushoufangwu_weizhi` varchar(200) DEFAULT NULL COMMENT '所在详细位置',
  `chushoufangwu_mianji` decimal(10,2) DEFAULT NULL COMMENT '房屋面积  Search111 ',
  `chushoufangwu_old_money` decimal(10,2) DEFAULT NULL COMMENT '原总价 ',
  `chushoufangwu_new_money` decimal(10,2) DEFAULT NULL COMMENT '现总价 Search111 ',
  `chushoufangwu_clicknum` int(11) DEFAULT NULL COMMENT '房屋热度 ',
  `chushoufangwu_content` text COMMENT '出售房屋介绍 ',
  `chushoufangwu_zhuangtai_types` int(11) DEFAULT NULL COMMENT '房屋状态 Search111 ',
  `shangxia_types` int(11) DEFAULT NULL COMMENT '是否上架 ',
  `chushoufangwu_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='出售房屋';

/*Data for the table `chushoufangwu` */

insert  into `chushoufangwu`(`id`,`yonghu_id`,`chushoufangwu_name`,`chushoufangwu_uuid_number`,`chushoufangwu_photo`,`chushoufangwu_types`,`chushoufangwu_xinjiu_types`,`quyu_types`,`chushoufangwu_xiaoqu`,`chushoufangwu_weizhi`,`chushoufangwu_mianji`,`chushoufangwu_old_money`,`chushoufangwu_new_money`,`chushoufangwu_clicknum`,`chushoufangwu_content`,`chushoufangwu_zhuangtai_types`,`shangxia_types`,`chushoufangwu_delete`,`create_time`) values (1,1,'出售房屋名称1','165045491661213','http://localhost:8080/fangwujiaoyipingtai/upload/chushoufangwu1.jpg',2,1,2,'所在小区1','所在详细位置1','449.59','960.14','93.82',456,'出售房屋介绍1',2,1,1,'2022-04-20 19:41:56'),(2,1,'出售房屋名称2','165045491661351','http://localhost:8080/fangwujiaoyipingtai/upload/chushoufangwu2.jpg',3,1,2,'所在小区2','所在详细位置2','243.78','890.36','462.22',374,'出售房屋介绍2',1,1,1,'2022-04-20 19:41:56'),(3,2,'出售房屋名称3','16504549166134','http://localhost:8080/fangwujiaoyipingtai/upload/chushoufangwu3.jpg',2,1,1,'所在小区3','所在详细位置3','849.66','941.99','241.30',340,'出售房屋介绍3',1,1,1,'2022-04-20 19:41:56'),(4,2,'出售房屋名称4','165045491661372','http://localhost:8080/fangwujiaoyipingtai/upload/chushoufangwu4.jpg',3,2,2,'所在小区4','所在详细位置4','689.22','621.69','264.27',322,'出售房屋介绍4',1,1,1,'2022-04-20 19:41:56'),(5,3,'出售房屋名称5','165045491661320','http://localhost:8080/fangwujiaoyipingtai/upload/chushoufangwu5.jpg',3,1,4,'所在小区5','所在详细位置5','25.13','829.65','195.85',482,'出售房屋介绍5',1,1,1,'2022-04-20 19:41:56');

/*Table structure for table `chushoufangwu_collection` */

DROP TABLE IF EXISTS `chushoufangwu_collection`;

CREATE TABLE `chushoufangwu_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chushoufangwu_id` int(11) DEFAULT NULL COMMENT '出售房屋',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `chushoufangwu_collection_types` int(11) DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='出售房屋收藏';

/*Data for the table `chushoufangwu_collection` */

insert  into `chushoufangwu_collection`(`id`,`chushoufangwu_id`,`yonghu_id`,`chushoufangwu_collection_types`,`insert_time`,`create_time`) values (1,1,3,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(2,2,3,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(3,3,3,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(4,4,3,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(5,5,2,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(6,1,1,1,'2022-04-20 20:52:57','2022-04-20 20:52:57'),(7,3,1,1,'2022-04-20 21:19:27','2022-04-20 21:19:27');

/*Table structure for table `chushoufangwu_liuyan` */

DROP TABLE IF EXISTS `chushoufangwu_liuyan`;

CREATE TABLE `chushoufangwu_liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chushoufangwu_id` int(11) DEFAULT NULL COMMENT '出售房屋',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `chushoufangwu_liuyan_text` text COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `reply_text` text COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='出售房屋留言';

/*Data for the table `chushoufangwu_liuyan` */

insert  into `chushoufangwu_liuyan`(`id`,`chushoufangwu_id`,`yonghu_id`,`chushoufangwu_liuyan_text`,`insert_time`,`reply_text`,`update_time`,`create_time`) values (1,1,2,'留言内容1','2022-04-20 19:41:56','回复信息1','2022-04-20 19:41:56','2022-04-20 19:41:56'),(2,2,3,'留言内容2','2022-04-20 19:41:56','回复信息2','2022-04-20 19:41:56','2022-04-20 19:41:56'),(3,3,1,'留言内容3','2022-04-20 19:41:56','回复信息3','2022-04-20 19:41:56','2022-04-20 19:41:56'),(4,4,3,'留言内容4','2022-04-20 19:41:56','回复信息4','2022-04-20 19:41:56','2022-04-20 19:41:56'),(5,5,3,'留言内容5','2022-04-20 19:41:56','回复信息5','2022-04-20 19:41:56','2022-04-20 19:41:56'),(6,1,1,'1112sagsagsa','2022-04-20 21:17:37','53454saag','2022-04-20 21:21:50','2022-04-20 21:17:37'),(7,5,1,'啥阿嘎事故','2022-04-20 21:17:51',NULL,NULL,'2022-04-20 21:17:51');

/*Table structure for table `chushoufangwu_order` */

DROP TABLE IF EXISTS `chushoufangwu_order`;

CREATE TABLE `chushoufangwu_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chushoufangwu_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '看房编号 Search111 ',
  `chushoufangwu_id` int(11) DEFAULT NULL COMMENT '出售房屋',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `chushoufangwu_order_name` varchar(200) DEFAULT NULL COMMENT '申请看房人姓名 Search111 ',
  `chushoufangwu_order_phone` varchar(200) DEFAULT NULL COMMENT '申请看房人联系电话 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `kanfang_time` timestamp NULL DEFAULT NULL COMMENT '看房时间',
  `chushoufangwu_order_yesno_types` int(11) DEFAULT NULL COMMENT '审核状态 Search111 ',
  `chushoufangwu_order_yesno_text` text COMMENT '回复内容',
  `chushoufangwu_order_shenhe_time` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='预约出售房屋看房';

/*Data for the table `chushoufangwu_order` */

insert  into `chushoufangwu_order`(`id`,`chushoufangwu_order_uuid_number`,`chushoufangwu_id`,`yonghu_id`,`chushoufangwu_order_name`,`chushoufangwu_order_phone`,`insert_time`,`kanfang_time`,`chushoufangwu_order_yesno_types`,`chushoufangwu_order_yesno_text`,`chushoufangwu_order_shenhe_time`,`create_time`) values (2,'1650459803742',5,1,'张三','17703789595','2022-04-20 21:03:24','2022-04-21 00:00:00',1,NULL,NULL,'2022-04-20 21:03:24'),(3,'1650459826124',4,1,'张三','17703785858','2022-04-20 21:03:46','2022-04-22 00:00:00',3,'很忙  没有时间,约个其他时间吧','2022-04-20 21:23:28','2022-04-20 21:03:46'),(4,'1650460584292',3,1,'李四','17703785959','2022-04-20 21:16:24','2022-04-29 00:00:00',2,'撒嘎嘎哈斯多喝点水','2022-04-20 21:23:06','2022-04-20 21:16:24');

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`) values (1,'轮播图1','http://localhost:8080/fangwujiaoyipingtai/upload/config1.jpg'),(2,'轮播图2','http://localhost:8080/fangwujiaoyipingtai/upload/config2.jpg'),(3,'轮播图3','http://localhost:8080/fangwujiaoyipingtai/upload/config3.jpg');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int(11) DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int(11) DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='字典';

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`dic_code`,`dic_name`,`code_index`,`index_name`,`super_id`,`beizhu`,`create_time`) values (1,'sex_types','性别类型',1,'男',NULL,NULL,'2022-04-20 19:38:22'),(2,'sex_types','性别类型',2,'女',NULL,NULL,'2022-04-20 19:38:22'),(3,'chushoufangwu_zhuangtai_types','房屋状态',1,'在销售',NULL,NULL,'2022-04-20 19:38:22'),(4,'chushoufangwu_zhuangtai_types','房屋状态',2,'已售出',NULL,NULL,'2022-04-20 19:38:22'),(5,'shangxia_types','上下架',1,'上架',NULL,NULL,'2022-04-20 19:38:22'),(6,'shangxia_types','上下架',2,'下架',NULL,NULL,'2022-04-20 19:38:22'),(7,'chushoufangwu_types','出售房屋类型',1,'两室一厅',NULL,NULL,'2022-04-20 19:38:22'),(8,'chushoufangwu_types','出售房屋类型',2,'三室一厅',NULL,NULL,'2022-04-20 19:38:22'),(9,'chushoufangwu_types','出售房屋类型',3,'小洋房',NULL,NULL,'2022-04-20 19:38:22'),(10,'chushoufangwu_types','出售房屋类型',4,'大洋房',NULL,NULL,'2022-04-20 19:38:22'),(11,'chushoufangwu_xinjiu_types','新房旧房',1,'新房',NULL,NULL,'2022-04-20 19:38:22'),(12,'chushoufangwu_xinjiu_types','新房旧房',2,'二手房',NULL,NULL,'2022-04-20 19:38:22'),(13,'quyu_types','区域',1,'区域1',NULL,NULL,'2022-04-20 19:38:22'),(14,'quyu_types','区域',2,'区域2',NULL,NULL,'2022-04-20 19:38:22'),(15,'quyu_types','区域',3,'区域3',NULL,NULL,'2022-04-20 19:38:22'),(16,'quyu_types','区域',4,'区域4',NULL,NULL,'2022-04-20 19:38:22'),(17,'chushoufangwu_collection_types','收藏表类型',1,'收藏',NULL,NULL,'2022-04-20 19:38:22'),(18,'chushoufangwu_order_yesno_types','审核状态',1,'待审核',NULL,NULL,'2022-04-20 19:38:23'),(19,'chushoufangwu_order_yesno_types','审核状态',2,'同意',NULL,NULL,'2022-04-20 19:38:23'),(20,'chushoufangwu_order_yesno_types','审核状态',3,'拒绝',NULL,NULL,'2022-04-20 19:38:23'),(21,'zufang_zhuangtai_types','房屋状态',1,'在出租',NULL,NULL,'2022-04-20 19:38:23'),(22,'zufang_zhuangtai_types','房屋状态',2,'已出租',NULL,NULL,'2022-04-20 19:38:23'),(23,'zufang_types','出租房屋类型',1,'两室一厅',NULL,NULL,'2022-04-20 19:38:23'),(24,'zufang_types','出租房屋类型',2,'三室一厅',NULL,NULL,'2022-04-20 19:38:23'),(25,'zufang_types','出租房屋类型',3,'小洋房',NULL,NULL,'2022-04-20 19:38:23'),(26,'zufang_types','出租房屋类型',4,'大洋房',NULL,NULL,'2022-04-20 19:38:23'),(27,'zufang_collection_types','收藏表类型',1,'收藏',NULL,NULL,'2022-04-20 19:38:23'),(28,'zufang_order_yesno_types','审核状态',1,'待审核',NULL,NULL,'2022-04-20 19:38:23'),(29,'zufang_order_yesno_types','审核状态',2,'同意',NULL,NULL,'2022-04-20 19:38:23'),(30,'zufang_order_yesno_types','审核状态',3,'拒绝',NULL,NULL,'2022-04-20 19:38:23'),(31,'gonggao_types','公告类型',1,'公告类型1',NULL,NULL,'2022-04-20 19:38:23'),(32,'gonggao_types','公告类型',2,'公告类型2',NULL,NULL,'2022-04-20 19:38:23'),(33,'chushoufangwu_types','出售房屋类型',5,'房屋类型1',NULL,'','2022-04-20 21:20:05'),(34,'quyu_types','区域',5,'区域5',NULL,'','2022-04-20 21:20:17');

/*Table structure for table `gonggao` */

DROP TABLE IF EXISTS `gonggao`;

CREATE TABLE `gonggao` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `gonggao_name` varchar(200) DEFAULT NULL COMMENT '公告名称 Search111  ',
  `gonggao_photo` varchar(200) DEFAULT NULL COMMENT '公告图片 ',
  `gonggao_types` int(11) NOT NULL COMMENT '公告类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '公告发布时间 ',
  `gonggao_content` text COMMENT '公告详情 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='公告';

/*Data for the table `gonggao` */

insert  into `gonggao`(`id`,`gonggao_name`,`gonggao_photo`,`gonggao_types`,`insert_time`,`gonggao_content`,`create_time`) values (1,'公告名称1','http://localhost:8080/fangwujiaoyipingtai/upload/gonggao1.jpg',2,'2022-04-20 19:41:56','公告详情1','2022-04-20 19:41:56'),(2,'公告名称2','http://localhost:8080/fangwujiaoyipingtai/upload/gonggao2.jpg',1,'2022-04-20 19:41:56','公告详情2','2022-04-20 19:41:56'),(3,'公告名称3','http://localhost:8080/fangwujiaoyipingtai/upload/gonggao3.jpg',2,'2022-04-20 19:41:56','公告详情3','2022-04-20 19:41:56'),(4,'公告名称4','http://localhost:8080/fangwujiaoyipingtai/upload/gonggao4.jpg',1,'2022-04-20 19:41:56','公告详情4','2022-04-20 19:41:56'),(5,'公告名称5','http://localhost:8080/fangwujiaoyipingtai/upload/gonggao5.jpg',2,'2022-04-20 19:41:56','公告详情5','2022-04-20 19:41:56');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,6,'admin','users','管理员','bhbdquzeizfo9o7mnkvfjc4ztguxiail','2022-04-20 19:45:33','2022-04-20 22:24:34'),(2,1,'a1','yonghu','用户','rp47vw6xyotn7kvoexwqnxo1oywix0lq','2022-04-20 20:00:13','2022-04-20 22:20:49'),(3,2,'a2','yonghu','用户','whwo2hudqklzs6yxhlh5kewlarc3uuag','2022-04-20 21:12:59','2022-04-20 22:22:31');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (6,'admin','admin','管理员','2022-05-02 14:51:13');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`username`,`password`,`yonghu_name`,`yonghu_phone`,`yonghu_id_number`,`yonghu_photo`,`sex_types`,`yonghu_email`,`create_time`) values (1,'a1','123456','用户姓名1','17703786901','410224199610232001','http://localhost:8080/fangwujiaoyipingtai/upload/yonghu1.jpg',2,'1@qq.com','2022-04-20 19:41:56'),(2,'a2','123456','用户姓名2','17703786902','410224199610232002','http://localhost:8080/fangwujiaoyipingtai/upload/yonghu2.jpg',2,'2@qq.com','2022-04-20 19:41:56'),(3,'a3','123456','用户姓名3','17703786903','410224199610232003','http://localhost:8080/fangwujiaoyipingtai/upload/yonghu3.jpg',1,'3@qq.com','2022-04-20 19:41:56');

/*Table structure for table `zufang` */

DROP TABLE IF EXISTS `zufang`;

CREATE TABLE `zufang` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `zufang_name` varchar(200) DEFAULT NULL COMMENT '房屋名称  Search111 ',
  `zufang_uuid_number` varchar(200) DEFAULT NULL COMMENT '房屋编号  Search111 ',
  `zufang_photo` varchar(200) DEFAULT NULL COMMENT '租房照片',
  `zufang_types` int(11) DEFAULT NULL COMMENT '出租房屋类型 Search111',
  `quyu_types` int(11) DEFAULT NULL COMMENT '区域 Search111',
  `zufang_xiaoqu` varchar(200) DEFAULT NULL COMMENT '所在小区',
  `zufang_weizhi` varchar(200) DEFAULT NULL COMMENT '所在详细位置',
  `zufang_mianji` decimal(10,2) DEFAULT NULL COMMENT '房屋面积  Search111 ',
  `zufang_old_money` decimal(10,2) DEFAULT NULL COMMENT '原价/月 ',
  `zufang_new_money` decimal(10,2) DEFAULT NULL COMMENT '现加/月 Search111 ',
  `zufang_clicknum` int(11) DEFAULT NULL COMMENT '房屋热度 ',
  `zufang_content` text COMMENT '房屋介绍 ',
  `zufang_zhuangtai_types` int(11) DEFAULT NULL COMMENT '房屋状态 Search111 ',
  `shangxia_types` int(11) DEFAULT NULL COMMENT '是否上架 ',
  `zufang_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='租房';

/*Data for the table `zufang` */

insert  into `zufang`(`id`,`yonghu_id`,`zufang_name`,`zufang_uuid_number`,`zufang_photo`,`zufang_types`,`quyu_types`,`zufang_xiaoqu`,`zufang_weizhi`,`zufang_mianji`,`zufang_old_money`,`zufang_new_money`,`zufang_clicknum`,`zufang_content`,`zufang_zhuangtai_types`,`shangxia_types`,`zufang_delete`,`create_time`) values (1,1,'房屋名称1','165045491663141','http://localhost:8080/fangwujiaoyipingtai/upload/zufang1.jpg',3,1,'所在小区1','所在详细位置1','4.51','738.30','444.07',423,'房屋介绍1',2,1,1,'2022-04-20 19:41:56'),(2,1,'房屋名称2','165045491663122','http://localhost:8080/fangwujiaoyipingtai/upload/zufang2.jpg',1,4,'所在小区2','所在详细位置2','74.97','710.56','108.93',205,'<p>房屋介绍2</p>',1,1,1,'2022-04-20 19:41:56'),(3,2,'房屋名称3','165045491663115','http://localhost:8080/fangwujiaoyipingtai/upload/zufang3.jpg',4,2,'所在小区3','所在详细位置3','551.05','924.92','333.54',181,'房屋介绍3',1,1,1,'2022-04-20 19:41:56'),(4,2,'房屋名称4','165045491663182','http://localhost:8080/fangwujiaoyipingtai/upload/zufang4.jpg',4,4,'所在小区4','所在详细位置4','74.90','707.30','77.08',179,'房屋介绍4',1,1,1,'2022-04-20 19:41:56'),(5,3,'房屋名称5','165045491663189','http://localhost:8080/fangwujiaoyipingtai/upload/zufang5.jpg',3,1,'所在小区5','所在详细位置5','617.05','811.27','39.39',345,'房屋介绍5',1,1,1,'2022-04-20 19:41:56');

/*Table structure for table `zufang_collection` */

DROP TABLE IF EXISTS `zufang_collection`;

CREATE TABLE `zufang_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zufang_id` int(11) DEFAULT NULL COMMENT '租房',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `zufang_collection_types` int(11) DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='租房收藏';

/*Data for the table `zufang_collection` */

insert  into `zufang_collection`(`id`,`zufang_id`,`yonghu_id`,`zufang_collection_types`,`insert_time`,`create_time`) values (1,1,1,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(2,2,1,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(3,3,3,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(4,4,1,1,'2022-04-20 19:41:56','2022-04-20 19:41:56'),(5,5,1,1,'2022-04-20 19:41:56','2022-04-20 19:41:56');

/*Table structure for table `zufang_liuyan` */

DROP TABLE IF EXISTS `zufang_liuyan`;

CREATE TABLE `zufang_liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zufang_id` int(11) DEFAULT NULL COMMENT '租房',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `zufang_liuyan_text` text COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `reply_text` text COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='租房留言';

/*Data for the table `zufang_liuyan` */

insert  into `zufang_liuyan`(`id`,`zufang_id`,`yonghu_id`,`zufang_liuyan_text`,`insert_time`,`reply_text`,`update_time`,`create_time`) values (1,1,1,'留言内容1','2022-04-20 19:41:56','回复信息1','2022-04-20 19:41:56','2022-04-20 19:41:56'),(2,2,1,'留言内容2','2022-04-20 19:41:56','回复信息2','2022-04-20 19:41:56','2022-04-20 19:41:56'),(3,3,3,'留言内容3','2022-04-20 19:41:56','回复信息3','2022-04-20 19:41:56','2022-04-20 19:41:56'),(4,4,1,'留言内容4','2022-04-20 19:41:56','回复信息4','2022-04-20 19:41:56','2022-04-20 19:41:56'),(5,5,3,'留言内容5','2022-04-20 19:41:56','回复信息5','2022-04-20 19:41:56','2022-04-20 19:41:56');

/*Table structure for table `zufang_order` */

DROP TABLE IF EXISTS `zufang_order`;

CREATE TABLE `zufang_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zufang_order_uuid_number` varchar(200) DEFAULT NULL COMMENT '看房编号 Search111 ',
  `zufang_id` int(11) DEFAULT NULL COMMENT '租房',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `zufang_order_name` varchar(200) DEFAULT NULL COMMENT '申请看房人姓名 Search111 ',
  `zufang_order_phone` varchar(200) DEFAULT NULL COMMENT '申请看房人联系电话 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `kanfang_time` timestamp NULL DEFAULT NULL COMMENT '看房时间',
  `zufang_order_yesno_types` int(11) DEFAULT NULL COMMENT '审核状态 Search111 ',
  `zufang_order_yesno_text` text COMMENT '回复内容',
  `zufang_order_shenhe_time` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='预约租房看房';

/*Data for the table `zufang_order` */

insert  into `zufang_order`(`id`,`zufang_order_uuid_number`,`zufang_id`,`yonghu_id`,`zufang_order_name`,`zufang_order_phone`,`insert_time`,`kanfang_time`,`zufang_order_yesno_types`,`zufang_order_yesno_text`,`zufang_order_shenhe_time`,`create_time`) values (1,'1650460511674',5,1,'李四','17703789595','2022-04-20 21:15:12','2022-04-29 07:00:00',1,NULL,NULL,'2022-04-20 21:15:12'),(2,'1650460748724',4,1,'胡琪','17789895656','2022-04-20 21:19:09','2022-04-30 00:00:00',2,'来吧,当天有空,准时来看房','2022-04-20 21:22:53','2022-04-20 21:19:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
