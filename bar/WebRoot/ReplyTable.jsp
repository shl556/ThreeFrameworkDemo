<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>青鸟学员论坛--回复列表</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<%@include file="top.jsp" %>
<jsp:useBean id="replytable" class="com.shl.javabeans.tools.ReplyTable"></jsp:useBean>
<jsp:setProperty property="*" name="replytable"/>
<jsp:useBean id="post" class="com.shl.javabeans.entity.Post" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="post"/>
<c:set var="origalURL" value="${pageContext.request.servletPath}?postid=${post.postid}&title=${post.title}" scope="session"></c:set>
<c:set var="rownum" value="2"></c:set>
<c:set var="rowsum" value="${fn:length(replytable.tableRows) }"></c:set>
<!--      主体        -->
<div>
<!-- 导航 -->
<div class="daohang">
    &lt;&lt; &nbsp;<a href="index.jsp">论坛首页</a>&nbsp;
    &lt;&lt; &nbsp;<a href="PostTable.jsp?kindid=${kind.kindid}">${kind.kindName}</a>&nbsp;&nbsp;&nbsp; 
    <c:choose>
    <c:when test="${!empty user}">
    <a href="NewReply.jsp"><input type="button" value="回复帖子"/></a>
    <a href="NewPost.jsp?userid=${user.userId}"><input type="button" value="发表话题"/></a>
    </c:when>
    <c:otherwise>
    <a href="login.jsp"><input type="button" value="回复帖子"/></a> &nbsp;&nbsp;
    <a href="login.jsp"><input type="button" value="发表话题"/></a>
    </c:otherwise>
    </c:choose>
    &nbsp;&nbsp;${msg}
</div>
<!-- 回复列表 -->
<div>
<table border="1" cellpadding="5">
<tr><td><h3>本页主题：${param.title }</h3></td></tr>
<tr><td> &nbsp; </td></tr>
</table>
<c:forEach items="${replytable.tableRows}" var="table" begin="${param.startrow}" end="${param.startrow+rownum-1}">
<table border="1" cellpadding="5">
<tr>
<td rowspan="2" width="200px">
${table.nickname}<br/>
<img alt="头像" src="image/head/${table.headname}"/><br/>
<span>注册：<fmt:formatDate value="${table.registerTime}" pattern="yyyy-MM-dd"/> </span>
</td>
<td><h3>${param.title }</h3><br/> ${table.content }</td>
</tr>
<tr><td>
<span>发表：<fmt:formatDate value="${table.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;
最后修改：<fmt:formatDate value="${table.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>&nbsp;&nbsp;
<c:if test="${table.userid==user.userId&&table.replyid!=param.postid}">
<a href="UpdateReply.jsp?replyId=${table.replyid}">修改</a> &nbsp;&nbsp;
<a href="DeleteReply.jsp?replyId=${table.replyid }">删除</a>
</c:if>
<c:if test="${table.userid==user.userId&&table.replyid==param.postid}">
<a href="UpdatePost.jsp?postid=${post.postid}">修改</a> &nbsp;&nbsp;
<a href="DeletePost.jsp?postid=${post.postid }">删除</a>
</c:if>
</td></tr>
</table>
</c:forEach>
</div>
<!-- 分页 -->
<div class="fenye">
<c:choose>
<c:when test="${param.startrow > 0}">
<a href="ReplyTable.jsp?postid=${post.postid}&title=${post.title}&startrow=${param.startrow-rownum}">上一页</a>
</c:when>
<c:otherwise>
上一页
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${param.startrow+rownum<rowsum}">
<a href="ReplyTable.jsp?postid=${post.postid}&title=${post.title}&startrow=${param.startrow+rownum}">下一页</a>
</c:when>
<c:otherwise>
下一页
</c:otherwise>
</c:choose>
</div>
</div>
<!--      声明        -->
<BR>
<%@include file="bottom.jsp" %>
</BODY>
</HTML>
