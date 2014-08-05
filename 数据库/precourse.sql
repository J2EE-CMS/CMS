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
-- 表的结构 `precourse`
-- 

CREATE TABLE `precourse` (
  `id` int(11) NOT NULL auto_increment,
  `course` int(11) default NULL,
  `pcos` varchar(255) default NULL,
  `op` int(11) default NULL,
  `sn` int(11) default NULL,
  `group_number` int(11) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_k0dnba4k78xjrqwes9hrec6fq` (`course`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=12 ;

-- 
-- 导出表中的数据 `precourse`
-- 

INSERT INTO `precourse` VALUES (9, 3, 'M', 0, 2, 1, 0);
INSERT INTO `precourse` VALUES (8, 3, 'N', 1, 1, 1, 0);
INSERT INTO `precourse` VALUES (7, 2, 'Z', -1, 3, 2, 0);
INSERT INTO `precourse` VALUES (6, 2, 'Y', 0, 2, 2, 0);
INSERT INTO `precourse` VALUES (5, 2, 'X', 0, 1, 1, 0);
INSERT INTO `precourse` VALUES (4, 1, 'E', -1, 4, 2, 0);
INSERT INTO `precourse` VALUES (3, 1, 'C', 0, 3, 2, 0);
INSERT INTO `precourse` VALUES (2, 1, 'B', 1, 2, 1, 0);
INSERT INTO `precourse` VALUES (1, 1, 'A', 1, 1, 1, 0);
INSERT INTO `precourse` VALUES (10, 3, 'O', 1, 3, 1, 0);
INSERT INTO `precourse` VALUES (11, 3, 'S', -1, 4, 2, 0);
