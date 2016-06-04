
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page"
	prefix="page"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><decorator:title default="SiteMesh的装饰器页"/></title>
	<link href="decorators/main.css" rel="stylesheet" type="text/css">
	<decorator:head/>
</head>
<body>
<table width="100%" height="100%">
	<tr>
		<td valign="top">
		<!-- 引入一个页面，临时指定所用的装饰器 -->
		<page:applyDecorator page="/sitemesh/book.html" name="panel" />
		<page:applyDecorator page="/sitemesh/link.html" name="panel" />
		</td>
		<td width="100%">
			<table width="100%" height="100%">
				<tr>
					<td id="pageTitle">
						<decorator:title/>
					</td>
				</tr>
				<tr>
					<td valign="top" height="100%">
						<decorator:body />
					</td>
				</tr>
				<tr>
					<td id="footer">
						<b>被包含的内容</b><br />
						SithMesh提供页面装饰支持
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>