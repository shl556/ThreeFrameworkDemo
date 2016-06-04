
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>异常处理页面</title>
</head>
<body>
    异常对象本身:<s:property value="exception"/>
    <s:debug></s:debug>
	异常信息：<s:property value="exceptionStack"/>
</body>
</html>
