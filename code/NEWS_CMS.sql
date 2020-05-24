/*
 Navicat Premium Data Transfer

 Source Server         : DoyledeMacBook-Pro
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : NEWS_CMS

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/05/2020 17:40:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ddcms_news
-- ----------------------------
DROP TABLE IF EXISTS `ddcms_news`;
CREATE TABLE `ddcms_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻表id',
  `p_id` int(11) NOT NULL COMMENT '新闻栏目ID',
  `user_id` int(11) NOT NULL COMMENT '新闻发布用户ID',
  `title` varchar(250) NOT NULL COMMENT '标题',
  `content` varchar(250) NOT NULL COMMENT '内容',
  `read_count` int(11) NOT NULL COMMENT '阅读数量',
  `type` varchar(250) NOT NULL COMMENT '新闻状态，0正常，1审核，2删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id_index` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddcms_news_program
-- ----------------------------
DROP TABLE IF EXISTS `ddcms_news_program`;
CREATE TABLE `ddcms_news_program` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻栏目表id',
  `name` varchar(50) NOT NULL COMMENT '栏目名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddcms_user
-- ----------------------------
DROP TABLE IF EXISTS `ddcms_user`;
CREATE TABLE `ddcms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `name` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(250) NOT NULL COMMENT '密码',
  `mobile` varchar(50) NOT NULL COMMENT '手机号',
  `mail` varchar(250) NOT NULL COMMENT '邮箱',
  `type` varchar(250) NOT NULL COMMENT '用户状态，0正常',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
