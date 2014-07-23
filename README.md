coursemanage
============
项目说明（待补）

---------
<pre name="code" class="html">更新记录说明(删时请慎重)：
    2014.7.10        第一次更新：测试&amp;课程类别管理(增删改查)
    2014.7.14        第二次更新：更新课程类别和培养类别的对应关系（增查改，含junit4测试）
    2014.7.14        第三次更新：补上课程类别管理junit4测试
    2014.7.15        第四次更新：待整合「cm（李坚辉），CourseManage（梁炎），course（陈雪）」
    2014.7.20        第五次更新：课程类别和课程类别的对应关系简单地实现&测试；课程库申请审批简单实现&附junit测试
    2014.7.21        第六次更新：代码整合</pre>
<br />
<br />


Structures
----------

``` bash
$ tree .
course
│  .classpath
│  .project
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
│      │  └─course
│      │      ├─action
│      │      │      CourseAction.class
│      │      │      CourseapplyAction.class
│      │      │      CourseapplyActionTest.class
│      │      │      CoursetypeAction.class
│      │      │      CoursetypeActionTest.class
│      │      │      LoginAction.class
│      │      │      PreCourseAction.class
│      │      │      PreCourseActionTest.class
│      │      │      RelationAction.class
│      │      │      RelationActionTest.class
│      │      │      SubtypeAction.class
│      │      │      SubtypeActionTest.class
│      │      │      SubtypemoduleAction.class
│      │      │      SubtypemoduleActionTest.class
│      │      │      UserAction.class
│      │      │      
│      │      ├─dao
│      │      │      CourseapplyDaoImp.class
│      │      │      CourseDaoImp.class
│      │      │      CoursetypeDaoImp.class
│      │      │      ICourseapplyDao.class
│      │      │      ICourseDao.class
│      │      │      ICoursetypeDao.class
│      │      │      IPreCourseDao.class
│      │      │      IRelationDao.class
│      │      │      ISubtypeDao.class
│      │      │      ISubtypemoduleDao.class
│      │      │      IUserDao.class
│      │      │      PreCourseDaoImp.class
│      │      │      RelationDaoImp.class
│      │      │      SubtypeDaoImp.class
│      │      │      SubtypemoduleDaoImp.class
│      │      │      UserDaoImp.class
│      │      │      
│      │      ├─entity
│      │      │      Course.class
│      │      │      Courseapply.class
│      │      │      Coursetype.class
│      │      │      PreCourse.class
│      │      │      Relation.class
│      │      │      Subtype.class
│      │      │      Subtypemodule.class
│      │      │      User.class
│      │      │      
│      │      ├─exception
│      │      │      MyException.class
│      │      │      
│      │      ├─filter
│      │      │      CharsetEncodingFilter.class
│      │      │      
│      │      ├─interceptor
│      │      │      CheckLogin.class
│      │      │      
│      │      └─service
│      │              CourseapplyManageImp.class
│      │              CourseManageImp.class
│      │              CoursetypeManageImp.class
│      │              ICourseapplyManage.class
│      │              ICourseManage.class
│      │              ICoursetypeManage.class
│      │              IPreCourseManage.class
│      │              IRelationManage.class
│      │              ISubtypeManage.class
│      │              ISubtypemoduleManage.class
│      │              IUserManage.class
│      │              PreCourseManageImp.class
│      │              RelationManageImp.class
│      │              SubtypeManageImp.class
│      │              SubtypemoduleManageImp.class
│      │              UserManageImp.class
│      │              
│      └─config
│              applicationContext-beans.xml
│              applicationContext-common.xml
│              Course.cfg.xml
│              Courseapply.cfg.xml
│              hibernate.cfg.xml
│              PreCourse.cfg.xml
│              struts-course.xml
│              struts-coursetype.xml
│              struts-precourse.xml
│              struts-relation.xml
│              struts-subtype.xml
│              struts-subtypemodule.xml
│              struts-user.xml
│              struts.xml
│              User.cfg.xml
│              
├─src
│  ├─com
│  │  └─course
│  │      ├─action
│  │      │      CourseAction.java
│  │      │      CourseapplyAction.java
│  │      │      CourseapplyActionTest.java
│  │      │      CoursetypeAction.java
│  │      │      CoursetypeActionTest.java
│  │      │      LoginAction.java
│  │      │      PreCourseAction.java
│  │      │      PreCourseActionTest.java
│  │      │      RelationAction.java
│  │      │      RelationActionTest.java
│  │      │      SubtypeAction.java
│  │      │      SubtypeActionTest.java
│  │      │      SubtypemoduleAction.java
│  │      │      SubtypemoduleActionTest.java
│  │      │      UserAction.java
│  │      │      
│  │      ├─dao
│  │      │      CourseapplyDaoImp.java
│  │      │      CourseDaoImp.java
│  │      │      CoursetypeDaoImp.java
│  │      │      ICourseapplyDao.java
│  │      │      ICourseDao.java
│  │      │      ICoursetypeDao.java
│  │      │      IPreCourseDao.java
│  │      │      IRelationDao.java
│  │      │      ISubtypeDao.java
│  │      │      ISubtypemoduleDao.java
│  │      │      IUserDao.java
│  │      │      PreCourseDaoImp.java
│  │      │      RelationDaoImp.java
│  │      │      SubtypeDaoImp.java
│  │      │      SubtypemoduleDaoImp.java
│  │      │      UserDaoImp.java
│  │      │      
│  │      ├─entity
│  │      │      Course.java
│  │      │      Courseapply.java
│  │      │      Coursetype.java
│  │      │      PreCourse.java
│  │      │      Relation.java
│  │      │      Subtype.java
│  │      │      Subtypemodule.java
│  │      │      User.java
│  │      │      
│  │      ├─exception
│  │      │      MyException.java
│  │      │      
│  │      ├─filter
│  │      │      CharsetEncodingFilter.java
│  │      │      
│  │      ├─interceptor
│  │      │      CheckLogin.java
│  │      │      
│  │      └─service
│  │              CourseapplyManageImp.java
│  │              CourseManageImp.java
│  │              CoursetypeManageImp.java
│  │              ICourseapplyManage.java
│  │              ICourseManage.java
│  │              ICoursetypeManage.java
│  │              IPreCourseManage.java
│  │              IRelationManage.java
│  │              ISubtypeManage.java
│  │              ISubtypemoduleManage.java
│  │              IUserManage.java
│  │              PreCourseManageImp.java
│  │              RelationManageImp.java
│  │              SubtypeManageImp.java
│  │              SubtypemoduleManageImp.java
│  │              UserManageImp.java
│  │              
│  └─config
│          applicationContext-beans.xml
│          applicationContext-common.xml
│          Course.cfg.xml
│          Courseapply.cfg.xml
│          hibernate.cfg.xml
│          PreCourse.cfg.xml
│          struts-course.xml
│          struts-coursetype.xml
│          struts-precourse.xml
│          struts-relation.xml
│          struts-subtype.xml
│          struts-subtypemodule.xml
│          struts-user.xml
│          struts.xml
│          User.cfg.xml
│          
└─WebContent
    │  class_apply.jsp
    │  class_check.jsp
    │  class_manage.jsp
    │  courseMan.jsp
    │  detail_model.jsp
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
                jboss-logging-3.1.0.GA.jar
                jboss-transaction-api_1.1_spec-1.0.1.Final.jar
                jta-1.1.jar
                lucene-core-3.6.2.jar
                mchange-commons-java-0.2.3.4.jar
                mysql-connector-java-5.1.13-bin.jar
                ognl-3.0.6.jar
                ojdbc14.jar
                paranamer-2.3.jar
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
                web.xml
                xwork-core-2.3.16.3.jar
.

```


Workflows（待补）
---------
###test
