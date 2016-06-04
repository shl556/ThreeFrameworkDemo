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
	<title>tabbled panel示例：带关闭按钮的tabbled panel</title>
	<sx:head/>
</head>
<body>
设置关闭按钮(通过设置closeButton="pane")<br>
设置标签位于Tab页的下面(通过设置labelposition="bottom")<br>
<sx:tabbedpanel
	id="tab1"
	cssStyle="width: 400px; height: 240px;"
	doLayout="true"
	closeButton="pane" 
	labelposition="bottom">
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