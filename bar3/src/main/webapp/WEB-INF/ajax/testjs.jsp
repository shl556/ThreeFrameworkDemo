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
<%
	request.setAttribute("decorator", "none");
	// 阻止浏览器缓存
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0); 
%>
<script language="JavaScript" type="text/javascript">
    alert('疯狂Java讲义');
</script>
轻量级Java EE企业应用实战
<script language="JavaScript" type="text/javascript">
    alert('疯狂Ajax讲义');
</script>