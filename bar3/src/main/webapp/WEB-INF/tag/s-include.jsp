
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title> 使用s:include包含其他页面 </title>
</head>
<body>
<h2>使用s:include标签来包含目标页面</h2>
<!-- 使用include标签来包含其他页面,包含是在服务器处理的过程中发生的，不存在一个新的请求。
另外，被包含页面与包含页面都必须与系统的编码方式一致，否则会看不到被包含页面或者一堆乱码
 -->
<s:include value="included-file.jsp"/>
<!-- 使用include标签来包含其他页面，并且传入参数 -->
<s:include value="/WEB-INF/tag/included-file.jsp">
	<s:param name="author" value="'yeeku'"/>
</s:include>
</body>
</html>