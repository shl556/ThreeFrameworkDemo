<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><s:property value="getText('loginPage')"/></title>
<style type="text/css">
.errorMessage{
color: red;
font-size: 16px;
}
.error{
height: 30px;
width: 100px; 
}
</style>
</head>
<body>
<s:a href="login?request_locale=zh_CN"> <s:text name="cn"></s:text></s:a>
<s:a href="login?request_locale=en_US"> <s:text name="en"></s:text></s:a><br/>
<s:text name="loginPage"></s:text><br/>
<!-- 参数化国际化 -->
<s:bean name="java.util.Date" var="time"></s:bean>
<s:text name="hello">
<s:param>shl</s:param>
<s:param>${time}</s:param>
</s:text>
<%-- <s:property value="getText('hello',new String[]{'shl','2016/2/21'})"/> --%>
<!-- 使用form标签生成表单元素 -->
<!-- simple主题下的strust没有css模板样式同时不支持国际化的key属性 -->
<s:form action="login" theme="simple">
    <s:fielderror></s:fielderror>
	用户名：<s:textfield name="username"  key="user"/>  <font color=red> <s:property value="fieldErrors['username'][0]"/></font><br/> 
	密码：<s:textfield name="password" key="pass"/>  <font color=red> <s:property value="fieldErrors['password'][0]"/></font>
	<!-- 生成一个提交按钮 -->
	<s:submit key="login"/>
</s:form> 
<!-- 可以根据实际合成的HTML标签的class属性或者id属性应用相关的CSS样式。错误消息提示的class都是errorMessage -->
<%-- <s:form action="login">
    <s:fielderror></s:fielderror>
    <!-- cssClass,cssStyle和cssErrorClass,cssErrorStyle最后应用的都是针对input标签 。errorPosition指定错误的显示位置-->
	<s:textfield name="username"  key="user" cssStyle="height: 30px;width: 100px;" errorPosition="bottom" class="sun" tooltip="sun"/>  
    <s:textfield name="password" key="pass"/> 
	<!-- 生成一个提交按钮 -->
	<s:submit key="login"/>
</s:form> --%>
<s:debug></s:debug>
</body>
</html>

