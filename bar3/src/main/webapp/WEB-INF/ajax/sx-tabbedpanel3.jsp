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
	<title>包含动态内容的Tab页</title>
	<sx:head/>
</head>
<body>
<sx:tabbedpanel
	id="tabbedpanel" 
	cssStyle="width:520px; height: 240px;"
	doLayout="true">
	<!-- 直接指定子div标签的href属性，让该Tab页内容整体改变 -->
	<sx:div id="panel1" 
		label="动态Tab页面一"
		href="ajaxTest"/>
	<sx:div id="panel2" 
		label="动态Tab页面二">
		<h2>您最喜欢的图书：</h2>
		<!-- 在子div标签内使用div子标签，让Tab页的部分内容改变 -->
		<sx:div id="panel21"
			href="ajaxTest"
			updateFreq="1000"/>
	</sx:div>
	<sx:div id="panel3" label="静态Tab页面">
	<h3>作者简介</h3>
		从事10多年的Java EE应用开发，疯狂软件教育中心总监，<br />
		疯狂Java实训营创始人，疯狂Java体系原创图书作者。<br />
		现居在广州，如果读者阅读本书有任何问题，都可以发邮件给我。<br />
	</sx:div>
	<!-- 包含表单的Tab页面 -->
	<sx:div id="panel4"
		label="包含远程表单的Tab页">
		<div id='show' style="border:2px dotted black;
			width:240px;height:50px">原始静态文本</div>
		<s:form action='showPerson' method='post'>
			<s:textfield name="name" label="姓名"/><br />
			<s:textfield name="age" label="年龄"/><br />
			<!-- 指定异步提交表单 -->
			<sx:submit value="提交" targets="show"/>
		</s:form>
	</sx:div>
</sx:tabbedpanel>
</body>
</html>

