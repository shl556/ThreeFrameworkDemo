<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML>
<HEAD>
<TITLE>青鸟学员论坛--注册</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script language="javascript" src="JS/validate1.js" type="text/javascript"></script>
</HEAD>
<BODY>
<%@include file="top.jsp" %>
<BR/>
<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">论坛首页</a></B>
</DIV>
<!--      用户注册表单        -->
<div  align="center">
	<form name="register_form"  action="AddUser.jsp" method="post">
		<table id="register"  cellpadding="5">
		    <tr><td colspan="2"> &nbsp;<span class="errmsg">${msg} </span></td></tr>
		    <tr>
		        <td class="input">用户名：</td>
		        <td><input type="text" name="lgname"  id="lgname" required placeholder="如张三"/></td>
		    </tr>
		    <tr>
		         <td class="input">密码：</td>
		         <td><input type="password" name="lgpass" required id="pass1"/></td>
		    </tr>
		    <tr>
		         <td class="input">确认密码：</td>
		         <td><input type="password" name="lgpass_validate" required id="pass2"/></td>
		    </tr>
		    <tr>
		          <td class="input">昵称：</td>
		          <td><input type="text" name="nickname" required placeholder="如孙大圣" id="nickname"/></td>
		    </tr>
		    <tr>
		          <td class="input">性别：</td>
		          <td><input type="radio" name="sex" value="1" checked="checked"/>男
		              <input type="radio" name="sex" value="2"/>女</td>
		    </tr>
		<tr>
		   <td class="input">请选择头像 </td>
		   <td>
		<img src="image/head/1.gif"/><input type="radio" name="headname" value="1.gif" checked="checked">
		<img src="image/head/2.gif"/><input type="radio" name="headname" value="2.gif">
		<img src="image/head/3.gif"/><input type="radio" name="headname" value="3.gif">
		<img src="image/head/4.gif"/><input type="radio" name="headname" value="4.gif">
		<img src="image/head/5.gif"/><input type="radio" name="headname" value="5.gif">
		<br/>
		<img src="image/head/6.gif"/><input type="radio" name="headname" value="6.gif">
		<img src="image/head/7.gif"/><input type="radio" name="headname" value="7.gif">
		<img src="image/head/8.gif"/><input type="radio" name="headname" value="8.gif">
		<img src="image/head/9.gif"/><input type="radio" name="headname" value="9.gif">
		<img src="image/head/10.gif"/><input type="radio" name="headname" value="10.gif">
		<br/>
		<img src="image/head/11.gif"/><input type="radio" name="headname" value="11.gif">
		<img src="image/head/12.gif"/><input type="radio" name="headname" value="12.gif">
		<img src="image/head/13.gif"/><input type="radio" name="headname" value="13.gif">
		<img src="image/head/14.gif"/><input type="radio" name="headname" value="14.gif">
		<img src="image/head/15.gif"/><input type="radio" name="headname" value="15.gif">
		<br/>
		    </td>
		</tr>
		<tr>
		    <td> &nbsp; </td>
		    <td><input type="submit" value="注 册" onclick="return register_check()"/></td>
		</tr>
		</table>
			
	</form>
</div>
<!--      声明        -->
<%@include file="bottom.jsp" %>
</BODY>
</HTML>
