/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : four

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-20 00:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_audit_record
-- ----------------------------
DROP TABLE IF EXISTS `t_audit_record`;
CREATE TABLE `t_audit_record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `expenseId` int(11) DEFAULT NULL,
  `recordState` varchar(32) DEFAULT NULL,
  `recordSugg` varchar(120) DEFAULT NULL,
  `recordDate` datetime DEFAULT NULL,
  PRIMARY KEY (`recordId`),
  KEY `FK_Relationship_7` (`usersId`),
  KEY `FK_Relationship_8` (`expenseId`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`expenseId`) REFERENCES `t_expense` (`expenseId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_audit_record
-- ----------------------------
INSERT INTO `t_audit_record` VALUES ('1', '5', '4', '3', '小伙子有前途', '2019-12-15 11:49:13');
INSERT INTO `t_audit_record` VALUES ('2', '5', '7', '3', '有前途', '2019-12-15 11:52:09');
INSERT INTO `t_audit_record` VALUES ('3', '5', '2', '-3', '我就不通过', '2019-12-15 15:02:41');
INSERT INTO `t_audit_record` VALUES ('4', '5', '5', '3', '通过', '2019-12-16 00:22:38');
INSERT INTO `t_audit_record` VALUES ('5', '5', '2', '3', 'qwrqarfar ', '2019-12-16 00:26:36');
INSERT INTO `t_audit_record` VALUES ('6', '5', '4', '4', '我看好你小伙子', '2019-12-16 16:52:21');
INSERT INTO `t_audit_record` VALUES ('7', '5', '2', '-4', '就不通过', '2019-12-16 20:56:44');
INSERT INTO `t_audit_record` VALUES ('8', '5', '2', '3', '爷批准了', '2019-12-17 13:51:22');
INSERT INTO `t_audit_record` VALUES ('9', '4', '9', '3', '同意了', '2019-12-17 13:58:04');
INSERT INTO `t_audit_record` VALUES ('10', '5', '10', '3', '玩得愉快', '2019-12-17 14:09:40');
INSERT INTO `t_audit_record` VALUES ('11', '5', '11', '3', 'en,批准了', '2019-12-17 14:18:32');

