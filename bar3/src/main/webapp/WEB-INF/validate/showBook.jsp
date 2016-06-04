
<%@page import="com.opensymphony.xwork2.util.ValueStack,java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!-- 导入Struts 2的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>作者李刚的图书</title>
</head>
<body>
<table border="1" style="width:360px">
	<caption>作者李刚的图书</caption>
	<%-- <%
	// 获取封装输出信息的ValueStack对象
	ValueStack vs = (ValueStack)request
		.getAttribute("struts.valueStack");
	// 调用ValueStack的fineValue方法获取books属性值
	String[] books = (String[])vs.findValue("books");
	// 迭代输出全部图书信息
	for (String book : books)
	{	
	%>
	<tr>
		<td>书名：</td>
		<td><%=book%></td>
	</tr>
	<%}%> --%>
	<%--测试request中存放的所有属性值 --%>
	<%-- <%
	Enumeration<String> attributeNames=request.getAttributeNames();
	while(attributeNames.hasMoreElements()){
		String name=attributeNames.nextElement();
	    Object obj=request.getAttribute(name);
	%>
	<tr><td>属性名</td><td><%=name %></td><td><%=obj %></td></tr>
	<% } %> --%>
	<%--测试结果为：
	<tr><td>属性名</td><td>javax.servlet.forward.request_uri</td><td>/bar3/getBooks</td></tr>
	<tr><td>属性名</td><td>javax.servlet.forward.context_path</td><td>/bar3</td></tr>
	<tr><td>属性名</td><td>javax.servlet.forward.servlet_path</td><td>/getBooks</td></tr>
	<tr><td>属性名</td><td>struts.request_uri</td><td>/bar3/getBooks</td></tr>
	<tr><td>属性名</td><td>struts.view_uri</td><td>/WEB-INF/content/showBook.jsp</td></tr>
	<tr><td>属性名</td><td>__cleanup_recursion_counter</td><td>1</td></tr>
	<tr><td>属性名</td><td>struts.actionMapping</td><td>ActionMapping{name='getBooks', namespace='/', method='null', extension='null', params=null, result=null}</td></tr>
	<tr><td>属性名</td><td>struts.valueStack</td><td>com.opensymphony.xwork2.ognl.OgnlValueStack@42f0627a</td></tr>
	 --%>
	<!-- 迭代输出ValueStack中的books对象，其中status是迭代的序号 -->
	<s:iterator value="books" status="index" >
	<!-- 判断序号是否为奇数 -->
	<s:if test="#index.odd == true"> 
	<tr style="background-color:#cccccc">
	<td>书名：</td>
		<td><s:property/></td>
	</tr>
	</s:if>
	<!-- 判断迭代元素的序号是否不为偶数 -->
	<s:else> 
	<tr>
	<td>书名：</td>
	<td><s:property/></td>
	</tr>
	</s:else>
   	</s:iterator>
</table>
</body>
</html>
