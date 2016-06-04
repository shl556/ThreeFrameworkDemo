

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 异步表单 </title>
	<sx:head/>
</head>
<body>
<!-- strust框架会自动将响应填充至target属性指定的HTML元素中 -->
<div id='show' style="border:2px solid black;
	width:360px;height:80px">原始静态文本</div>
使用表单请求的返回值来填充另一个元素。<br />
<s:form id='theForm1'
        action='ajaxTest'
        method='post'>
    <s:textfield name='data' label="请输入您喜欢的图书"/>
    <sx:submit value="修改上面的静态文本" targets="show"/>
</s:form>
使用表单请求的返回值来填充当前Form<br/>
<s:form id='theForm2'
        action='ajaxTest'
        method='post'>
    <s:textfield name='data' label="请输入您喜欢的图书"/>
    <sx:submit value="修改Form本身" targets="theForm2"/>
</s:form>
直接运行服务器端的JavaScript脚本(通过指定executeScripts="true")<br />
<s:form id='theForm3'
        action='test2'
        method='post'>
    <s:textfield name='data' label="请输入您喜欢的图书"/>
    <sx:submit value="执行远程JS" 
		executeScripts="true" targets="show"/>
</s:form>
</body>
</html>