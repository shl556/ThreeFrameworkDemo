<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%
	// 阻止浏览器缓存页面
    request.setAttribute("decorator", "none");
    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
    response.setHeader("Pragma","no-cache"); // HTTP 1.0
    response.setDateHeader ("Expires", 0);
%>
${param.data}
<script type="text/javascript">
var table = document.createElement("table");
var a = document.createElement("table");
// 设置表格的边框为1。
a.border=1;
var caption = a.createCaption();
a.style.backgroundColor = "#ddd";
caption.innerHTML = "疯狂Java体系图书";
// 直接取出字符串数组（实际应用可从数据库里取出数据）
books = ['疯狂Java讲义' , '轻量级Java EE企业应用实战' 
	, '疯狂Ajax讲义' , '疯狂XML讲义' , '经典Java EE企业应用实战'
	, '疯狂Android讲义'];
//为表格循环插入多行
for (var i = 0 ; i < books.length ; i++)
{
	//插入行
	var tr = a.insertRow(i);
	//插入单元格
	var td = tr.insertCell(0);
	//设置单元格的内容
	td.innerHTML = books[i];
}
//将表格元素添加到HTML文档内
document.body.appendChild(a);
</script>