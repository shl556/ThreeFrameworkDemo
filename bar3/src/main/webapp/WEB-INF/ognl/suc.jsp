<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>成功页面</title>
</head>
<body>
	<table>
		<tr>
			<td>编号：</td>
			<td><s:property value="userBean.userId"></s:property></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><s:property value="userBean.userName"></s:property></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><s:property value="userBean.password"></s:property></td>
		</tr>
		<tr>
			<td>生日：</td>
			<td><s:date name="userBean.birthday" format="yyyy-MM-dd hh:MM:ss" /></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<s:if test="userBean.sex==0">
					男
				</s:if>
				<s:else>
					女
				</s:else>
			</td>
		</tr>
		<tr>
			<td>城市：</td>
			<td>
				<s:property value="#request.cityBean.cityValue"/>
			</td>
		</tr>
		<tr>
			<td>爱好：</td>
			<td>
			<s:if test="#request.lstHobby!=null">
				<s:iterator value="#request.lstHobby" var="hobby" status="index" begin="0" end="#request.lstHobby.length-1">
					第[<s:property value="%{#attr.index.index+1}"/>]条爱好：<s:property value="%{#attr.hobby.hobbyValue}"/><br/>
				</s:iterator>
			</s:if>
			</td>
		</tr>
	</table>
</body>
</html>