<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<DIV>
	<IMG src="image/logo.gif">
</DIV>
<!-- 用户为未登陆时提示登陆，登陆后根据用户性别，昵称给出欢迎登陆提示；允许用户注册，注销 -->

<DIV class="top">
	<c:choose>
		<c:when test="${empty user}">
	            您尚未 <a href="login.jsp">登录</a>&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
        ${user.nickName} 
               <c:choose>
				<c:when test="${user.sex==1}">
                           先生，您好！
                </c:when>
				<c:otherwise>
                             女士，您好！
                </c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<a href="Logout.jsp">注销</a> &nbsp;| &nbsp; <A href="register.jsp">注册</A> |
</DIV>