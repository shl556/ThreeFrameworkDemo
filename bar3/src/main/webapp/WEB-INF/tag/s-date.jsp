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
	<title> ʹ��s:date��ʽ������ </title>
</head>
<body>
<!-- ʹ��java.util.Date����һ�����ڶ��� -->
<s:bean var="now" name="java.util.Date">
	<s:param name="date" value="1"/>
</s:bean>
nice="false"����ָ��format="dd/MM/yyyy"<br />
<!-- nice����ָ���Ƿ����ָ�������뵱ǰʱ��֮���ʱ�Ĭ��Ϊfalse�������ʱ���ָ�������ǵ�ǰ����֮ǰ����֮������졣
ָ��nice���Ժ�format������Ч-->
<!-- 
���û��ָ��nice���Ժ�format���ԣ�ϵͳ���Զ������ʻ���Դ�ļ���Ѱ��keyΪstrust.date.format����Ϣ��������Ϣ��Ϊ��ʽ���ı�
�������ʽ������
 -->
<s:date name="#now" format="dd/MM/yyyy" nice="false"/><hr />
nice="true"����ָ��format="dd/MM/yyyy"<br />
<s:date name="#now" format="dd/MM/yyyy" nice="true"/><hr />
ָ��nice="true"<br />
<s:date name="#now" nice="true"/><hr />
nice="false"����û��ָ��format����<br />
<s:date name="#now" nice="false"/><hr />
</body>
</html>