-- ----------------------------
-- Table structure for t_cost
-- ----------------------------
DROP TABLE IF EXISTS `t_cost`;
CREATE TABLE `t_cost` (
  `costId` int(11) NOT NULL AUTO_INCREMENT,
  `costName` varchar(25) DEFAULT NULL,
  `costDesc` varchar(120) DEFAULT NULL,
  `costMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`costId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cost
-- ----------------------------
INSERT INTO `t_cost` VALUES ('1', 'ktv', '文明人不叫小姐，只叫女生，消费不能超过八小时', '1');
INSERT INTO `t_cost` VALUES ('2', '飞机票', '过境拘留不算，报销三分之二', '0');
INSERT INTO `t_cost` VALUES ('3', '酒店', '满汉全席除外，不超过十桌', '0');
INSERT INTO `t_cost` VALUES ('4', '宾馆', '小电话自费，其他全包', '0');
INSERT INTO `t_cost` VALUES ('5', '洗脚', '带上司去全免，私自去报一半', '0');
INSERT INTO `t_cost` VALUES ('6', '扎金花', '输的超过一万打人', '1');
INSERT INTO `t_cost` VALUES ('7', '泡澡', '男女搭配干活不累', '1');
INSERT INTO `t_cost` VALUES ('8', '结婚一个月', '蜜月可选择地点', '1');
INSERT INTO `t_cost` VALUES ('9', '鸳鸯戏水', '不可描述，自行脑补，及时上报', '1');
INSERT INTO `t_cost` VALUES ('10', '约炮', '不可描述', '0');
INSERT INTO `t_cost` VALUES ('11', '打游戏', '好多游戏', '0');
INSERT INTO `t_cost` VALUES ('12', '逛街', '逛想逛的地方', '0');
INSERT INTO `t_cost` VALUES ('13', '打球', '乒乓球搞一搞', '0');
INSERT INTO `t_cost` VALUES ('14', 'ktv', '卡拉ok，只要漂亮小姐姐', '0');

-- ----------------------------
-- Table structure for t_expense
-- ----------------------------
DROP TABLE IF EXISTS `t_expense`;
CREATE TABLE `t_expense` (
  `expenseId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `expenseName` varchar(20) DEFAULT NULL,
  `expenseDesc` varchar(120) DEFAULT NULL,
  `expenseTotal` float DEFAULT NULL,
  `expenseDate` datetime DEFAULT NULL,
  `expenseState` varchar(3) DEFAULT NULL,
  `expenseMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`expenseId`),
  KEY `FK_Relationship_4` (`usersId`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expense
-- ----------------------------
INSERT INTO `t_expense` VALUES ('2', '5', '出差', '我都麻木了你还问', '900', '2019-12-10 21:51:37', '3', '0');
INSERT INTO `t_expense` VALUES ('4', '5', '约炮', '就问你包不报销吧', '1100', '2019-12-10 22:05:20', '4', '0');
INSERT INTO `t_expense` VALUES ('5', '5', '22', '222222222222', '222', '2019-12-10 22:07:40', '3', '0');
INSERT INTO `t_expense` VALUES ('7', '5', '外交', '去女儿国外交', '2500', '2019-12-10 22:19:14', '3', '0');
INSERT INTO `t_expense` VALUES ('8', '5', '看电影', '陪外国妹子看电影', '1300', '2019-12-13 14:20:52', '0', '0');
INSERT INTO `t_expense` VALUES ('9', '5', '旅游', '夏威夷', '1800', '2019-12-16 15:59:06', '3', '0');
INSERT INTO `t_expense` VALUES ('10', '5', '陪客', '配领导', '3500', '2019-12-17 14:09:14', '3', '0');
INSERT INTO `t_expense` VALUES ('11', '5', '世界那么大我想去看看', '去各种奇妙的地方', '4400', '2019-12-17 14:15:04', '3', '0');

-- ----------------------------
-- Table structure for t_expense_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_expense_detail`;
CREATE TABLE `t_expense_detail` (
  `detailId` int(11) NOT NULL AUTO_INCREMENT,
  `costId` int(11) DEFAULT NULL,
  `expenseId` int(11) DEFAULT NULL,
  `detailDesc` varchar(120) DEFAULT NULL,
  `detailMoney` float DEFAULT NULL,
  `detailMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`detailId`),
  KEY `FK_Relationship_5` (`expenseId`) USING BTREE,
  KEY `FK_Relationship_6` (`costId`) USING BTREE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`expenseId`) REFERENCES `t_expense` (`expenseId`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`costId`) REFERENCES `t_cost` (`costId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expense_detail
-- ----------------------------
INSERT INTO `t_expense_detail` VALUES ('1', '2', '2', '开飞机你信不', '500', '0');
INSERT INTO `t_expense_detail` VALUES ('2', '3', '2', '砸酒店', '400', '0');
INSERT INTO `t_expense_detail` VALUES ('5', '3', '4', '酒店你懂的', '500', '0');
INSERT INTO `t_expense_detail` VALUES ('6', '5', '4', '年龄22一下', '600', '0');
INSERT INTO `t_expense_detail` VALUES ('7', '2', '5', '22222222', '222', '0');
INSERT INTO `t_expense_detail` VALUES ('9', '5', '7', '前奏', '500', '0');
INSERT INTO `t_expense_detail` VALUES ('10', '10', '7', '陶冶情操', '2000', '0');
INSERT INTO `t_expense_detail` VALUES ('11', '3', '8', '你猜啊', '200', '0');
INSERT INTO `t_expense_detail` VALUES ('12', '4', '8', '你猜啊', '300', '0');
INSERT INTO `t_expense_detail` VALUES ('13', '5', '8', '你猜啊', '500', '0');
INSERT INTO `t_expense_detail` VALUES ('14', '11', '8', '你猜啊', '300', '0');
INSERT INTO `t_expense_detail` VALUES ('15', '2', '9', '飞机有点豪华', '600', '0');
INSERT INTO `t_expense_detail` VALUES ('16', '3', '9', '人有点多', '1200', '0');
INSERT INTO `t_expense_detail` VALUES ('17', '2', '10', '飞到太平洋', '500', '0');
INSERT INTO `t_expense_detail` VALUES ('18', '12', '10', '逛and买', '1000', '0');
INSERT INTO `t_expense_detail` VALUES ('19', '14', '10', '你懂的', '2000', '0');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(20) DEFAULT NULL,
  `pMenuId` int(11) DEFAULT NULL,
  `menuUrl` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', '0', null);
INSERT INTO `t_menu` VALUES ('2', '报销管理', '0', null);
INSERT INTO `t_menu` VALUES ('3', '财务管理', '0', null);
INSERT INTO `t_menu` VALUES ('4', '用户管理', '1', '/system/usersListQueryServlet');
INSERT INTO `t_menu` VALUES ('5', '费用管理', '1', '/system/CostListServlet');
INSERT INTO `t_menu` VALUES ('6', '个人信息', '1', 'view/system/user/userinfo_show.jsp');
INSERT INTO `t_menu` VALUES ('7', '我的薪资', '1', 'user/selectMySalaryServlet');
INSERT INTO `t_menu` VALUES ('8', '报销单', '2', '/expense/ExpenseAddServlet');
INSERT INTO `t_menu` VALUES ('9', '经理审批', '2', '/expense/ManagerAuditServlet');
INSERT INTO `t_menu` VALUES ('10', '报销查询', '2', '/expense/ExpenseSelectServlet');
INSERT INTO `t_menu` VALUES ('11', '我的报销', '2', '/expense/MyExpenseServlet');
INSERT INTO `t_menu` VALUES ('12', '财务审批', '3', '/financeAudit/GetInFinanceAuditServlet');
INSERT INTO `t_menu` VALUES ('13', '薪资发放', '3', '/salary/AddSalaryServlet');
INSERT INTO `t_menu` VALUES ('14', '薪资查询', '3', '/salary/SelectSalaryListServlet');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '普通员工');
INSERT INTO `t_role` VALUES ('2', '部门经理');
INSERT INTO `t_role` VALUES ('3', '财务人员');
INSERT INTO `t_role` VALUES ('4', '超级管理员');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`menuId`),
  KEY `FK_t_role_menu2` (`menuId`),
  CONSTRAINT `FK_t_role_menu` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`),
  CONSTRAINT `FK_t_role_menu2` FOREIGN KEY (`menuId`) REFERENCES `t_menu` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1');
