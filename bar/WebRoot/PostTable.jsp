<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>青鸟学员论坛--主题列表</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<%@include file="top.jsp" %>
<jsp:useBean id="table" class="com.shl.javabeans.tools.PostTable"></jsp:useBean>
<jsp:setProperty property="*" name="table"/>
<c:set var="pageRows" value="10"></c:set>
<jsp:useBean id="kind" class="com.shl.javabeans.entity.Kind" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="kind"/>
<c:set var="origalURL" value="${pageContext.request.servletPath}?kindid=${kind.kindid}&kindname=${kind.kindName}" scope="session"></c:set>
<!--      主体        -->
<div>
   <!-- 导航,发表话题 -->
   <div class="daohang">
    &lt;&lt; &nbsp;<a href="index.jsp">论坛首页</a>&nbsp;
    &lt;&lt; &nbsp;<a href="PostTable.jsp?kindid=${kind.kindid}">${kind.kindName}</a>&nbsp;&nbsp;&nbsp;
    <c:choose>
    <c:when test="${!empty user}">
    <a href="NewPost.jsp"><input type="button" value="发表话题"/></a>
    </c:when>
    <c:otherwise>
    <a href="login.jsp"><input type="button" value="发表话题"/></a>
    </c:otherwise>
    </c:choose>
    ${msg}
   </div>
   <!-- 主题列表 -->
   <div>
			<table border="1" cellpadding="5">
				<tr>
					<th colspan="2">文章</th>
					<th>作者</th>
					<th>回复</th>
				</tr>
				<c:choose>
					<c:when test="${!empty table.postTable}">
					    <c:set var="sumrows" value="${fn:length(table.postTable) }"></c:set>
						<c:forEach items="${table.postTable }" var="post" begin="${param.start}" end="${param.start+pageRows-1}">
							<tr>
								<td><img src="image/topic.gif" />
								</td>
								<td><a href="ReplyTable.jsp?postid=${post.postid}&title=${post.title}">${post.title}</a></td>
								<td>${post.nickname }</td>
								<td>${post.replysum }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h1>该板块下主题为空，赶紧行动吧</h1>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
   <!-- 分页 -->
   <div class="fenye">
   <c:choose>
   <c:when test="${param.start>0}">
   <a href="PostTable.jsp?kindid=${param.kindid}&kindname=${param.kindname}&start=${param.start-pageRows}">上一页</a>
   </c:when>
   <c:otherwise>
      上一页
   </c:otherwise>
   </c:choose>
   &nbsp; &nbsp; &nbsp; &nbsp;
   <c:choose>
   <c:when test="${param.start+pageRows<sumrows}">
   <a href="PostTable.jsp?kindid=${param.kindid}&kindname=${param.kindname}&start=${param.start+pageRows}">下一页</a>
   </c:when>
   <c:otherwise>
     下一页
   </c:otherwise>
   </c:choose>
   </div>
</div>
<!--             声 明          -->
<BR/>
<%@include file="bottom.jsp" %>

</BODY>
</HTML>
