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
<jsp:useBean id="deletepost" class="com.shl.javabeans.tools.UpdatePost"></jsp:useBean>
<jsp:setProperty property="*" name="deletepost"/>
<c:if test="${deletepost.deletePost!=0 }">
<c:set var="msg" scope="request">
         恭喜您删除成功！
   </c:set>
   <jsp:forward page="PostTable.jsp?kindid=${kind.kindid}"></jsp:forward>
</c:if>
</body>
</html>