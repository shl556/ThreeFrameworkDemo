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
<script type="text/javascript">
var controller = 
{
	refresh : function() {alert("�ֶ�ˢ��");},
	start : function() {alert("�����Զ�ˢ��");},
	stop : function() {alert("ֹͣ�Զ�ˢ��");}
};
// ��controller��refresh����ע���/refresh����ķ�����
dojo.event.topic.registerPublisher("/refresh"
	, controller, "refresh");
// ��controller��start����ע���/startTimer����ķ�����
dojo.event.topic.registerPublisher("/startTimer"
	, controller, "start");
// ��controller��stop����ע���/stopTimer����ķ�����
dojo.event.topic.registerPublisher("/stopTimer"
	, controller, "stop");
// Ϊafter����ָ��һ���¼�������
dojo.event.topic.subscribe("/after"
	, function(data, type, e)
	{
		alert('�����������������. ���ڵĹ��������ǣ�' + type+'�����ǣ�'+data);
	});
</script>
<body>
<form id="testForm">
	<s:textfield name="data" label="�����û�����"/>
</form>
<input type="button" value="�ֶ�ˢ��" 
	onclick="controller.refresh();" />
<input type="button" value="ֹͣ��ʱ��"
	onclick="controller.stop();" />
<input type="button" value="������ʱ��" 
	onclick="controller.start();" />
<br>
ʹ��Pub-Sub����(ͨ��ָ��listenTopics������)<br />
���ͱ��������(ͨ��ָ��formId="form")<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	loadingText="���ڼ��ط���������..."
	listenTopics="/refresh"
	startTimerListenTopics="/startTimer"
	stopTimerListenTopics="/stopTimer"
	updateFreq="9000"
	autoStart="true"
	formId="testForm"
	notifyTopics="/after">
	��ʼ���ı�
</sx:div>
</body>
</html>