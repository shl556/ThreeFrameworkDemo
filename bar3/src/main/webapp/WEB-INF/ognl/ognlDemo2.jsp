<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
[0]表示截取栈中从0位置开始的子集合； 假设栈中的数据是[a,b] 则结果就是[a,b]
[1]表示截取栈中从1位置开始的子集合； 假设栈中的数据是[a,b] 则结果就是[b]
以此类推。
[1].top表示截取栈中从1位置开始的子集合 并返回顶部对象（集合中的栈顶对象），即第一个。
 -->
<s:property value="[0].top.name"/>
<s:property value="[1].top.name"/>
<s:property value="[2].top.name"/>
<!-- 打印值栈valueStack中的内容 。打印出的stack context是request、session、application等中的内容-->
<s:debug></s:debug>
</body>
</html>