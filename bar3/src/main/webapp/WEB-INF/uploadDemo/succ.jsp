<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>�ϴ��ɹ�</title>
</head>
<body>
	�ϴ��ɹ�!<br>
	<!-- ����ϴ��ı�����ļ��������� -->
	�ļ�����:<s:property value=" + title"/><br>
	<%-- <!-- �����ϴ��ļ����ļ�������ҳ������ʾ�ϴ���ͼƬ -->
	�ļ�Ϊ��<img src='upload/<s:property value="uploadFileName"/>'/><br> --%>
	<s:iterator value="uploadFileName" var="imageFile">
	<!-- �����ϴ��ļ����ļ�������ҳ������ʾ�ϴ���ͼƬ -->
	�ļ�Ϊ��<img src='upload/${imageFile}'/><br>
	</s:iterator>
</body>
</html>
