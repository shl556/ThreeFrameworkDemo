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
<%
	request.setAttribute("decorator", "none");
	// ��ֹ���������
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0); 
%>
<script language="JavaScript" type="text/javascript">
    alert('���Java����');
</script>
������Java EE��ҵӦ��ʵս
<script language="JavaScript" type="text/javascript">
    alert('���Ajax����');
</script>