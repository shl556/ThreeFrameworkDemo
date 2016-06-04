<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript" src="JS/validate.js"></script>
</HEAD>

<BODY>
<c:if test="${!empty param.title}">
<jsp:useBean id="newpost" class="com.shl.javabeans.tools.UpdatePost"></jsp:useBean>
<jsp:setProperty property="*" name="newpost"/>
<c:if test="${newpost.updatePost!=0}">
   <c:set var="msg" scope="request">
         恭喜您修改成功！
   </c:set>
   <jsp:forward page="ReplyTable.jsp"></jsp:forward>
</c:if>
</c:if>
<jsp:useBean id="postcontent" class="com.shl.javabeans.tools.UpdatePost"></jsp:useBean>
<jsp:setProperty property="*" name="postcontent"/>
<%@include file="top.jsp" %>
<!-- 主体 -->
<div>
<!-- 导航 -->
<div class="daohang">
&lt;&lt; &nbsp;<a href="index.jsp">论坛首页</a>&nbsp;
&lt;&lt; &nbsp;<a href="PostTable.jsp?kindid=${kind.kindid}">${kind.kindName}</a><br/>
</div>
<!-- 发表帖子 -->
<div id="newpost">
<form action="UpdatePost.jsp?postid=${post.postid}" name="postform" onsubmit="return newpost_check()" method="post">
<table border="1" cellpadding="5">
<tr><td colspan="2"> &nbsp; </td></tr>
<tr>
<td>标题</td>
<td><input type="text" name="title" size="60"  value="${postcontent.postContent[0]}"/></td>
</tr>
<tr>
<td>内容</td>
<td><textarea rows="15" cols="90" name="content">${postcontent.postContent[1]}</textarea><br/>(内容不能多于1000字)</td>
</tr>
</table>
<div class="submit">
<input type="submit" value="提交"/> &nbsp;&nbsp;<input type="reset" value="重置"/>
</div>
</form>
</div>
</div>
<!--声明-->
<%@include file="bottom.jsp" %>
</BODY>
</html>