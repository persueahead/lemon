/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.101
Source Server Version : 50622
Source Host           : 192.168.0.101:3306
Source Database       : testMysql

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-08-09 23:24:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `DEPT`
-- ----------------------------
DROP TABLE IF EXISTS `DEPT`;
CREATE TABLE `DEPT` (
  `deptno` int(11) NOT NULL DEFAULT '0',
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of DEPT
-- ----------------------------
INSERT INTO `DEPT` VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO `DEPT` VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO `DEPT` VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO `DEPT` VALUES ('40', 'OPERATIONS', 'BOSTON');

-- ----------------------------
-- Table structure for `EMP`
-- ----------------------------
DROP TABLE IF EXISTS `EMP`;
CREATE TABLE `EMP` (
  `empno` int(11) NOT NULL DEFAULT '0',
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` int(11) DEFAULT NULL,
  `comm` int(11) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `FK_DEPTNO` (`deptno`),
  CONSTRAINT `FK_DEPTNO` FOREIGN KEY (`deptno`) REFERENCES `DEPT` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of EMP
-- ----------------------------
INSERT INTO `EMP` VALUES ('7369', 'SMITH', 'CLERK', '7902', '1980-12-17', '800', null, '20');
INSERT INTO `EMP` VALUES ('7499', 'ALLEN', 'SALESMAN', '7698', '1981-02-20', '1600', '300', '30');
INSERT INTO `EMP` VALUES ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250', '500', '30');
INSERT INTO `EMP` VALUES ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2975', null, '20');
INSERT INTO `EMP` VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250', '1400', '30');
INSERT INTO `EMP` VALUES ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850', null, '30');
INSERT INTO `EMP` VALUES ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450', null, '10');
INSERT INTO `EMP` VALUES ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000', null, '20');
INSERT INTO `EMP` VALUES ('7839', 'KING', 'PRESIDENT', null, '1981-11-17', '5000', null, '10');
INSERT INTO `EMP` VALUES ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500', '0', '30');
INSERT INTO `EMP` VALUES ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100', null, '20');
INSERT INTO `EMP` VALUES ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '950', null, '30');
INSERT INTO `EMP` VALUES ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000', null, '20');
INSERT INTO `EMP` VALUES ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '1300', null, '10');

-- ----------------------------
-- Table structure for `SALGRADE`
-- ----------------------------
DROP TABLE IF EXISTS `SALGRADE`;
CREATE TABLE `SALGRADE` (
  `grade` int(11) NOT NULL DEFAULT '0',
  `losal` int(11) DEFAULT NULL,
  `hisal` int(11) DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SALGRADE
-- ----------------------------
INSERT INTO `SALGRADE` VALUES ('1', '700', '1200');
INSERT INTO `SALGRADE` VALUES ('2', '1201', '1400');
INSERT INTO `SALGRADE` VALUES ('3', '1401', '2000');
INSERT INTO `SALGRADE` VALUES ('4', '2001', '3000');
INSERT INTO `SALGRADE` VALUES ('5', '3001', '9999');