INSERT INTO `t_role_menu` VALUES ('2', '1');
INSERT INTO `t_role_menu` VALUES ('3', '1');
INSERT INTO `t_role_menu` VALUES ('4', '1');
INSERT INTO `t_role_menu` VALUES ('1', '2');
INSERT INTO `t_role_menu` VALUES ('2', '2');
INSERT INTO `t_role_menu` VALUES ('3', '2');
INSERT INTO `t_role_menu` VALUES ('4', '2');
INSERT INTO `t_role_menu` VALUES ('3', '3');
INSERT INTO `t_role_menu` VALUES ('4', '3');
INSERT INTO `t_role_menu` VALUES ('4', '4');
INSERT INTO `t_role_menu` VALUES ('3', '5');
INSERT INTO `t_role_menu` VALUES ('4', '5');
INSERT INTO `t_role_menu` VALUES ('1', '6');
INSERT INTO `t_role_menu` VALUES ('2', '6');
INSERT INTO `t_role_menu` VALUES ('3', '6');
INSERT INTO `t_role_menu` VALUES ('4', '6');
INSERT INTO `t_role_menu` VALUES ('1', '7');
INSERT INTO `t_role_menu` VALUES ('2', '7');
INSERT INTO `t_role_menu` VALUES ('3', '7');
INSERT INTO `t_role_menu` VALUES ('4', '7');
INSERT INTO `t_role_menu` VALUES ('1', '8');
INSERT INTO `t_role_menu` VALUES ('2', '8');
INSERT INTO `t_role_menu` VALUES ('3', '8');
INSERT INTO `t_role_menu` VALUES ('4', '8');
INSERT INTO `t_role_menu` VALUES ('2', '9');
INSERT INTO `t_role_menu` VALUES ('4', '9');
INSERT INTO `t_role_menu` VALUES ('2', '10');
INSERT INTO `t_role_menu` VALUES ('4', '10');
INSERT INTO `t_role_menu` VALUES ('1', '11');
INSERT INTO `t_role_menu` VALUES ('2', '11');
INSERT INTO `t_role_menu` VALUES ('3', '11');
INSERT INTO `t_role_menu` VALUES ('4', '11');
INSERT INTO `t_role_menu` VALUES ('3', '12');
INSERT INTO `t_role_menu` VALUES ('4', '12');
INSERT INTO `t_role_menu` VALUES ('3', '13');
INSERT INTO `t_role_menu` VALUES ('4', '13');
INSERT INTO `t_role_menu` VALUES ('3', '14');
INSERT INTO `t_role_menu` VALUES ('4', '14');

