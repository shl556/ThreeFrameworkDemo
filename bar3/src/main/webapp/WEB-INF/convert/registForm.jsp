
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>请输入您的注册信息</title>

</head>

<body>
<h1>请输入您的注册信息</h1>
<s:fielderror></s:fielderror> 
<form method="post" action="regist">
	用户名：<input type="text" name="name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="birth"><br />
	<input type="submit" value="注册">
</form> 
<!-- 利用OGNL表达式进行参数类型转换。这种方式不如model驱动模式好用 -->
<!-- <form method="post" action="regist">
	用户名：<input type="text" name="user.name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="user.pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="user.age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="user.birth"><br />
	<input type="submit" value="注册">
</form>  -->
<!-- 转换成Map集合属性 -->
<!-- <form method="post" action="regist">
	用户名：<input type="text" name="users['one'].name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="users['one'].pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="users['one'].age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="users['one'].birth"><br />
	用户名：<input type="text" name="users['two'].name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="users['two'].pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="users['two'].age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="users['two'].birth"><br />
	<input type="submit" value="注册">
</form>  -->
<!-- 转换成list集合属性 -->
<!-- <form method="post" action="regist">
	用户名：<input type="text" name="users[0].name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="users[0].pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="users[0].age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="users[0].birth"><br />
	用户名：<input type="text" name="users[1].name" /><br />
	密&nbsp;&nbsp;码：<input type="password" name="users[1].pass"><br />
	年&nbsp;&nbsp;龄：<input type="text" name="users[1].age"><br />
	生&nbsp;&nbsp;日：<input type="text" name="users[1].birth"><br />
	<input type="submit" value="注册">
</form>  -->
<!-- 非simple主题下strust标签和非strust标签会分开显示 -->
<%-- <s:form>
用户名：<s:textfield name="name">&nbsp; </s:textfield>
密码：<s:password name="pass"></s:password>
年龄：<s:textfield  name="age"></s:textfield>
生日：<s:textfield  name="birth"></s:textfield>
<input type="submit" value="提交">&nbsp;&nbsp; <input type="reset" value="重置">
</s:form> --%>
<!-- s:lable标签会使标签在输入框上面 -->
<%-- <s:form>
<s:label value="用户名"/><s:textfield name="name">&nbsp; </s:textfield>
<s:label value="密码"/><s:password name="pass"></s:password>
<s:label value="年龄"/><s:textfield  name="age"></s:textfield>
<s:label value="生日"/><s:textfield  name="birth"></s:textfield>
<input type="submit" value="提交">&nbsp;&nbsp; <input type="reset" value="重置">
</s:form>  --%>
<!-- simple主题下不支持国际化key值，不支持错误信息显示，也不支持lable标签，只能采用s:fielderror显示的显示错误消息
提示信息显示在输入框上面，无法控制通过simple消除fielderror标签的显示格式 -->
<%--  <s:form theme="simple" action="regist" method="post">
<s:fielderror fieldName="name"/>
用户名：<s:textfield name="name"/><br/>
<s:fielderror fieldName="password"/>
密&nbsp;&nbsp;&nbsp;码：<s:password name="pass"/><br/>
<s:fielderror fieldName="age"/>
年&nbsp;&nbsp;&nbsp;龄：<s:textfield  name="age"/><br/>
<s:fielderror fieldName="birth"/>
生&nbsp;&nbsp;&nbsp;日：<s:textfield  name="birth"/><br/>
<s:submit value="注册"/>&nbsp;&nbsp; <s:reset value="重置"/>
</s:form>  --%>
<%-- <!-- 控制错误提示信息显示在输入框旁边，可以方便控制样式 -->
<s:form theme="simple" action="regist" method="post">
用户名：<s:textfield name="name"/><font color=red> <s:property value="fieldErrors['name'][0]"/></font><br/>
密&nbsp;&nbsp;&nbsp;码：<s:password name="pass"/><font color=red> <s:property value="fieldErrors['password'][0]"/></font><br/>
年&nbsp;&nbsp;&nbsp;龄：<s:textfield  name="age"/><font color=red> <s:property value="fieldErrors['age'][0]"/></font><br/>
生&nbsp;&nbsp;&nbsp;日：<s:textfield  name="birth"/><font color=red> <s:property value="fieldErrors['birth'][0]"/></font><br/>
<s:submit value="注册"/>&nbsp;&nbsp; <s:reset value="重置"/>
</s:form> --%>
<s:debug></s:debug> 
</body>

</html>