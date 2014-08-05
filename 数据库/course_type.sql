-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2014 年 08 月 05 日 09:16
-- 服务器版本: 5.0.51
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `test`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `course_type`
-- 

CREATE TABLE `course_type` (
  `id` int(11) NOT NULL auto_increment,
  `typecore` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `quality` varchar(255) default NULL,
  `reexamine` varchar(255) default NULL,
  `retake` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_4o1r9c00k0ohe5xdvsve4ros0` (`typecore`),
  UNIQUE KEY `UK_trsaiq5ynhknyxr7t1nm87qge` (`type`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=5 ;

-- 
-- 导出表中的数据 `course_type`
-- 

INSERT INTO `course_type` VALUES (0, '0', '0', '0', '0', '0');
INSERT INTO `course_type` VALUES (1, 'KCLB1', '公必', '专业必修课', '需要重考', '需要重修');
INSERT INTO `course_type` VALUES (2, 'KCLB2', '专必', '专业必修课', '需要重考', '需要重修');
INSERT INTO `course_type` VALUES (3, 'KCLB3', '专选', '专业选修课', '不需要重考', '不需要重修');
INSERT INTO `course_type` VALUES (4, 'KCLB4', '公选', '专业选修课', '不需要重考', '不需要重修');
