-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2014 年 08 月 06 日 06:28
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
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1000 ;

-- 
-- 导出表中的数据 `subtypemodule`
-- 

INSERT INTO `subtypemodule` VALUES (1, '中国文明', 'KCXL1', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (2, '人文基础与经典阅读', 'KCXL2', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (3, '全球视野', 'KCXL3', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (4, '科技、经济、社会', 'KCXL4', 7, 4, '1', '公共细类');
INSERT INTO `subtypemodule` VALUES (999, '0', '0', 0, 0, '0', '0');

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
