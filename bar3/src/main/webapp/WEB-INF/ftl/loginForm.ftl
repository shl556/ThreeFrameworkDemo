<!DOCTYPE html>
<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />  
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>登陆页面</title>
</head>
<body>
<h3>请输入用户名和密码登陆</h3>
<#--
freemarker模板内置变量有如下几个，stack代表ValueStack本身，action代表刚刚执行过的Action实例
response，res，request，req，session，application，base代表用户请求的上下文路径
-->
<@s.form action="loginPro">
	<@s.textfield name="username" label="用户名"/>
	<@s.textfield name="password" label="密码"/>
	<@s.submit value="登陆"/></@s.form>
</body>
</html>
