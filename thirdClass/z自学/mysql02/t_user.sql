/*
Navicat MySQL Data Transfer

Source Server         : zyq
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : xm

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2019-06-14 22:57:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(10) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `comm` int(10) DEFAULT NULL,
  `sal` int(10) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `d_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `FK_Reference_1` (`pass`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin2', '管理员', '222', '222', '100', '2000', '1', '1');
INSERT INTO `t_user` VALUES ('2', 'zhangsan2', '张三', '2', '2', null, '1000', '0', '3');
INSERT INTO `t_user` VALUES ('3', 'zhangsan1', '张三', '123', '1', '500', '1000', '1', '1');
INSERT INTO `t_user` VALUES ('17', '3332', '111', '333', null, '1000', '20000', '0', '3');
INSERT INTO `t_user` VALUES ('18', '3333', '111', '222', null, null, '5000', '0', '3');
INSERT INTO `t_user` VALUES ('19', '11', '11', '11', '11', '100', '1000', '1', '100');
INSERT INTO `t_user` VALUES ('20', '22', '22', '22', '22', '100', '1000', '1', '1');
INSERT INTO `t_user` VALUES ('21', 'LLL', 'uname', '12345', '222', '100', '100', '1', '1');
INSERT INTO `t_user` VALUES ('22', '555', '555', '12345', '555', '100', '100', '1', '1');
INSERT INTO `t_user` VALUES ('23', 'dddd', '啊', '12345', '333', '100', '100', '1', '1');
