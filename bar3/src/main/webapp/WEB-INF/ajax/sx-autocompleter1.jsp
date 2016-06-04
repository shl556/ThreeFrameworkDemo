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
	<title>�Զ����</title>
	<sx:head/>
</head>
<body>
<!-- 
autocompleter��ǩ���������ԣ�
autoComplete�������Ƿ��ڵ����ı�������ʾ������ʾ
forceValidOption:���õ����ı������Ƿ�ֻ���������б�����ѡ��
delay��ָ����ʾ�����б��֮ǰ���ӳ�ʱ��
href��ָ���첽�������������URI
searchType:�������������뵥���ı������ַ�����ƥ��ģʽ�����Խ���3��ֵ����
startstring(��ʾ���ı������ַ�����ͷ��ѡ�����Ĭ��ֵ)��startword����ʾ
���ı����е��ʿ�ͷ��ѡ���substring(��ʾ�����ı������ַ�����ѡ��)��
dropdownHeight:���������б��ĸ߶ȣ�Ĭ��Ϊ120
dropdownWidth:���������б��Ŀ�ȣ�Ĭ���Ǹ������ı���ĸ߶���ͬ
formId��ָ�����ĸ�����ı���ת��Ϊ���������Ϊ�첽����Ĳ���
value��ָ�������ı����Ĭ��ֵ
list��ָ�����ڵ������������б�ѡ��ļ���
loadOnTextChange�����õ��û��ڵ����ı���������ʱ���Ƿ����¼����б���
loadMinimumCount:��loadOnTextChange������Ϊtrueʱ������������������ٸ�
�ַ��󣬲Żᴥ�����¼����б���
showDownArrow:�����Ƿ���ʾ������ͷ
id�����Ǳ�����
 -->
������(/books)���Ƿ���һ���򵥵�JSON list��<br />
��ʹ���Զ����(autoComplete="false")��<br />
ʹ��indicator<br />
�ַ���ƥ��ģʽ���Ӵ�ƥ��(searchType="substring")<br />
<sx:autocompleter
	name="book1" 
	indicator="indicator1"
	href="books" 
	cssStyle="width:200px;" 
	autoComplete="false" 
	searchType="substring" id="auto1"/>
<img id="indicator1" src="image/indicator.gif"
	alt="Loading..." style="display:none"/>
<br/>
�û�����ʱ���¼��������б���(loadOnTextChange="true")<br/>
��3���ַ���Ŵ������¼��������б�(loadMinimumCout="3")<br />
������������ͷ (showDownArrow="false")<br />
<sx:autocompleter
	name="book2"
	indicator="indicator"
	href="books"
	cssStyle="width: 200px;"
	autoComplete="false"
	loadOnTextChange="true"
	loadMinimumCount="3"
	showDownArrow="false" id="auto2"/>
<img id="indicator" src="image/indicator.gif" 
	alt="Loading..." style="display:none"/><br />
�������ı�������ʾ�Զ����(autoComplete="true")��<br />
<sx:autocompleter
	name="book3"
	href="books" 
	cssStyle="width: 200px;" 
	autoComplete="true" id="auto3"/><br />
ʹ�ñ�ҳ��ļ������Զ����<br />
<sx:autocompleter 
	list="{'���Java����','������Java EE��ҵʵս','���Ajax����'}"
	cssStyle="width: 240px;" id="auto4"/><br />
У���û����룬ǿ��ֻ�����������б���(forceValidOption="true")<br />
<sx:autocompleter
	name="book4"
	href="books"
	forceValidOption="true"
	cssStyle="width: 200px;" id="auto5"/><br />
����dropdown�ĸ߶���180px  (dropdownHeight="180")<br />
<sx:autocompleter
	name="book5"
	href="books"
	dropdownHeight="180"
	cssStyle="width: 200px;" id="auto6"/><br />
����combobox���� (disabled="true")<br />
<sx:autocompleter
	name="book6"
	href="books"
	disabled="true"
	cssStyle="width: 200px;" id="auto7"/>
</body>
</html>