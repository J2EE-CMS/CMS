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
-- 表的结构 `course`
-- 

CREATE TABLE `course` (
  `id` int(11) NOT NULL auto_increment,
  `institute_course` int(11) default NULL,
  `c_course_name` varchar(255) default NULL,
  `e_course_name` varchar(255) default NULL,
  `brief_course_name` varchar(255) default NULL,
  `faculty` varchar(255) default NULL,
  `credit` int(11) default NULL,
  `course_type` int(11) default NULL,
  `sub_course_type` int(11) default NULL,
  `sub_course_type_module` int(11) default NULL,
  `course_time` varchar(255) default NULL,
  `course_time_info` varchar(255) default NULL,
  `course_info` varchar(255) default NULL,
  `course_head` varchar(255) default NULL,
  `approval_time` datetime default NULL,
  `degree` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `info` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_m49a4pw387b8mh99ry3nxi3qm` (`institute_course`),
  UNIQUE KEY `UK_1urkhvljbepb73a9hf15k1fkj` (`c_course_name`),
  KEY `FK_q8sk5673kx4nnro5aqgf5wf6r` (`course_type`),
  KEY `FK_jxte3nyd6g7kqou8wbyemjt4g` (`sub_course_type`),
  KEY `FK_jptjs38hoqfxhvvl3fhl8kxis` (`sub_course_type_module`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=4 ;

-- 
-- 导出表中的数据 `course`
-- 

INSERT INTO `course` VALUES (1, 1, 'C语言', 'E_Name1', 'B_Name', 'XXXX1', 1, 2, 4, -1, '72', 'none', 'none', 'none', NULL, '学位课', NULL, 'none');
INSERT INTO `course` VALUES (2, 2, '数据库', 'E_Name2', 'B_Name2', 'XXXX2', 2, 2, 4, -1, '72', 'none', 'none', 'none', NULL, '学位课', NULL, 'none');
INSERT INTO `course` VALUES (3, 3, 'Web安全', 'E_Name3', 'B_Name3', 'XXXX3', 2, 3, 5, -1, '2', 'none', 'none', 'none', NULL, '学位课', NULL, 'none');
