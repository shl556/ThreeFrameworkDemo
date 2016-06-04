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
<title></title>
</head>
<body>
<%@include file="top.jsp" %>
<c:if test="${!empty param.replyContent}">
<jsp:useBean id="newreply" class="com.shl.javabeans.tools.UpdateReply"></jsp:useBean>
<jsp:setProperty property="*" name="newreply"/>
<c:if test="${newreply.updateReply!=0}">
   <c:set var="msg" scope="request">
         恭喜您修改成功！
   </c:set>
   <jsp:forward page="ReplyTable.jsp"></jsp:forward>
</c:if>
</c:if>
<jsp:useBean id="replycontent" class="com.shl.javabeans.tools.UpdateReply"></jsp:useBean>
<jsp:setProperty property="*" name="replycontent"/>
<!-- 主体 -->
<div>
<!-- 导航 -->
<div class="daohang">
&lt;&lt; &nbsp;<a href="index.jsp">论坛首页</a>&nbsp;
&lt;&lt; &nbsp;<a href="PostTable.jsp?kindid=${kind.kindid}">${kind.kindName}</a><br/>
</div>
<!-- 修改帖子 -->
<div id="newreply">
<form action="UpdateReply.jsp?postid=${post.postid}&title=${post.title}" name="postform" onsubmit="return newreply_check()" method="post">
<input type="hidden" name="replyId" value="${param.replyId}"/>
<table border="1" cellpadding="5">
<tr><td colspan="2"> &nbsp;<h3>回复主题：${post.title }</h3> </td></tr>
<tr>
<td>内容</td>
<td><textarea rows="15" cols="90" name="replyContent" >${replycontent.replyContent}</textarea><br/>(内容不能多于1000字)</td>
</tr>
</table>
<div class="submit">
<input type="submit" value="提交"/> &nbsp;&nbsp;<input type="reset" value="重置"/>
</div>
</form>
</div>
</div>
<!--      声明        -->
<BR/>
<%@include file="bottom.jsp" %>

</body>
</html>