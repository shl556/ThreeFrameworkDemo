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
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>使用sx:tree和sx:treenode标签生成静态树</title>
	<sx:head/>
</head>
<body>
<h3>使用sx:tree和sx:treenode标签生成静态树</h3>
<!-- 
expandIconSrcMinus:指定表示树节点处于展开状态的图标地址
expandIconSrcPlus：指定表示树节点处于收缩状态的图标地址。
为了实现动态加载树节点，必须为sx:tree标签指定href属性，该属性负责为指定节点加载子节点，每当浏览器试图展开某个
节点时系统会想href指定的url发送异步请求，该请求包含一个请求参数，nodeId，该参数的值就是该节点的Id属性值。
 -->
<!-- 使用sx:tree生成树 -->
<sx:tree label="计算机图书" 
	id="book"
	showRootGrid="true" 
	showGrid="true" >
	<!-- 每个sx:treenode生成一个树节点 -->
	<sx:treenode label="李刚" id="yeeku">
		<!-- 使用sx:treenode生成下一级的子节点 -->
		<sx:treenode label="疯狂Java讲义" id="java"/>
		<sx:treenode label="轻量级Java EE企业应用实战" id="jee"/>
		<sx:treenode label="疯狂Ajax讲义" id="ajax"/>
	</sx:treenode>
	<sx:treenode label="David" id="David">
		<sx:treenode label="JavaScript: The Definitive Guide"
			id="javascript"/>
	</sx:treenode>
	<sx:treenode label="Johnson" id="Johnson">
		<sx:treenode id="j2ee"
			label="Expert One-on-One J2EE Design and Development"/>
	</sx:treenode>
</sx:tree>
</body>
</html>