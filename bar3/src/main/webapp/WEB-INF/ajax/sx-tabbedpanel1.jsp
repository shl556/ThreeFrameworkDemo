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
	<title>tabbled panelʾ������tabbled panel</title>
	<sx:head/>
</head>
<body>
<!-- 
tabbedpanel��ǩ��������Tab��ܣ�tabbedpanel��ǩ����ӱ�ǩdiv�����ɵ�����Tabҳ�棬ÿ��div��ǩ
����һ��Tabҳ�������³������ԣ�
closeButtom��ָ��Tabҳ���Ϲرհ�ť��λ�ã����ܵ�ȡֵ��tab��pane
selectedTab��ָ�����ظ�ҳ��ʱѡ���ĸ�Tabҳ��Ĭ��ѡ���һ��Tabҳ
doLayout:����tabbedpanel�Ƿ���ʾ�̶��߶ȣ��������������Ϊfalse����tabbedpanel�ĸ߶Ȼ���Tabҳ��
�Ĵ�С�ĸı���ı�
labelposition������Tabҳ�б�ǩ��λ�ã�������Top��right��bottom��left
 -->
��Tabҳ�棬doLayout���������Ƿ�ʹ�ù̶��߶�<br>
<sx:tabbedpanel id="tab1" 
	cssStyle="width: 400px; height: 240px;"
	doLayout="false"
	labelposition="top">
	<sx:div id="left"
		label="��һ��Tabҳ" >
		���Java����<br />
		������Java EE��ҵʵս<br />
		���Ajax����<br />
	</sx:div>
	<sx:div id="middle" 
		label="�ڶ���Tabҳ">
	<h3>���߼��</h3>
		����10�����Java EEӦ�ÿ��������������������ܼ࣬<br />
		���JavaʵѵӪ��ʼ�ˣ����Java��ϵԭ��ͼ�����ߡ�<br />
		�־��ڹ��ݣ���������Ķ��������κ����⣬�����Է��ʼ����ҡ�<br />
	</sx:div>
</sx:tabbedpanel>
</body>
</html>