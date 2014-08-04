coursemanage

	团队项目界面：https://github.com/J2EE-CMS/CMS（待定）
		Owners(admin)		:SnowMastercx
		commit(read&write)	:SnowMastercx、lyleslie、kason--、michael---、EaconTang
		Ta(read)			:allenhoum	
============
项目说明（待补）

---------
<pre name="code" class="html">更新记录说明(删时请慎重)：
    2014.7.10        第一次更新：测试&amp;课程类别管理(增删改查)
    2014.7.14        第二次更新：更新课程类别和培养类别的对应关系（增查改，含junit4测试）
    2014.7.14        第三次更新：补上课程类别管理junit4测试
    2014.7.15        第四次更新：待整合「cm（李坚辉），CourseManage（梁炎），course（陈雪）」
    2014.7.20        第五次更新：课程类别和课程类别的对应关系简单地实现&测试；课程库申请审批简单实现&附junit测试
    2014.7.21        第六次更新：代码整合
    2014.7.23        第七次更新：优化文件目录结构（见分支cx），测试无问题后进行修改
	2014.7.24		 第八次更新：整合完善功能，目前完成部分包括：
									1、「课程类别、课程类别细类、课程类别细类模块、课程类别与培养类别的对应关系、课程库管理、课程的申请」部分增删改查，集成测试已通过。
									2、课程库审批和先修课程申请和审批部分的代码实现
	2014.7.25		 第九次更新：UI修改 &  新增课程库申请部分修复无法“提交”的问题
	2014.7.25					 更新课程库审批模块
	2014.7.28		 第十次更新：先修课程：增加返回所有先修课程方法  &  以字符串输出
								 增加导出功能(暂定)
	2014.7.31		 第11次更新：1、增加针对用户权限的拦截器 
										Ps:默认用户数据库为空，需要自行添加。
										Pss:用户权限分为root/admin/public/college
								 2、数据库表的修正 & 关联
	2014.8.01		 第12次更新：修复课程库的管理、申请&审批无法修改；修复先修关系处理时查询所有结果的处理。
	2014.8.04		 第13次更新：修复课程细类无法删除的问题，增加一个lise用于存储先修课程设定返回值</pre>
<br />
<br />


Structures
----------

