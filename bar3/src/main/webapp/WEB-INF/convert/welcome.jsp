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
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>����ת���������</title>
</head>
<body>
	<h1>����ע����Ϣ����</h1>
	<%-- �û�����<s:property value="name"/><br />
	���룺<s:property value="pass"/><br />
	���䣺<s:property value="age"/><br />
	���գ�<s:property value="birth"/><br /> --%>
	<!-- ��������OGNL���ʽ��������ת�� -->
	<%-- �û�����<s:property value="user.name"/><br />
	���룺<s:property value="user.pass"/><br />
	���䣺<s:property value="user.age"/><br />
	���գ�<s:property value="user.birth"/><br /> --%>
	<!-- ת����map -->
	<%-- �û�����<s:property value="users['one'].name"/><br />
	���룺<s:property value="users['one'].pass"/><br />
	���䣺<s:property value="users['one'].age"/><br />
	���գ�<s:property value="users['one'].birth"/><br />
	�û�����<s:property value="users['two'].name"/><br />
	���룺<s:property value="users['two'].pass"/><br />
	���䣺<s:property value="users['two'].age"/><br />
	���գ�<s:property value="users['two'].birth"/><br /> --%>
	<!-- ת����list-->
	<%-- �û�����<s:property value="users[0].name"/><br />
	���룺<s:property value="users[0].pass"/><br />
	���䣺<s:property value="users[0].age"/><br />
	���գ�<s:property value="users[0].birth"/><br />
	�û�����<s:property value="users[1].name"/><br />
	���룺<s:property value="users[1].pass"/><br />
	���䣺<s:property value="users[1].age"/><br />
	���գ�<s:property value="users[1].birth"/><br /> --%>
	<s:property value="tip"/>!<br />
	<%-- �û���Ϊ:<s:property value="user.name"/><br />
	����Ϊ��<s:property value="user.pass"/><br />
	���˵��û���Ϊ:<s:property value="customer.name"/><br />
	���˵�����Ϊ��<s:property value="customer.pass"/><br /> --%>
	�û���Ϊ:<s:property value="users[0].name"/><br />
	����Ϊ��<s:property value="users[0].pass"/><br />
	���˵��û���Ϊ:<s:property value="users[1].name"/><br />
	���˵�����Ϊ��<s:property value="users[1].pass"/><br />
	<s:debug></s:debug>
</body>
</html>