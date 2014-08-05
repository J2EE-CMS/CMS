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
-- 表的结构 `sub_type`
-- 

CREATE TABLE `sub_type` (
  `id` int(11) NOT NULL auto_increment,
  `subtypecode` varchar(255) default NULL,
  `subtypename` varchar(255) default NULL,
  `belongtotype` int(11) default NULL,
  `ispublicsubtype` varchar(255) default NULL,
  `department` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_a9veniud5riu6owlepx1t2gbh` (`subtypecode`),
  UNIQUE KEY `UK_ewip40jhb528nvytleiiyt3kv` (`subtypename`),
  KEY `FK_g8drbbrtysra02xknwcj1sssp` (`belongtotype`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=9 ;

-- 
-- 导出表中的数据 `sub_type`
-- 

INSERT INTO `sub_type` VALUES (0, '0', '0', 0, '0', '0');
INSERT INTO `sub_type` VALUES (1, 'KCLBXL1', 'A类课程', 1, '非公共细类', 'XXX1');
INSERT INTO `sub_type` VALUES (2, 'KCLBXL2', 'B类课程', 1, '非公共细类', 'XXX2');
INSERT INTO `sub_type` VALUES (3, 'KCLBXL3', '专业基础课', 2, '公共细类', 'XXX3');
INSERT INTO `sub_type` VALUES (4, 'KCLEXL4', '专业核心课', 2, '公共细类', 'XXX4');
INSERT INTO `sub_type` VALUES (5, 'KCLEXL5', '专业限选课', 3, '公共细类', 'XXX5');
INSERT INTO `sub_type` VALUES (6, 'KCLEXL6', '专业任选课', 3, '公共细类', 'XXX6');
INSERT INTO `sub_type` VALUES (7, 'KCLEXL7', '核心通识课', 4, '公共细类', 'XXX7');
INSERT INTO `sub_type` VALUES (8, 'KCLEXL8', '一般通识课', 4, '公共细类', 'XXX8');
