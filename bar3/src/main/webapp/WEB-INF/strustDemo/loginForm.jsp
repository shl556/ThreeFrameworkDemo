
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>登录页面</title>
	<script type="text/javascript">
	function regist()
	{
		//获取该页面中的第一个表单元素
		targetForm = document.forms[0];
		//动态修改目标表单的action属性
		targetForm.action = "login!regist";
		//提交表单
		targetForm.submit();
	}
	</script>
</head>
<body>
<!-- <form action="actionContext" method="post"> -->
<!-- <form action="model" method="post"> -->
<form action="exception" method="post">
<!-- <form action="aware" method="post"> -->
<table align="center">
<caption><h3>用户登录</h3></caption>
     <!-- 对应action中的属性必须为username和password或者实现ModelDriven接口-->
    <tr>
		<td>用户名：<input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;码：<input type="text" name="password"/></td>
	</tr>
	<!-- 对应action的属性只能为user -->
	 <!-- <tr>
		<td>用户名：<input type="text" name="user.username"/></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;码：<input type="text" name="user.password"/></td>
	</tr>  -->
	<tr align="center">
		<td><input type="submit" value="登录"/>
		<input type="reset" value="重填" /></td>
	</tr>
</table>
</form>

</body>
</html>
