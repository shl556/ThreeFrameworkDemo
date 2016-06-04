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
	<title>Զ������</title>
	<sx:head/>
<script type="text/javascript">
	function before() {alert("before request");}
	function after() {alert("after request");}
	function handler(widget, node) 
	{
		alert('����JavaScript������');
		dojo.byId(widget.targetsArray[0]).innerHTML 
			= "���Java����";
	}
	dojo.event.topic.subscribe("/after"
		, function(data, type, e)
		{
			alert('������Dojo���첽���������У������ǣ�' + type);
		});
</script>
</head>
<body>
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">div 1</div><br />
<div id="t2" style="background-color:#bbbbbb;
	width:360px;height:80px">div 2</div><br />
ͬʱ�޸�div1��div2������<br/>
�ҽ��¼�������/after����(ָ��notifyTopics����)<br />
<sx:a id="link1"
	href="ajaxTest"
	indicator="indicator"
	targets="t1,t2"
	notifyTopics="/after" >�޸�div1��div2����</sx:a>
<img id="indicator" src="image/indicator.gif"
	alt="Loading..." style="display:none"/>
<br />
ָ�������ڷ���ʧ��ʱ�Ĵ�����ʾ(ָ��errorText����)<br />
��Ϊϵͳ��ajaxNoUrl.jspҳ�治���ڣ��϶�����<br />
<sx:a id="link2"
	href="/ajaxNoUrl"
	errorText="ϵͳ������������Ϣ����"
	targets="t1">�޸�'div 1'�����ݣ�ʹ���Զ��������ʾ</sx:a>
<br />
ָ��ϵͳ�����е���ʾ��Ϣ(ָ��loadingText����)<br />
<sx:a id="link3"
	href="ajaxTest"
	loadingText="ϵͳ���ڼ�����..."
	targets="t1">�޸�'div 1'�����ݣ�ʹ���Զ���Loading��Ϣ</sx:a>
<br/>
ִ��Զ��JavaScript����(ָ��executeScripts��true����)<br />
<sx:a id="link4"
	href="testjs"
	executeScripts="true"
	targets="t2">��ִ��Զ��JavaScript������'div 2'������</sx:a>
<br />
ͨ��ʹ�ñ���JavaScript������ʵ��Ajax����(ָ��handler����)<br/>
<sx:a id="link5"
	href="ajaxTest"
	handler="handler"
	targets="t2">ʹ�ñ���JavaScript������</sx:a>
<form id="form">
	<input type="textbox" name="data" />
</form>
�ύ������(ͨ��ָ��formId����) <br />
<sx:a id="link6"
	href="ajaxTest"
	targets="t2"
	formId="form">div 2 ����ʾ�������ı��������������</sx:a>
</body>
</html>