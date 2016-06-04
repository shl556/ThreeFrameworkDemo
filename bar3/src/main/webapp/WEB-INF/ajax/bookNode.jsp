<%--
利嫋: <a href="http://www.crazyit.org">決髄Java選男</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
[
<s:iterator value="books" status="st">
	{
		"id":"<s:property value="#st.index"/>",
		"label":"<s:property/>",
		"hasChildren":true
	},
</s:iterator>
]