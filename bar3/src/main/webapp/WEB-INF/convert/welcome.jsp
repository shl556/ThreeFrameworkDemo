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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>类型转换结果如下</title>
</head>
<body>
	<h1>您的注册信息如下</h1>
	<%-- 用户名：<s:property value="name"/><br />
	密码：<s:property value="pass"/><br />
	年龄：<s:property value="age"/><br />
	生日：<s:property value="birth"/><br /> --%>
	<!-- 测试利用OGNL表达式进行类型转换 -->
	<%-- 用户名：<s:property value="user.name"/><br />
	密码：<s:property value="user.pass"/><br />
	年龄：<s:property value="user.age"/><br />
	生日：<s:property value="user.birth"/><br /> --%>
	<!-- 转换成map -->
	<%-- 用户名：<s:property value="users['one'].name"/><br />
	密码：<s:property value="users['one'].pass"/><br />
	年龄：<s:property value="users['one'].age"/><br />
	生日：<s:property value="users['one'].birth"/><br />
	用户名：<s:property value="users['two'].name"/><br />
	密码：<s:property value="users['two'].pass"/><br />
	年龄：<s:property value="users['two'].age"/><br />
	生日：<s:property value="users['two'].birth"/><br /> --%>
	<!-- 转换成list-->
	<%-- 用户名：<s:property value="users[0].name"/><br />
	密码：<s:property value="users[0].pass"/><br />
	年龄：<s:property value="users[0].age"/><br />
	生日：<s:property value="users[0].birth"/><br />
	用户名：<s:property value="users[1].name"/><br />
	密码：<s:property value="users[1].pass"/><br />
	年龄：<s:property value="users[1].age"/><br />
	生日：<s:property value="users[1].birth"/><br /> --%>
	<s:property value="tip"/>!<br />
	<%-- 用户名为:<s:property value="user.name"/><br />
	密码为：<s:property value="user.pass"/><br />
	客人的用户名为:<s:property value="customer.name"/><br />
	客人的密码为：<s:property value="customer.pass"/><br /> --%>
	用户名为:<s:property value="users[0].name"/><br />
	密码为：<s:property value="users[0].pass"/><br />
	客人的用户名为:<s:property value="users[1].name"/><br />
	客人的密码为：<s:property value="users[1].pass"/><br />
	<s:debug></s:debug>
</body>
</html>