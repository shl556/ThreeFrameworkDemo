

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>�ֲ�����ת����</title>

</head>


<body>
������ʾ��<s:fielderror/>
<span style="font-weight:bold">${tip}</span>
<form action="convert.action" method="post">
<table align="center" width="360">
	<caption><h3>�ֲ�����ת����</h3></caption>
	
	<tr align="center">
		<td>�û���Ϣ���û�����������Ӣ�Ķ��Ÿ���</td>
	</tr>
	<tr>
	<!-- <td>�������û���Ϣ��<input type="text" name="user"/></td>
	<td>��������˵���Ϣ��<input type="text" name="customer"/></td> -->
	<td>�������û���Ϣ��<input type="text" name="users"/></td>
	<td>��������˵���Ϣ��<input type="text" name="users"/></td>
	</tr>
	<tr align="center">
	<td><input type="submit" value="ת��"/>
		<input type="reset" value="����" /></td>
	</tr>
	
</table>
</form>

</body>

</html>