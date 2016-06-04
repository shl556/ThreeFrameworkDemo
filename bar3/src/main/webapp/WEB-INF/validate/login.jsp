<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <s:head theme="xhtml"/>
    <s:head parseContent="true"/>
  </head>
  
  <body>
  ==================使用内置校验器 中的字段校验器========================
  <s:fielderror/>
   <s:form action="innerValidateAction" method="post">
   	<s:textfield name="name" label="用户名"/>
   	<s:textfield name="age" label="年龄"/>
   	<s:textfield name="min1" label="min1"/>
   	<s:textfield name="max1" label="max1"/>
   	<s:textfield name="min2" label="min2"/>
   	<s:textfield name="max2" label="max2"/>
   	<s:textfield name="sal" label="工资"/>
   	<s:textfield name="email" label="邮箱"/>
   	<s:textfield name="url" label="个人主页"/>
   	<s:textfield name="mycode" label="邮编"></s:textfield>
   	<s:textfield name="myname" label="昵称"></s:textfield>
   	<s:submit value="提交"/>
   </s:form>
  </body>
</html>