``` bash
$ tree .
course.
│  .classpath
│  .project
│  
│  
├─.settings
│      .jsdtscope
│      org.eclipse.core.resources.prefs
│      org.eclipse.jdt.core.prefs
│      org.eclipse.wst.common.component
│      org.eclipse.wst.common.project.facet.core.xml
│      org.eclipse.wst.jsdt.ui.superType.container
│      org.eclipse.wst.jsdt.ui.superType.name
│      
├─build
│  └─classes
│      ├─com
│      │  ├─course
│      │  │  ├─action
│      │  │  │      CourseAction.class
│      │  │  │      CourseapplyAction.class
│      │  │  │      CoursetypeAction.class
│      │  │  │      LoginAction.class
│      │  │  │      PreCourseAction.class
│      │  │  │      RelationAction.class
│      │  │  │      SubtypeAction.class
│      │  │  │      SubtypemoduleAction.class
│      │  │  │      UserAction.class
│      │  │  │      
│      │  │  ├─dao
│      │  │  │  │  ICourseapplyDao.class
│      │  │  │  │  ICourseDao.class
│      │  │  │  │  ICoursetypeDao.class
│      │  │  │  │  IPreCourseDao.class
│      │  │  │  │  IRelationDao.class
│      │  │  │  │  ISubtypeDao.class
│      │  │  │  │  ISubtypemoduleDao.class
│      │  │  │  │  IUserDao.class
│      │  │  │  │  
│      │  │  │  └─impl
│      │  │  │          CourseapplyDaoImp.class
│      │  │  │          CourseDaoImp.class
│      │  │  │          CoursetypeDaoImp.class
│      │  │  │          PreCourseDaoImp.class
│      │  │  │          RelationDaoImp.class
│      │  │  │          SubtypeDaoImp.class
│      │  │  │          SubtypemoduleDaoImp.class
│      │  │  │          UserDaoImp.class
│      │  │  │          
│      │  │  ├─entity
│      │  │  │      Course.class
│      │  │  │      Course.hbm.xml
│      │  │  │      Courseapply.class
│      │  │  │      Courseapply.hbm.xml
│      │  │  │      Coursetype.class
│      │  │  │      Coursetype.hbm.xml
│      │  │  │      PreCourse.class
│      │  │  │      PreCourse.hbm.xml
│      │  │  │      Relation.class
│      │  │  │      Relation.hbm.xml
│      │  │  │      Subtype.class
│      │  │  │      Subtype.hbm.xml
│      │  │  │      Subtypemodule.class
│      │  │  │      Subtypemodule.hbm.xml
│      │  │  │      User.class
│      │  │  │      User.hbm.xml
│      │  │  │      
│      │  │  ├─exception
│      │  │  │      MyException.class
│      │  │  │      
│      │  │  ├─filter
│      │  │  │      CharsetEncodingFilter.class
│      │  │  │      
│      │  │  ├─interceptor
│      │  │  │      CheckAdmin.class
│      │  │  │      CheckAdminCollege.class
│      │  │  │      CheckAdminCollegePublic.class
│      │  │  │      CheckAdminPublic.class
│      │  │  │      CheckCollege.class
│      │  │  │      CheckCollegePublic.class
│      │  │  │      CheckLogin.class
│      │  │  │      CheckPublic.class
│      │  │  │      CheckRoot.class
│      │  │  │      
│      │  │  ├─service
│      │  │  │  │  ICourseapplyManage.class
│      │  │  │  │  ICourseManage.class
│      │  │  │  │  ICoursetypeManage.class
│      │  │  │  │  IPreCourseManage.class
│      │  │  │  │  IRelationManage.class
│      │  │  │  │  ISubtypeManage.class
│      │  │  │  │  ISubtypemoduleManage.class
│      │  │  │  │  IUserManage.class
│      │  │  │  │  
│      │  │  │  └─impl
│      │  │  │          CourseapplyManageImp.class
│      │  │  │          CourseManageImp.class
│      │  │  │          CoursetypeManageImp.class
│      │  │  │          PreCourseManageImp.class
│      │  │  │          RelationManageImp.class
│      │  │  │          SubtypeManageImp.class
│      │  │  │          SubtypemoduleManageImp.class
│      │  │  │          UserManageImp.class
│      │  │  │          
│      │  │  └─util
│      │  │          ExportExcelUtil.class
│      │  │          
│      │  └─test
│      │          CourseapplyActionTest.class
│      │          CoursetypeActionTest.class
│      │          PreCourseActionTest.class
│      │          RelationActionTest.class
│      │          SubtypeActionTest.class
│      │          SubtypemoduleActionTest.class
│      │          
│      └─config
│              applicationContext-beans.xml
│              applicationContext-common.xml
│              struts-course.xml
│              struts-coursetype.xml
│              struts-precourse.xml
│              struts-relation.xml
│              struts-subtype.xml
│              struts-subtypemodule.xml
│              struts-user.xml
│              struts.xml
│              
├─src
│  ├─com
│  │  ├─course
│  │  │  ├─action
│  │  │  │      CourseAction.java
│  │  │  │      CourseapplyAction.java
│  │  │  │      CoursetypeAction.java
│  │  │  │      LoginAction.java
│  │  │  │      PreCourseAction.java
│  │  │  │      RelationAction.java
│  │  │  │      SubtypeAction.java
│  │  │  │      SubtypemoduleAction.java
│  │  │  │      UserAction.java
│  │  │  │      
│  │  │  ├─dao
│  │  │  │  │  ICourseapplyDao.java
│  │  │  │  │  ICourseDao.java
│  │  │  │  │  ICoursetypeDao.java
│  │  │  │  │  IPreCourseDao.java
│  │  │  │  │  IRelationDao.java
│  │  │  │  │  ISubtypeDao.java
│  │  │  │  │  ISubtypemoduleDao.java
│  │  │  │  │  IUserDao.java
│  │  │  │  │  
│  │  │  │  └─impl
│  │  │  │          CourseapplyDaoImp.java
│  │  │  │          CourseDaoImp.java
│  │  │  │          CoursetypeDaoImp.java
│  │  │  │          PreCourseDaoImp.java
│  │  │  │          RelationDaoImp.java
│  │  │  │          SubtypeDaoImp.java
│  │  │  │          SubtypemoduleDaoImp.java
│  │  │  │          UserDaoImp.java
│  │  │  │          
│  │  │  ├─entity
│  │  │  │      Course.hbm.xml
│  │  │  │      Course.java
│  │  │  │      Courseapply.hbm.xml
│  │  │  │      Courseapply.java
│  │  │  │      Coursetype.hbm.xml
│  │  │  │      Coursetype.java
│  │  │  │      PreCourse.hbm.xml
│  │  │  │      PreCourse.java
│  │  │  │      Relation.hbm.xml
│  │  │  │      Relation.java
│  │  │  │      Subtype.hbm.xml
│  │  │  │      Subtype.java
│  │  │  │      Subtypemodule.hbm.xml
│  │  │  │      Subtypemodule.java
│  │  │  │      User.hbm.xml
│  │  │  │      User.java
│  │  │  │      
│  │  │  ├─exception
│  │  │  │      MyException.java
│  │  │  │      
│  │  │  ├─filter
│  │  │  │      CharsetEncodingFilter.java
│  │  │  │      
│  │  │  ├─interceptor
│  │  │  │      CheckAdmin.java
│  │  │  │      CheckAdminCollege.java
│  │  │  │      CheckAdminCollegePublic.java
│  │  │  │      CheckAdminPublic.java
│  │  │  │      CheckCollege.java
│  │  │  │      CheckCollegePublic.java
│  │  │  │      CheckLogin.java
│  │  │  │      CheckPublic.java
│  │  │  │      CheckRoot.java
│  │  │  │      
│  │  │  ├─service
│  │  │  │  │  ICourseapplyManage.java
│  │  │  │  │  ICourseManage.java
│  │  │  │  │  ICoursetypeManage.java
│  │  │  │  │  IPreCourseManage.java
│  │  │  │  │  IRelationManage.java
│  │  │  │  │  ISubtypeManage.java
│  │  │  │  │  ISubtypemoduleManage.java
│  │  │  │  │  IUserManage.java
│  │  │  │  │  
│  │  │  │  └─impl
│  │  │  │          CourseapplyManageImp.java
│  │  │  │          CourseManageImp.java
│  │  │  │          CoursetypeManageImp.java
│  │  │  │          PreCourseManageImp.java
│  │  │  │          RelationManageImp.java
│  │  │  │          SubtypeManageImp.java
│  │  │  │          SubtypemoduleManageImp.java
│  │  │  │          UserManageImp.java
│  │  │  │          
│  │  │  └─util
│  │  │          ExportExcelUtil.java
│  │  │          
│  │  └─test
│  │          CourseapplyActionTest.java
│  │          CoursetypeActionTest.java
│  │          PreCourseActionTest.java
│  │          RelationActionTest.java
│  │          SubtypeActionTest.java
│  │          SubtypemoduleActionTest.java
│  │          
│  └─config
│          applicationContext-beans.xml
│          applicationContext-common.xml
│          struts-course.xml
│          struts-coursetype.xml
│          struts-precourse.xml
│          struts-relation.xml
│          struts-subtype.xml
│          struts-subtypemodule.xml
│          struts-user.xml
│          struts.xml
│          
└─WebContent
    │  class_apply.jsp
    │  class_check.jsp
    │  class_manage.jsp
    │  courseMan.jsp
    │  detail_model.jsp
    │  detail_module.jsp
    │  detail_type.jsp
    │  fail.jsp
    │  home.jsp
    │  index.jsp
    │  login.jsp
    │  relation_apply.jsp
    │  relation_check.jsp
    │  success.jsp
    │  training_class.jsp
    │  type_manage.jsp
    │  user_manage.jsp
    │  
    ├─css
    │      bootstrap.min.css
    │      
    ├─js
    │      bootstrap.min.js
    │      jquery-2.1.1.min.js
    │      jquery.min.js
    │      
    ├─META-INF
    │      MANIFEST.MF
    │      
    └─WEB-INF
        │  web.xml
        │  
        └─lib
                antlr-2.7.7.jar
                aopalliance-1.0.jar
                aspectjrt.jar
                aspectjweaver.jar
                avro-1.6.3.jar
                c3p0-0.9.2.1.jar
                cglib-nodep-2.1_3.jar
                commons-codec-1.5.jar
                commons-dbcp.jar
                commons-fileupload-1.3.1.jar
                commons-io-2.2.jar
                commons-lang3-3.1.jar
                commons-logging-1.1.3.jar
                commons-pool.jar
                dom4j-1.6.1.jar
                freemarker-2.3.19.jar
                hibernate-c3p0-4.2.14.Final.jar
                hibernate-commons-annotations-4.0.2.Final.jar
                hibernate-core-4.2.14.Final.jar
                hibernate-entitymanager-4.2.14.Final.jar
                hibernate-envers-4.2.14.Final.jar
                hibernate-jpa-2.0-api-1.0.1.Final.jar
                jackson-core-asl-1.9.2.jar
                jackson-mapper-asl-1.9.2.jar
                javassist-3.18.1-GA.jar
                jaxr-api.jar
                jboss-logging-3.1.0.GA.jar
                jboss-transaction-api_1.1_spec-1.0.1.Final.jar
                jta-1.1.jar
                junit-4.11.jar
                log4j-1.2.13.jar
                lucene-core-3.6.2.jar
                mchange-commons-java-0.2.3.4.jar
                mysql-connector-java-5.1.13-bin.jar
                ognl-3.0.6.jar
                ojdbc14.jar
                paranamer-2.3.jar
                poi-3.10-FINAL-20140208.jar
                poi-excelant-3.10-FINAL-20140208.jar
                poi-ooxml-3.10-FINAL-20140208.jar
                poi-ooxml-schemas-3.10-FINAL-20140208.jar
                poi-scratchpad-3.10-FINAL-20140208.jar
                servlet-api.jar
                slf4j-api-1.6.1.jar
                snappy-java-1.0.4.1.jar
                spring-aop-3.2.9.RELEASE.jar
                spring-aspects-3.2.9.RELEASE.jar
                spring-beans-3.2.9.RELEASE.jar
                spring-build-src-3.2.9.RELEASE.jar
                spring-context-3.2.9.RELEASE.jar
                spring-context-support-3.2.9.RELEASE.jar
                spring-core-3.2.9.RELEASE.jar
                spring-expression-3.2.9.RELEASE.jar
                spring-framework-bom-3.2.9.RELEASE.jar
                spring-instrument-3.2.9.RELEASE.jar
                spring-instrument-tomcat-3.2.9.RELEASE.jar
                spring-jdbc-3.2.9.RELEASE.jar
                spring-jms-3.2.9.RELEASE.jar
                spring-orm-3.2.9.RELEASE.jar
                spring-oxm-3.2.9.RELEASE.jar
                spring-struts-3.2.9.RELEASE.jar
                spring-test-3.2.9.RELEASE.jar
                spring-tx-3.2.9.RELEASE.jar
                spring-web-3.2.9.RELEASE.jar
                spring-webmvc-3.2.9.RELEASE.jar
                spring-webmvc-portlet-3.2.9.RELEASE.jar
                struts2-core-2.3.16.3.jar
                struts2-json-plugin-2.3.16.3.jar
                struts2-spring-plugin-2.3.16.3.jar
                xwork-core-2.3.16.3.jar
.

```


Workflows（待补）
---------
###test
