

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> 使用s:checkboxlist生成多个复选框 </title>
</head>
<body>
<s:form>
<!-- 使用简单集合来生成多个复选框 -->
<s:checkboxlist name="a" label="请选择您喜欢的图书" 
	labelposition="top" list="{'疯狂Java讲义' , 
	'轻量级Java EE企业应用实战' , '疯狂Android讲义'}" />
<!-- 使用简单Map对象来生成多个复选框
	使用Map对象的key（书名）作为复选框的value，
	使用Map对象的value（出版时间）作为复选框的标签-->
	<!-- listkey属性作为复选框的值传递给后台，listvalue作为显示到页面上的值 -->
<s:checkboxlist name="b" label="请选择您想选择出版日期" 
	labelposition="top" list="#{'疯狂Java讲义':'2008年10月',
	'轻量级Java EE企业应用实战':'2011月3月',
	'疯狂Ajax讲义':'2007年6月'}"
	listKey="key"
	listValue="value"/>
<!-- 创建一个JavaBean对象，并将其放入Stack Context中 -->
<s:bean name="com.bar3.strustDemo.tags.BookService" var="bs"/>
<!-- 使用集合里放多个JavaBean实例来生成多个复选框
	使用集合元素里name属性作为复选框的标签
	使用集合元素里author属性作为复选框的value-->
<s:checkboxlist name="c" label="请选择您喜欢的图书" 
	labelposition="top"
	list="#bs.books"
	listKey="author"
	listValue="name"/>
</s:form>
</body>
</html>