
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>�ɹ�ҳ��</title>
</head>
<body>
	<%-- ��վ���ʴ���Ϊ��${applicationScope.counter}<br>
	${sessionScope.user}�����Ѿ���¼��<br>
	${requestScope.tip} --%>
	��վ���ʴ���Ϊ��${applicationScope.counter}<br>
	${sessionScope.user}�����Ѿ���¼��<br>
	${requestScope.tip} 
	<s:property value="user.username"/> 
	<s:property value="username"/>
	<%-- <s:property value="actionmessage[0]"/> --%>
	<%-- <s:actionmessage />
	<s:actionerror/> --%>
	<!--���㸲�ǻ���ɾ��cookieʱ���Ǵ�һ����������Ч����ԭ����cookie��shl�����㸲��Ϊsunʱ���õĻ���shl�������ٴη��ʻ��߸���ʱ��þ���sun -->
	��ϵͳ�ж�ȡ��Cookieֵ��${cookie.username.value}
	<s:debug></s:debug>
	<%-- <h3>request</h3>
	<table>
	<%
	Enumeration<String> attributeNames=request.getAttributeNames();
	while(attributeNames.hasMoreElements()){
		String name=attributeNames.nextElement();
	    Object obj=request.getAttribute(name);
	%>
	<tr><td>������</td><td><%=name %></td><td><%=obj %></td></tr>
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
	<tr><td>������</td><td><%=name %></td><td><%=obj %></td></tr>
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
	<tr><td>������</td><td><%=name %></td><td><%=obj %></td></tr>
	<% } %> 
	</table>  --%>
	
</body>
</html>