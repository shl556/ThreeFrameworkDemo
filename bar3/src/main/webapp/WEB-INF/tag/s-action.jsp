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
	<title> ʹ��s:action��ǩ��ҳ���ϵ���Action </title>
</head>
<body>
������õ�һ��Action�����������������ҳ���С�<br />
<s:action name="tag1" executeResult="true"/>
<hr/>
������õڶ���Action�����������������ҳ���С�<br />
����ֹ��ҳ�������������Action��<br />
<!-- excuteResult�Ƿ�Action�Ĵ����������ڱ�ҳ���ڣ�Ĭ��Ϊfalse����������ignoreContextParamsָ����ҳ����
����������Ƿ���Ҫ������õ�Action��Ĭ��Ϊfalse�����롣name���Բ�֧����action������Ӳ���,ֻ��ʹ��param��ǩ��Ӳ���
����http://localhost:8080/bar3/s-action?author=sun���в���-->
<s:action name="tag2" executeResult="true" ignoreContextParams="true">
   <%-- <s:param name="author">sun</s:param> --%>
</s:action>
��ҳ���Ƿ�ɷ��ʣ�<s:property value="author"/>
<hr/>
������õڶ���Action���Ҳ����������������ҳ���С�<br />
<s:action name="tag2" executeResult="false" ignoreContextParams="false">
   <%-- <s:param name="author">sun</s:param> --%>
</s:action>
��ҳ���Ƿ�ɷ��ʣ�<s:property value="author"/>
<s:debug></s:debug>
</body>
</html>