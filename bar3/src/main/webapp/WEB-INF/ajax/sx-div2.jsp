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
function handler(widget, node)
{
	//node������øú�����Ԫ�ر���
	alert('����JavaScript��������̬Div');
	node.innerHTML = Math.random() > 0.4 ?
		"���Java����" : "������Java EE��ҵӦ��ʵս";
}
</script>
<body>
ֱ��ʹ�ñ�ҳ���JS���������ٵ���Զ�̷�����<br />
<sx:div id="div1"
	cssStyle="border: 1px solid black;background-color:#dddddd;
	width:300px;height:40px;padding-top:8px;padding-left:20px"
	href="random"
	updateFreq="4000"
	handler="handler">
	��ʼ���ı�
</sx:div>
</body>
</html>