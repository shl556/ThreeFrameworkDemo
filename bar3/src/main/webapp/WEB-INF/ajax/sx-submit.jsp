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
	<title>Զ�̰�ť</title>
	<sx:head/>
<script type="text/javascript">
dojo.event.topic.subscribe("/after"
	, function(data, type, e)
	{
		alert('������Dojo���첽���������У������ǣ�' + type);
	});
</script>
</head>
<body>
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">ʢװ��������Ӧ��divԪ��</div>
�򵥵��ύ��ť��ʹ��indicator<br />
<img id="indicator" alt="Loading..." style="display:none"
	src="${pageContext.request.contextPath}/image/indicator.gif" />
<!-- targets������������װ�ط�������Ӧ��HTMLԪ�� -->
<sx:submit type="submit"
	value="�ύ"
	targets="t1"
	href="ajaxTest"
	indicator="indicator"/><br />
�򵥵��ύ��ť��ʹ��Pub-Sub�¼�ģ��(����notifyTopics=/after����)<br />
<sx:submit type="submit" 
	value="�ύ"
	targets="t1"
	href="ajaxTest"
	notifyTopics="/after"/><br />
ͼƬ��ť(ͨ��ָ��type="image")<br />
<sx:submit type="image"
	label="����Label"
	targets="t1"
	src="images/struts-power.gif"
	href="ajaxTest.action"/><br/>
�첽��ʽ�ύ����(������������ı�����������ʾ����)
<s:form id="form" action="ajaxTest">
	<input type="text" name="data"/>
	<sx:submit type="button" 
		label="����" targets="t1" />
</s:form>
</body>
</html>