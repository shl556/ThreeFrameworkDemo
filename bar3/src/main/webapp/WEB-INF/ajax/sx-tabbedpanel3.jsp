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
	<title>������̬���ݵ�Tabҳ</title>
	<sx:head/>
</head>
<body>
<sx:tabbedpanel
	id="tabbedpanel" 
	cssStyle="width:520px; height: 240px;"
	doLayout="true">
	<!-- ֱ��ָ����div��ǩ��href���ԣ��ø�Tabҳ��������ı� -->
	<sx:div id="panel1" 
		label="��̬Tabҳ��һ"
		href="ajaxTest"/>
	<sx:div id="panel2" 
		label="��̬Tabҳ���">
		<h2>����ϲ����ͼ�飺</h2>
		<!-- ����div��ǩ��ʹ��div�ӱ�ǩ����Tabҳ�Ĳ������ݸı� -->
		<sx:div id="panel21"
			href="ajaxTest"
			updateFreq="1000"/>
	</sx:div>
	<sx:div id="panel3" label="��̬Tabҳ��">
	<h3>���߼��</h3>
		����10�����Java EEӦ�ÿ��������������������ܼ࣬<br />
		���JavaʵѵӪ��ʼ�ˣ����Java��ϵԭ��ͼ�����ߡ�<br />
		�־��ڹ��ݣ���������Ķ��������κ����⣬�����Է��ʼ����ҡ�<br />
	</sx:div>
	<!-- ��������Tabҳ�� -->
	<sx:div id="panel4"
		label="����Զ�̱���Tabҳ">
		<div id='show' style="border:2px dotted black;
			width:240px;height:50px">ԭʼ��̬�ı�</div>
		<s:form action='showPerson' method='post'>
			<s:textfield name="name" label="����"/><br />
			<s:textfield name="age" label="����"/><br />
			<!-- ָ���첽�ύ�� -->
			<sx:submit value="�ύ" targets="show"/>
		</s:form>
	</sx:div>
</sx:tabbedpanel>
</body>
</html>

