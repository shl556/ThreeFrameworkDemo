<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>成功页面</title>
</head>
<body>
	<%-- 欢迎，${user}，您已经登录。 --%>
	本站访问次数为：${applicationScope.counter}<br>
	${sessionScope.user}，您已经登录！<br>
	${requestScope.tip}
</body>
</html>
