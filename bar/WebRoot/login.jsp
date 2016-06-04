<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>青鸟学员论坛--登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script type="text/javascript" src="JS/validate.js">
</script>
</HEAD>
<BODY>
<%@include file="top.jsp" %><BR/>
<!--      导航        -->
<div class="daohang">
	&gt;&gt;<B><a href="index.jsp">论坛首页</a></B>
</div>
<div id="login">
  <form action="Uservalidate.jsp" method="post" name="login_form" onsubmit="return login_check()">
     <%--<form action="Uservalidate" method="post" name="login_form" onsubmit="return login_check()">--%>
         <table>
             <tr><td colspan="2" class="errmsg"> ${errormsg}</td></tr>
             <tr>
                <td class="input">用户名：</td><td><input type="text" name="lgname" value="${lgname }"/></td>
             </tr>
             <tr>
                <td class="input">密码：</td><td><input type="password" name="lgpass" value="${lgpass}"  /></td>
             </tr>
             <tr>
             <td> &nbsp;&nbsp; </td>
             <td><input type="submit" value="登陆" />&nbsp;&nbsp;<input type="button" value="注册"/></td>
             </tr> 
         </table>
    </form>
</div>
<BR/>
<%@include file="bottom.jsp" %>
</BODY>
</HTML>
