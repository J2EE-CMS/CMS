coursemanage
============
项目说明（待补）

---------
<pre name="code" class="html">更新记录说明(删时请慎重)：
    2014.7.10        第一次更新：测试&amp;课程类别管理(增删改查)
    2014.7.14        第二次更新：更新课程类别和培养类别的对应关系（增查改，含junit4测试）
    2014.7.14        第三次更新：补上课程类别管理junit4测试
    2014.7.15        第四次更新：待整合「cm（李坚辉），CourseManage（梁炎），course（陈雪）」</pre>
<br />
<br />


Structures
----------

``` bash
$ tree .
course
│  .classpath
│  .project
│  tree.txt
│  
├─.settings
│      .jsdtscope
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
│      │      │      CoursetypeAction.class
│      │      │      CoursetypeActionTest.class
│      │      │      LoginAction.class
│      │      │      RelationAction.class
│      │      │      RelationActionTest.class
│      │      │      
│      │      ├─dao
│      │      │      CoursetypeDaoImp.class
│      │      │      ICoursetypeDao.class
│      │      │      IRelationDao.class
│      │      │      RelationDaoImp.class
│      │      │      
│      │      ├─entity
│      │      │      Coursetype.class
│      │      │      Relation.class
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
│      │      ├─service
│      │      │      CoursetypeManageImp.class
│      │      │      ICoursetypeManage.class
│      │      │      IRelationManage.class
│      │      │      RelationManageImp.class
│      │      │      
│      │      └─util
│      │              PageModel.class    ##暂时不用
│      │              
│      └─config
│              applicationContext.xml
│              hibernate.cfg.xml    ##暂时不用
│              struts.xml
│              
├─src
│  ├─com
│  │  └─course
│  │      ├─action
│  │      │      CoursetypeAction.java
│  │      │      CoursetypeActionTest.java
│  │      │      LoginAction.java
│  │      │      RelationAction.java
│  │      │      RelationActionTest.java
│  │      │      
│  │      ├─dao
│  │      │      CoursetypeDaoImp.java
│  │      │      ICoursetypeDao.java
│  │      │      IRelationDao.java
│  │      │      RelationDaoImp.java
│  │      │      
│  │      ├─entity
│  │      │      Coursetype.java
│  │      │      Relation.java
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
│  │      ├─service
│  │      │      CoursetypeManageImp.java
│  │      │      ICoursetypeManage.java
│  │      │      IRelationManage.java
│  │      │      RelationManageImp.java
│  │      │      
│  │      └─util
│  │              PageModel.java
│  │              
│  └─config
│          applicationContext.xml
│          hibernate.cfg.xml    ##暂时不用
│          struts.xml
│          
└─WebContent
    │  fail.jsp
    │  login.jsp
    │  success.jsp
    │  testCoursetype.jsp
    │  userMain.jsp
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
                cglib-nodep-2.1_3.jar
                commons-dbcp.jar
                commons-fileupload-1.2.2.jar
                commons-io-2.0.1.jar
                commons-lang3-3.1.jar
                commons-logging-1.1.1.jar
                commons-pool.jar
                dom4j-1.6.1.jar
                freemarker-2.3.19.jar
                hibernate-commons-annotations-4.0.1.Final.jar
                hibernate-core-4.1.9.Final.jar
                hibernate-jpa-2.0-api-1.0.1.Final.jar
                jackson-core-asl-1.9.2.jar
                jackson-mapper-asl-1.9.2.jar
                javassist-3.17.1-GA.jar
                jboss-logging-3.1.0.GA.jar
                jta-1.1.jar
                lucene-core-3.6.2.jar
                mysql-connector-java-5.1.13-bin.jar
                ognl-3.0.5.jar
                ojdbc14.jar
                paranamer-2.3.jar
                servlet-api.jar
                slf4j-api-1.6.1.jar
                snappy-java-1.0.4.1.jar
                spring-aop-3.2.1.RELEASE.jar
                spring-beans-3.2.1.RELEASE.jar
                spring-context-3.2.1.RELEASE.jar
                spring-core-3.2.1.RELEASE.jar
                spring-expression-3.2.1.RELEASE.jar
                spring-jdbc-3.2.1.RELEASE.jar
                spring-orm-3.2.1.RELEASE.jar
                spring-test-3.2.1.RELEASE.jar
                spring-tx-3.2.1.RELEASE.jar
                spring-web-3.2.1.RELEASE.jar
                struts2-core-2.3.4.1.jar
                struts2-spring-plugin-2.3.4.1.jar
                web.xml
                xwork-core-2.3.4.1.jar
.

```


Workflows（待补）
---------
###test