-- ----------------------------
-- Table structure for t_salary_record
-- ----------------------------
DROP TABLE IF EXISTS `t_salary_record`;
CREATE TABLE `t_salary_record` (
  `salaryId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `salaryMonth` datetime DEFAULT NULL,
  `salaryDate` datetime DEFAULT NULL,
  `salaryBasic` float DEFAULT NULL,
  `salaryComm` float DEFAULT NULL,
  PRIMARY KEY (`salaryId`),
  KEY `FK_Relationship_3` (`usersId`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salary_record
-- ----------------------------
INSERT INTO `t_salary_record` VALUES ('3', '6', '2019-11-30 16:00:00', '2019-12-16 00:56:31', '6666', '1000');
INSERT INTO `t_salary_record` VALUES ('4', '5', '2019-10-31 16:00:00', '2019-12-16 01:05:03', '6666', '100');
INSERT INTO `t_salary_record` VALUES ('5', '4', '2019-11-30 16:00:00', '2019-12-16 01:09:24', '6000', '100');
INSERT INTO `t_salary_record` VALUES ('9', '4', '2019-09-30 16:00:00', '2019-12-16 23:54:17', '6000', '200');
INSERT INTO `t_salary_record` VALUES ('10', '4', '2019-10-31 16:00:00', '2019-12-16 23:54:29', '6000', '600');
INSERT INTO `t_salary_record` VALUES ('11', '2', '2019-11-30 16:00:00', '2019-12-16 23:54:43', '4000', '200');
INSERT INTO `t_salary_record` VALUES ('12', '2', '2019-09-30 16:00:00', '2019-12-16 23:54:54', '4000', '600');
INSERT INTO `t_salary_record` VALUES ('13', '2', '2019-11-30 16:00:00', '2019-12-16 23:55:14', '4000', '600');
INSERT INTO `t_salary_record` VALUES ('14', '5', '2019-09-30 16:00:00', '2019-12-16 23:55:24', '6666', '500');
INSERT INTO `t_salary_record` VALUES ('15', '5', '2019-10-31 16:00:00', '2019-12-16 23:55:35', '6666', '600');
INSERT INTO `t_salary_record` VALUES ('16', '6', '2019-09-30 16:00:00', '2019-12-16 23:55:51', '6666', '1000');
INSERT INTO `t_salary_record` VALUES ('17', '6', '2019-09-30 16:00:00', '2019-12-16 23:56:00', '6666', '700');
INSERT INTO `t_salary_record` VALUES ('18', '6', '2019-11-30 16:00:00', '2019-12-16 23:56:08', '6666', '800');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `usersId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `usersName` varchar(20) DEFAULT NULL,
  `usersSex` varchar(3) DEFAULT NULL,
  `usersAge` int(11) DEFAULT NULL,
  `usersPhone` varchar(11) DEFAULT NULL,
  `usersAccount` varchar(20) DEFAULT NULL,
  `usersPwd` varchar(50) DEFAULT '',
  `usersSalary` float DEFAULT NULL,
  `usersMark` varchar(5) DEFAULT '0',
  PRIMARY KEY (`usersId`),
  KEY `FK_Relationship_2` (`roleId`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', '1', 'tom', '男', '12', '322233323', 'tom', '^<m9k4acq35r1aorc6ot65kj3b0q94au5d->_', '1500', '1');
INSERT INTO `t_users` VALUES ('2', '1', 'jack', '女', '22', '13111000', 'jack', 'jack', '4000', '0');
INSERT INTO `t_users` VALUES ('3', '3', 'jerry', '女', '20', '323232222', 'jerry', 'jerry', '5000', '1');
INSERT INTO `t_users` VALUES ('4', '4', 'admin', '女', '30', '123323222', 'admin', 'admin', '6000', '0');
INSERT INTO `t_users` VALUES ('5', '4', 'asd', '女', '16', '11111111111', 'asd', 'asd', '6666', '0');
INSERT INTO `t_users` VALUES ('6', '2', '小仙女', '女', '18', '5555555', 'xxn', 'xxn', '6666', '0');
INSERT INTO `t_users` VALUES ('7', '4', 'poul', '男', '21', '1314181', 'poul', 'poul', '3500', '1');
INSERT INTO `t_users` VALUES ('8', '2', '小三', '女', '18', '5252520', '小三', 'xiaosan', '5555', '1');
INSERT INTO `t_users` VALUES ('9', '4', 'jerry', '女', '23', '56416516156', 'jerry', 'jerry', '1515', '1');
