<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎页</title>
</head>
<body>
	<h3>Debug标签</h3>
	<s:debug></s:debug>
	<hr/>
	<h3>表单标签</h3>
	<form action="<%=root%>/doSubmit.action" method="post">
		<s:fielderror cssStyle="color:red"></s:fielderror>
		<table>
			<tr>
				<td>编号：</td>
				<td><s:textfield name="userBean.userId"/></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><s:textfield name="userBean.userName"></s:textfield></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:password name="userBean.password"></s:password></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td>
					<s:textfield name="userBean.birthday">
						<s:param name="value">
							<s:date name="userBean.birthday" format="yyyy-MM-dd hh:MM:ss" />
						</s:param>
					</s:textfield>
				</td>
			</tr>
			<tr>
			<!-- 该控件依然采用key/value的形式处理数据，即key值传到后台，value值显示给用户 -->
				<td>性别：</td>
				<td><s:radio name="userBean.sex" list="#request.lstSexBean" listKey="sexId" listValue="sexValue"></s:radio></td>
			</tr>
			<tr>
				<td>城市：</td>
				<td><s:select name="userBean.city" list="lstCityBean" listKey="cityId" listValue="cityValue" headerKey="0" headerValue="--请选择--"></s:select></td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td><s:checkboxlist name="userBean.hobby" list="lstHobbyBean" listKey="hobbyId" listValue="hobbyValue"></s:checkboxlist></td>
			</tr>
			<tr>
		        <%-- <td>最高学历</td>
		        <td><s:select  name="education" list="{'高中','大学','硕士','博士'}"
       headerKey="-1" headerValue="请选择您的学历"
       emptyOption="true"
       multiple="true" size="8"/></td>	
			</tr>
			<tr>
			    <td>请选择城市</td>
			    <td><s:doubleselect
       name="province" list="{'四川省','山东省'}" doubleName="city"
       doubleList="top == '四川省' ? {'成都市', '绵阳市'} : {'济南市', '青岛市'}" /></td>
			</tr>
			<tr>
			    <td></td>
			    <td></td>
			</tr>
			<tr>
			    <td></td>
			    <td></td>
			</tr> --%>
			<tr>
				<s:hidden></s:hidden>
				<td><s:submit value="提交"/></td>
				<td><s:reset value="重置"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>