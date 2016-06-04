<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
	<title>自动完成</title>
	<sx:head/>
</head>
<body>
<!-- 
autocompleter标签有以下属性：
autoComplete：设置是否在单行文本框中显示输入提示
forceValidOption:设置单行文本框内是否只接受下拉列表框里的选项
delay：指定显示下拉列表框之前的延迟时间
href：指定异步生成下拉表项的URI
searchType:设置下拉表项与单行文本框中字符串的匹配模式，可以接受3个值，即
startstring(显示以文本框中字符串开头的选项，这是默认值)，startword（显示
以文本框中单词开头的选项）和substring(显示包含文本框中字符串的选项)。
dropdownHeight:设置下拉列表框的高度，默认为120
dropdownWidth:设置下拉列表框的宽度，默认是跟单行文本框的高度相同
formId：指定将哪个表单里的表单域转换为请求参数作为异步请求的参数
value：指定单行文本框的默认值
list：指定用于迭代生成下拉列表选项的集合
loadOnTextChange：设置当用户在单行文本框中输入时，是否重新加载列表项
loadMinimumCount:当loadOnTextChange属性设为true时，该属性设置输入多少个
字符后，才会触发重新加载列表项
showDownArrow:设置是否显示下拉箭头
id属性是必填项
 -->
服务器(/books)总是返回一个简单的JSON list。<br />
不使用自动完成(autoComplete="false")。<br />
使用indicator<br />
字符串匹配模式是子串匹配(searchType="substring")<br />
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
用户输入时重新加载下拉列表项(loadOnTextChange="true")<br/>
当3个字符后才触发重新加载下拉列表(loadMinimumCout="3")<br />
不出现下拉箭头 (showDownArrow="false")<br />
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
设置在文本框中提示自动完成(autoComplete="true")。<br />
<sx:autocompleter
	name="book3"
	href="books" 
	cssStyle="width: 200px;" 
	autoComplete="true" id="auto3"/><br />
使用本页面的集合来自动完成<br />
<sx:autocompleter 
	list="{'疯狂Java讲义','轻量级Java EE企业实战','疯狂Ajax讲义'}"
	cssStyle="width: 240px;" id="auto4"/><br />
校验用户输入，强制只能输入下拉列表项(forceValidOption="true")<br />
<sx:autocompleter
	name="book4"
	href="books"
	forceValidOption="true"
	cssStyle="width: 200px;" id="auto5"/><br />
设置dropdown的高度是180px  (dropdownHeight="180")<br />
<sx:autocompleter
	name="book5"
	href="books"
	dropdownHeight="180"
	cssStyle="width: 200px;" id="auto6"/><br />
禁用combobox功能 (disabled="true")<br />
<sx:autocompleter
	name="book6"
	href="books"
	disabled="true"
	cssStyle="width: 200px;" id="auto7"/>
</body>
</html>