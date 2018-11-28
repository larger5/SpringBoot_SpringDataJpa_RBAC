/*
Navicat MySQL Data Transfer

Source Server         : aliyunDocker
Source Server Version : 50721
Source Host           : 120.79.197.130:3307
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-28 09:57:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(20) DEFAULT NULL,
  `permission_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '用户管理：查询所有', '/admin/sysUser/all');
INSERT INTO `sys_permission` VALUES ('2', '角色管理：查询所有', '/admin/sysRole/all');
INSERT INTO `sys_permission` VALUES ('3', '权限管理：查询所有', '/admin/sysPermission/all');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'student');
INSERT INTO `sys_role` VALUES ('2', 'teacher');
INSERT INTO `sys_role` VALUES ('3', 'admin');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_permission_id` int(11) DEFAULT NULL,
  `sys_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmnbc71b4040rgprkv4aeu0h5p` (`sys_permission_id`),
  KEY `FK31whauev046d3rg8ecubxa664` (`sys_role_id`),
  CONSTRAINT `FK31whauev046d3rg8ecubxa664` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKmnbc71b4040rgprkv4aeu0h5p` FOREIGN KEY (`sys_permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'root', '123');
INSERT INTO `sys_user` VALUES ('2', 'cun', '123');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` int(11) DEFAULT NULL,
  `sys_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ef5794xnbirtsnudta6p32on` (`sys_role_id`),
  KEY `FKsbjvgfdwwy5rfbiag1bwh9x2b` (`sys_user_id`),
  CONSTRAINT `FK1ef5794xnbirtsnudta6p32on` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKsbjvgfdwwy5rfbiag1bwh9x2b` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
