-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2014 年 08 月 05 日 09:17
-- 服务器版本: 5.0.51
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `test`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `subtypemodule`
-- 

CREATE TABLE `subtypemodule` (
  `id` int(11) NOT NULL auto_increment,
  `module_name` varchar(255) default NULL,
  `subtype_code` varchar(255) default NULL,
  `subtype_name` int(11) default NULL,
  `coursetype_id` int(11) default NULL,
  `version` varchar(255) default NULL,
  `public_subtype` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_pe4s5anbjmbjwsud1exq0eqb8` (`module_name`),
  UNIQUE KEY `UK_n7kvhcygnd4ku78d4bwffa5rk` (`subtype_code`),
  KEY `FK_rq2uum4p608p4h2cmp0e6o4fj` (`subtype_name`),
  KEY `FK_bucbkoqnsxepc66fnb0pffo2k` (`coursetype_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=5 ;

-- 
-- 导出表中的数据 `subtypemodule`
-- 

INSERT INTO `subtypemodule` VALUES (0, '0', '0', 0, 0, '0', '0');
INSERT INTO `subtypemodule` VALUES (1, '中国文明', 'KCXL1', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (2, '人文基础与经典阅读', 'KCXL2', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (3, '全球视野', 'KCXL3', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (4, '科技、经济、社会', 'KCXL4', 7, 4, '1', '公共细类');
