

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> �첽�� </title>
	<sx:head/>
</head>
<body>
<!-- strust��ܻ��Զ�����Ӧ�����target����ָ����HTMLԪ���� -->
<div id='show' style="border:2px solid black;
	width:360px;height:80px">ԭʼ��̬�ı�</div>
ʹ�ñ�����ķ���ֵ�������һ��Ԫ�ء�<br />
<s:form id='theForm1'
        action='ajaxTest'
        method='post'>
    <s:textfield name='data' label="��������ϲ����ͼ��"/>
    <sx:submit value="�޸�����ľ�̬�ı�" targets="show"/>
</s:form>
ʹ�ñ�����ķ���ֵ����䵱ǰForm<br/>
<s:form id='theForm2'
        action='ajaxTest'
        method='post'>
    <s:textfield name='data' label="��������ϲ����ͼ��"/>
    <sx:submit value="�޸�Form����" targets="theForm2"/>
</s:form>
ֱ�����з������˵�JavaScript�ű�(ͨ��ָ��executeScripts="true")<br />
<s:form id='theForm3'
        action='test2'
        method='post'>
    <s:textfield name='data' label="��������ϲ����ͼ��"/>
    <sx:submit value="ִ��Զ��JS" 
		executeScripts="true" targets="show"/>
</s:form>
</body>
</html>