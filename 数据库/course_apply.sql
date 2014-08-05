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
-- 表的结构 `course_apply`
-- 

CREATE TABLE `course_apply` (
  `id` int(11) NOT NULL auto_increment,
  `status` varchar(255) default NULL,
  `apply_time` datetime default NULL,
  `approval_time` datetime default NULL,
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
  `degree` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_4so00xdmkhpg8wdu06epmiat4` (`institute_course`),
  UNIQUE KEY `UK_p81hi8hq3dlff5o2fe3t8cayj` (`c_course_name`),
  KEY `FK_qh60fx3g0ng99nbxx18ew2pwr` (`course_type`),
  KEY `FK_jmvrafa9a5ngpdk6tprgc91sg` (`sub_course_type`),
  KEY `FK_nf482fyg00tvj66ylsoipr0s3` (`sub_course_type_module`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=5 ;

-- 
-- 导出表中的数据 `course_apply`
-- 

INSERT INTO `course_apply` VALUES (1, '未提交', NULL, NULL, 1001, '大学英语', 'E_Name1', 'B_Name1', 'XXXXX1', 2, 2, 4, -1, '72', 'none', 'none', 'none', '学位课');
INSERT INTO `course_apply` VALUES (2, '未提交', NULL, NULL, 1002, '工作流', 'E_Name2', 'B_Name2', 'XXXXX2', 2, 3, 6, -1, '48', 'none', 'none', 'none', '学位课');
INSERT INTO `course_apply` VALUES (3, '未提交', NULL, NULL, 1003, '社会学的想象', 'E_Name3', 'B_Name3', 'XXXXX3', 1, 4, 7, 4, '12', 'none', 'none', 'none', '学位课');
INSERT INTO `course_apply` VALUES (4, '未提交', NULL, NULL, 1004, '人与自然', 'E_Name4', 'B_Name4', 'XXXXX4', 2, 4, 8, -1, '12', 'none', 'none', 'none', '学位课');
