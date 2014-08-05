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
-- 表的结构 `type_relation`
-- 

CREATE TABLE `type_relation` (
  `id` int(11) NOT NULL auto_increment,
  `grade` int(11) default NULL,
  `devtype` varchar(255) default NULL,
  `coursetype_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_pvw2cp2xes4a3d8r8lkvexrqd` (`coursetype_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=3 ;

-- 
-- 导出表中的数据 `type_relation`
-- 

INSERT INTO `type_relation` VALUES (1, 2011, '单学位', 1);
INSERT INTO `type_relation` VALUES (2, 2012, '双学位', 2);
