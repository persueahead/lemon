/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-07 12:51:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` int(20) NOT NULL AUTO_INCREMENT COMMENT '教职工编号',
  `teachername` varchar(20) NOT NULL COMMENT '教职工姓名',
  `teacherAge` int(10) NOT NULL COMMENT '教职工年龄',
  `teacherSex` varchar(10) NOT NULL COMMENT '教职工性别',
  `teacherDept` varchar(20) NOT NULL COMMENT '教职工系别',
  `teacherTel` varchar(20) NOT NULL COMMENT '教职工电话',
  `teacherAddress` varchar(50) NOT NULL COMMENT '教职工地址',
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3', '金', '188', '男', '刺客', '15141465156', '岛国');
INSERT INTO `teacher` VALUES ('4', '雷纳', '18', '女', '太阳系', '15849653214', '黑洞村');
INSERT INTO `teacher` VALUES ('6', '啊q', '26', '男', '史前文明', '2515151515', '德古拉山脉');
INSERT INTO `teacher` VALUES ('7', '小魔仙', '22', '女', '魔仙希', '12212121211', '艾欧里亚');
