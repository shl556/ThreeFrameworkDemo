<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ page errorPage="errorpage.jsp?debug=log" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<jsp:useBean id="userval" class="com.shl.javabeans.tools.Uservalidate"></jsp:useBean>
    <jsp:setProperty property="*" name="userval"/>
	<c:choose>
		<c:when test="${userval.valid}">
			<c:set var="user" value="${userval.user}" scope="session"></c:set>
			<jsp:forward page="${origalURL}"></jsp:forward>
		</c:when>
		<c:otherwise>
			<c:set var="errormsg" scope="request">
                      用户名或密码错误，请重新输入！
            </c:set>
            <jsp:forward page="login.jsp"></jsp:forward>
		</c:otherwise>
	</c:choose>
</body>
</html>