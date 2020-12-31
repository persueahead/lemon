/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.100
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : 192.168.0.100:3306
 Source Schema         : scots

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 12/11/2019 22:57:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pMenuId` int(11) NULL DEFAULT NULL,
  `menuUrl` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', 0, NULL);
INSERT INTO `menu` VALUES (2, '报销管理', 0, NULL);
INSERT INTO `menu` VALUES (3, '财务管理', 0, NULL);
INSERT INTO `menu` VALUES (4, '用户管理', 1, 'system/usersListQueryServlet');
INSERT INTO `menu` VALUES (5, '费用管理', 1, NULL);
INSERT INTO `menu` VALUES (6, '个人信息', 1, 'view/system/user/userinfo_show.jsp');
INSERT INTO `menu` VALUES (7, '我的薪资', 1, NULL);
INSERT INTO `menu` VALUES (8, '报销单', 2, NULL);
INSERT INTO `menu` VALUES (9, '经理审批', 2, NULL);
INSERT INTO `menu` VALUES (10, '报销查询', 2, NULL);
INSERT INTO `menu` VALUES (11, '我的报销', 2, NULL);
INSERT INTO `menu` VALUES (12, '财务审批', 3, NULL);
INSERT INTO `menu` VALUES (13, '薪资发放', 3, NULL);
INSERT INTO `menu` VALUES (14, '薪资查询', 3, NULL);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `menuId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`menuId`, `roleId`) USING BTREE,
  INDEX `FK_role_menu2`(`roleId`) USING BTREE,
  CONSTRAINT `FK_role_menu` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_role_menu2` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (3, 1);
INSERT INTO `role_menu` VALUES (4, 1);
INSERT INTO `role_menu` VALUES (5, 1);
INSERT INTO `role_menu` VALUES (6, 1);
INSERT INTO `role_menu` VALUES (7, 1);
INSERT INTO `role_menu` VALUES (8, 1);
INSERT INTO `role_menu` VALUES (9, 1);
INSERT INTO `role_menu` VALUES (10, 1);
INSERT INTO `role_menu` VALUES (11, 1);
INSERT INTO `role_menu` VALUES (12, 1);
INSERT INTO `role_menu` VALUES (13, 1);
INSERT INTO `role_menu` VALUES (14, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (6, 2);
INSERT INTO `role_menu` VALUES (7, 2);
INSERT INTO `role_menu` VALUES (8, 2);
INSERT INTO `role_menu` VALUES (9, 2);
INSERT INTO `role_menu` VALUES (10, 2);
INSERT INTO `role_menu` VALUES (11, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (5, 3);
INSERT INTO `role_menu` VALUES (6, 3);
INSERT INTO `role_menu` VALUES (7, 3);
INSERT INTO `role_menu` VALUES (8, 3);
INSERT INTO `role_menu` VALUES (11, 3);
INSERT INTO `role_menu` VALUES (12, 3);
INSERT INTO `role_menu` VALUES (13, 3);
INSERT INTO `role_menu` VALUES (14, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (2, 4);
INSERT INTO `role_menu` VALUES (6, 4);
INSERT INTO `role_menu` VALUES (7, 4);
INSERT INTO `role_menu` VALUES (8, 4);
INSERT INTO `role_menu` VALUES (11, 4);

-- ----------------------------
-- Table structure for t_audit_recoud
-- ----------------------------
DROP TABLE IF EXISTS `t_audit_recoud`;
CREATE TABLE `t_audit_recoud`  (
  `auditId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) NULL DEFAULT NULL,
  `expemseId` int(11) NULL DEFAULT NULL,
  `auditState` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auditSugg` varchar(88) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auditDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`auditId`) USING BTREE,
  INDEX `FK_Relationship_5`(`expemseId`) USING BTREE,
  INDEX `FK_Relationship_6`(`usersId`) USING BTREE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`expemseId`) REFERENCES `t_expemse` (`expemseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_cost
-- ----------------------------
DROP TABLE IF EXISTS `t_cost`;
CREATE TABLE `t_cost`  (
  `costId` int(11) NOT NULL AUTO_INCREMENT,
  `costName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `costDesc` varchar(66) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `costMrak` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`costId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_expemse
-- ----------------------------
DROP TABLE IF EXISTS `t_expemse`;
CREATE TABLE `t_expemse`  (
  `expemseId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) NULL DEFAULT NULL,
  `expemseIdName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expemseIdDesc` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expemseToltel` float NULL DEFAULT NULL,
  `expemseState` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expemseDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`expemseId`) USING BTREE,
  INDEX `FK_Relationship_2`(`usersId`) USING BTREE,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_expemse_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_expemse_detail`;
CREATE TABLE `t_expemse_detail`  (
  `detailId` int(11) NOT NULL AUTO_INCREMENT,
  `expemseId` int(11) NULL DEFAULT NULL,
  `costId` int(11) NULL DEFAULT NULL,
  `detailName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detailMonery` float NULL DEFAULT NULL,
  PRIMARY KEY (`detailId`) USING BTREE,
  INDEX `FK_Relationship_3`(`expemseId`) USING BTREE,
  INDEX `FK_Relationship_4`(`costId`) USING BTREE,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`expemseId`) REFERENCES `t_expemse` (`expemseId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`costId`) REFERENCES `t_cost` (`costId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员');
INSERT INTO `t_role` VALUES (2, '经理');
INSERT INTO `t_role` VALUES (3, '财务');
INSERT INTO `t_role` VALUES (4, '普通员工');

-- ----------------------------
-- Table structure for t_salary_record
-- ----------------------------
DROP TABLE IF EXISTS `t_salary_record`;
CREATE TABLE `t_salary_record`  (
  `salaryId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) NULL DEFAULT NULL,
  `salaryMonth` datetime(0) NULL DEFAULT NULL,
  `salaryDate` datetime(0) NULL DEFAULT NULL,
  `salaryComm` float NULL DEFAULT NULL,
  `salaryBasic` float NULL DEFAULT NULL,
  PRIMARY KEY (`salaryId`) USING BTREE,
  INDEX `FK_Relationship_1`(`usersId`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `usersId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NULL DEFAULT NULL,
  `usersName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersAge` int(11) NULL DEFAULT NULL,
  `usersSex` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersSalary` float NULL DEFAULT NULL,
  `usersAccout` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersPwd` varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usersMrak` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`usersId`) USING BTREE,
  INDEX `FK_Relationship_7`(`roleId`) USING BTREE,
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (1, 1, '老陈', 23, '保密', '1008511', 1212, 'admin', 'admin', '0');
INSERT INTO `t_users` VALUES (2, 4, 'jack', 23, '男', '1008611', 123, 'jack', 'jack', '0');
INSERT INTO `t_users` VALUES (3, 3, 'tom', 123, '女', '123123', 111, 'tom', 'tom', '0');
INSERT INTO `t_users` VALUES (4, 4, 'op', 121, '女', '12321', 1212, 'op', 'op', '0');
INSERT INTO `t_users` VALUES (8, 4, 'qwqw', 23, NULL, '121', 131212, '1231', '123', '0');
INSERT INTO `t_users` VALUES (9, 4, 'qwqw', 123, NULL, '123', 123, '12qwqw', 'qwqw', '0');
INSERT INTO `t_users` VALUES (10, 4, 'qwqw', 123, '男', '123', 123, '12qwqw', 'qwqw', '0');
INSERT INTO `t_users` VALUES (11, 3, 'tomtomtotm', 23, '男', '121', 131212, 'admin', 'admin', '0');

SET FOREIGN_KEY_CHECKS = 1;
