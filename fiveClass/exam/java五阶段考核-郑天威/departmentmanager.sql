/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : departmentmanager

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2020-04-12 17:48:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depart_info
-- ----------------------------
DROP TABLE IF EXISTS `depart_info`;
CREATE TABLE `depart_info` (
  `DEP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEP_NAME` varchar(50) NOT NULL,
  `DEP_STATE` int(11) NOT NULL DEFAULT '0',
  `DEP_DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DEP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart_info
-- ----------------------------
INSERT INTO `depart_info` VALUES ('1', '生产部', '0', '生产mm');
INSERT INTO `depart_info` VALUES ('2', '销售部', '0', 'sales');
INSERT INTO `depart_info` VALUES ('3', '人事部', '0', 'recruit');
INSERT INTO `depart_info` VALUES ('4', '研发部', '0', '研发');
INSERT INTO `depart_info` VALUES ('5', '端茶倒水部', '0', '友好助力');
INSERT INTO `depart_info` VALUES ('6', '业务部', '0', '处理业务');
INSERT INTO `depart_info` VALUES ('7', '文娱部', '0', '文化娱乐');
INSERT INTO `depart_info` VALUES ('8', '节庆部', '0', '过节');
INSERT INTO `depart_info` VALUES ('9', '外交部', '0', '搞外交');
INSERT INTO `depart_info` VALUES ('10', '铁子部', '0', '都是铁子');
INSERT INTO `depart_info` VALUES ('11', '月下交友部', '0', '五湖四海，都是基友');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) NOT NULL,
  `manager_password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`manager_id`),
  KEY `m_r_forenkey` (`role_id`),
  CONSTRAINT `m_r_forenkey` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'joe', '$2a$10$Sv5lnVALEjliTi/1SZBLcelApTJVqg6PaNyLJhbo7TrF9ABFhbwHq', '1');
INSERT INTO `manager` VALUES ('2', 'jak', '$2a$10$1/dbNLSdHOnr./c2meE9HOITWFtDsfsQYA8OnDnbUE2vHzIYbRrqy', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEP_ID` int(11) DEFAULT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_SEX` varchar(6) NOT NULL,
  `USER_STATE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`),
  KEY `FK_Reference_1` (`DEP_ID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`DEP_ID`) REFERENCES `depart_info` (`DEP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '5', '王老吉', '男', '0');
INSERT INTO `user_info` VALUES ('2', '2', '李四', '男', '0');
INSERT INTO `user_info` VALUES ('3', '3', '翠花', '女', '0');
INSERT INTO `user_info` VALUES ('4', '3', '小红', '女', '0');
INSERT INTO `user_info` VALUES ('5', '2', '秋香', '女', '0');
INSERT INTO `user_info` VALUES ('8', '1', '鄙人', '男', '0');
INSERT INTO `user_info` VALUES ('9', '3', '帅比', '男', '0');
INSERT INTO `user_info` VALUES ('10', '7', '李白', '男', '0');
INSERT INTO `user_info` VALUES ('11', '6', '神农', '男', '0');
INSERT INTO `user_info` VALUES ('12', '8', '懒羊羊', '男', '0');
INSERT INTO `user_info` VALUES ('13', '6', '小李', '男', '0');
INSERT INTO `user_info` VALUES ('14', '1', '武松', '男', '0');
INSERT INTO `user_info` VALUES ('15', '2', '夏娃', '女', '0');
INSERT INTO `user_info` VALUES ('16', '5', '小李子', '男', '0');
