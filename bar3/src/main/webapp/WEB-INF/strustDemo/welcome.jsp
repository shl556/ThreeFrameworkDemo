
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>成功页面</title>
</head>
<body>
	<%-- 本站访问次数为：${applicationScope.counter}<br>
	${sessionScope.user}，您已经登录！<br>
	${requestScope.tip} --%>
	本站访问次数为：${applicationScope.counter}<br>
	${sessionScope.user}，您已经登录！<br>
	${requestScope.tip} 
	<s:property value="user.username"/> 
	<s:property value="username"/>
	<%-- <s:property value="actionmessage[0]"/> --%>
	<%-- <s:actionmessage />
	<s:actionerror/> --%>
	<!--当你覆盖或者删除cookie时都是从一次请求再生效，即原来的cookie是shl，当你覆盖为sun时你获得的还是shl，当你再次访问或者覆盖时获得就是sun -->
	从系统中读取的Cookie值：${cookie.username.value}
	<s:debug></s:debug>
	<%-- <h3>request</h3>
	<table>
	<%
	Enumeration<String> attributeNames=request.getAttributeNames();
	while(attributeNames.hasMoreElements()){
		String name=attributeNames.nextElement();
	    Object obj=request.getAttribute(name);
	%>
	<tr><td>属性名</td><td><%=name %></td><td><%=obj %></td></tr>
	<% } %> 
	</table>
	<h3>session</h3>
	<table>
	<%
	Enumeration<String> attributeNames2=session.getAttributeNames();
	while(attributeNames2.hasMoreElements()){
		String name=attributeNames2.nextElement();
	    Object obj=session.getAttribute(name);
	%>
	<tr><td>属性名</td><td><%=name %></td><td><%=obj %></td></tr>
	<% } %> 
	</table>
	 <h3>application</h3>
	<table>
	<%
	Enumeration<String> attributeNames3=application.getAttributeNames();
	while(attributeNames3.hasMoreElements()){
		String name=attributeNames3.nextElement();
	    Object obj=application.getAttribute(name);
	%>
	<tr><td>属性名</td><td><%=name %></td><td><%=obj %></td></tr>
	<% } %> 
	</table>  --%>
	
</body>
</html>