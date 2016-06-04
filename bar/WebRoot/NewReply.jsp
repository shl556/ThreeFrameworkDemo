<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>青鸟学员论坛--发布帖子</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript" src="JS/validate.js"></script>
</HEAD>
<BODY>
<%@include file="top.jsp" %>
<c:if test="${!empty param.replyContent}">
<jsp:useBean id="newreply" class="com.shl.javabeans.tools.UpdateReply"></jsp:useBean>
<jsp:setProperty property="*" name="newreply"/>
<c:if test="${newreply.addReply!=0}">
   <c:set var="msg" scope="request">
         欢迎您发表新贴！
   </c:set>
   <jsp:forward page="ReplyTable.jsp"></jsp:forward>
</c:if>
</c:if>
<!-- 主体 -->
<div>
<!-- 导航 -->
<div class="daohang">
&lt;&lt; &nbsp;<a href="index.jsp">论坛首页</a>&nbsp;
&lt;&lt; &nbsp;<a href="PostTable.jsp?kindid=${kind.kindid}">${kind.kindName}</a><br/>
</div>
<!-- 发布帖子 -->
<div id="newreply">
<form action="NewReply.jsp?postid=${post.postid}&title=${post.title}" name="postform" onsubmit="return newreply_check()" method="post">
<input type="hidden" name="userId" value="${user.userId}"/>
<input type="hidden" name="postId" value="${post.postid}"/>
<table border="1" cellpadding="5">
<tr><td colspan="2"> &nbsp;<h3>回复主题：${post.title }</h3> </td></tr>
<tr>
<td>内容</td>
<td><textarea rows="15" cols="90" name="replyContent"></textarea><br/>(内容不能多于1000字)</td>
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

</BODY>
</HTML>
