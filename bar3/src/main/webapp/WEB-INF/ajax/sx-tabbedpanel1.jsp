<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>tabbled panel示例：简单tabbled panel</title>
	<sx:head/>
</head>
<body>
<!-- 
tabbedpanel标签生成整个Tab框架，tabbedpanel标签里的子标签div则生成单独的Tab页面，每个div标签
生成一个Tab页。有以下常用属性：
closeButtom：指定Tab页面上关闭按钮的位置，可能的取值是tab和pane
selectedTab，指定加载该页面时选择哪个Tab页，默认选择第一个Tab页
doLayout:设置tabbedpanel是否显示固定高度，如果该属性设置为false，则tabbedpanel的高度会随Tab页面
的大小的改变而改变
labelposition：设置Tab页中标签的位置，可以是Top，right，bottom和left
 -->
简单Tab页面，doLayout属性设置是否使用固定高度<br>
<sx:tabbedpanel id="tab1" 
	cssStyle="width: 400px; height: 240px;"
	doLayout="false"
	labelposition="top">
	<sx:div id="left"
		label="第一个Tab页" >
		疯狂Java讲义<br />
		轻量级Java EE企业实战<br />
		疯狂Ajax讲义<br />
	</sx:div>
	<sx:div id="middle" 
		label="第二个Tab页">
	<h3>作者简介</h3>
		从事10多年的Java EE应用开发，疯狂软件教育中心总监，<br />
		疯狂Java实训营创始人，疯狂Java体系原创图书作者。<br />
		现居在广州，如果读者阅读本书有任何问题，都可以发邮件给我。<br />
	</sx:div>
</sx:tabbedpanel>
</body>
</html>