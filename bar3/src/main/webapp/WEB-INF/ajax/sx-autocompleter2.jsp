<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
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
    <title>�Զ����</title>
	<sx:head/>
</head>
<body>
<h3>������sx:autocompleter��������</h3>
<form id="selectForm">
��ѡ����ϲ�������ߣ�<br />
<sx:autocompleter 
	name="author" 
	list="{'���','Rod Johnson' , 'David Flanagan'}"  
	value="���"
	notifyTopics="/books"
	forceValidOption="true"/>
</form>
��ѡ����ϲ����ͼ�飺<br />
<sx:autocompleter 
	name="book"
	href="getBooks" 
	cssStyle="width: 240px;"
	autoComplete="false"
	formId="selectForm"
	listenTopics="/books"
	forceValidOption="true"/>
</body>
</html>