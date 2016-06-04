<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
    <jsp:useBean id="user" class="com.shl.javabeans.tools.Uservalidate"></jsp:useBean>
    <jsp:setProperty property="*" name="user"/>
     用户验证：<c:out value="${user.valid}"></c:out>
   用户名：<c:out value="${user.user.nickName}"/>
</body>
</html>