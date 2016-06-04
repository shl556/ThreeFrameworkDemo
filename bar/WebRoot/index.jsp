<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>欢迎访问青鸟学员论坛</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
</HEAD>

<BODY>
<%@ include file="top.jsp" %>
<jsp:useBean id="table" class="com.shl.javabeans.tools.IndexTable"></jsp:useBean>
<c:set var="origalURL" value="${pageContext.request.servletPath}" scope="session"></c:set>
<!--      主体        -->
<DIV id="index">
	<table border="1" cellpadding="5" cellspacing="0">
	   <tr>
	   <th colspan="2">论坛</th><th>主题总数</th><th>最后发表</th>
	   <c:forEach items="${table.indexTable}" var="parentkind">
	      <tr><td colspan="4">${parentkind.key.kindName}</td></tr>
	      <c:forEach items="${parentkind.value}" var="childkind">
	      <tr>
	          <td> &nbsp;&nbsp; </td>
	          <td><img src="image/board.gif"/>
	          <a href="PostTable.jsp?kindid=${childkind.kindid}&kindName=${childkind.kindname}">${childkind.kindname}</a></td>
	          <td>${childkind.sum}</td>
	          <c:choose>
	          <c:when test="${!empty childkind.title}">
	          <td>
	          <a href="ReplyTable.jsp?postid=${childkind.postid}"> ${childkind.title}</a><br/>
	          ${childkind.nickname} &nbsp;&nbsp;
	          <span>[<fmt:formatDate value="${childkind.modifytime}" pattern="yyyy-MM-dd HH:mm:ss"/>]</span>
	          </td>
	          </c:when>
	          <c:otherwise>
	          <td> &nbsp;&nbsp;<br/>&nbsp;&nbsp;</td>
	          </c:otherwise>
	          </c:choose>
	      </tr>
	      </c:forEach>
	   </c:forEach>
	   </tr>
	   
	</table>
</DIV>

<%@include file="bottom.jsp" %>
</BODY>
</HTML>