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
    <title>Զ��div</title>
    <sx:head/>
</head>
<body>
��һ�λ�ȡ���������ݵ�div<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random">
	��ʼ���ı�
</sx:div>
��̬�������ݵ�div��ÿ��1sˢ��һ��(ͨ��ָ��updateFreq="1000")<br />
ʹ��indicator(ͨ��ָ��indicator="indicator")<br />
<!-- updateFreqָ������div���ݵ�ʱ��������λ��ms�������ָ����������ֻ��ҳ�����ʱ���¸�div����
delayָ�����θ���div���ݵ�ʱ���ӳ٣���λ��ms�������ָ����������ָ����updateFreq���ԣ���ҳ����غ�����
��ʼ��ʱ׼��ˢ��div���ݡ����û��ָ��updateFreq���ԣ���������Ч
 -->
<sx:div id="div2"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="1000"
	indicator="indicator">
	��ʼ���ı�
</sx:div>
<img id="indicator" alt="Loading..." style="display:none"
	src="${pageContext.request.contextPath}/image/indicator.gif"/><br />
3s֮��ſ�ʼ����(ͨ��ָ��delay="3000")<br />
ָ��������������������ʾ(ͨ��ָ��errorText����)<br />
ָ������������������е���ʾ(ͨ��ָ��loadText����)<br />
<sx:div id="div3"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="1000"
	delay="3000"
	errorText="���ط��������ݳ���"
	loadingText="���ڼ��ط���������">
	��ʼ���ı�
</sx:div>
ָ����ʾϵͳ������ʾ(ͨ��ָ��showErrorTransportText="true")<br />
<sx:div id="div4"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="ajaxNoUrl"
	updateFreq="1000"
	errorText="���ط��������ݳ���"
	showErrorTransportText="true"
	loadingText="���ڼ��ط���������">
	��ʼ���ı�
</sx:div>
ִ�з������ű�(ͨ��ָ��executeScripts="true")
<sx:div id="div5"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="testjs"
	updateFreq="9000"
	executeScripts="true"
	loadingText="���ڼ��ط���������">
	��ʼ���ı�
</sx:div>
</body>
</html>