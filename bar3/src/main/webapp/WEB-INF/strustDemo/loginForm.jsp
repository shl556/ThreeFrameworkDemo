
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>��¼ҳ��</title>
	<script type="text/javascript">
	function regist()
	{
		//��ȡ��ҳ���еĵ�һ����Ԫ��
		targetForm = document.forms[0];
		//��̬�޸�Ŀ�����action����
		targetForm.action = "login!regist";
		//�ύ��
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
<caption><h3>�û���¼</h3></caption>
     <!-- ��Ӧaction�е����Ա���Ϊusername��password����ʵ��ModelDriven�ӿ�-->
    <tr>
		<td>�û�����<input type="text" name="username"/></td>
	</tr>
	<tr>
		<td>��&nbsp;&nbsp;�룺<input type="text" name="password"/></td>
	</tr>
	<!-- ��Ӧaction������ֻ��Ϊuser -->
	 <!-- <tr>
		<td>�û�����<input type="text" name="user.username"/></td>
	</tr>
	<tr>
		<td>��&nbsp;&nbsp;�룺<input type="text" name="user.password"/></td>
	</tr>  -->
	<tr align="center">
		<td><input type="submit" value="��¼"/>
		<input type="reset" value="����" /></td>
	</tr>
</table>
</form>

</body>
</html>
