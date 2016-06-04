<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page errorPage="errorpage.jsp?debug=log" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<jsp:useBean id="register" class="com.shl.javabeans.tools.UserRegister"></jsp:useBean>
   <jsp:setProperty property="*" name="register"/>
   <c:catch var="error">
   <c:if test="${register.userRegister!=0}">
       <c:set var="errormsg" scope="request">恭喜您注册成功！</c:set>
       <jsp:forward page="login.jsp"></jsp:forward>
   </c:if>
   </c:catch>
   <c:if test="${!empty error }">
        <c:set var="msg" scope="request">该用户名已被注册，请重新命名！</c:set>
       <jsp:forward page="register.jsp"></jsp:forward>
   </c:if>
</body>
</html>