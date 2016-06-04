

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>局部类型转换器</title>

</head>


<body>
错误提示：<s:fielderror/>
<span style="font-weight:bold">${tip}</span>
<form action="convert.action" method="post">
<table align="center" width="360">
	<caption><h3>局部类型转换器</h3></caption>
	
	<tr align="center">
		<td>用户信息的用户名和密码以英文逗号隔开</td>
	</tr>
	<tr>
	<!-- <td>请输入用户信息：<input type="text" name="user"/></td>
	<td>请输入客人的信息：<input type="text" name="customer"/></td> -->
	<td>请输入用户信息：<input type="text" name="users"/></td>
	<td>请输入客人的信息：<input type="text" name="users"/></td>
	</tr>
	<tr align="center">
	<td><input type="submit" value="转换"/>
		<input type="reset" value="重填" /></td>
	</tr>
	
</table>
</form>

</body>

</html>