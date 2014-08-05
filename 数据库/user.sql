-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2014 年 08 月 05 日 14:19
-- 服务器版本: 5.0.51
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `test`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `user`
-- 

CREATE TABLE `user` (
  `id_key` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  PRIMARY KEY  (`id_key`),
  UNIQUE KEY `UK_gj2fy3dcix7ph7k8684gka40c` (`name`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

-- 
-- 导出表中的数据 `user`
-- 

INSERT INTO `user` VALUES (1, 'super', '123', 'super');
INSERT INTO `user` VALUES (2, 'admin', '123', 'admin');
INSERT INTO `user` VALUES (3, 'college', '123', 'college');
