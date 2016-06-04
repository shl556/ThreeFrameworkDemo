<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>疯狂Java体系图书</title>
</head>
<body>
<table border="1" width="360">
	<caption>疯狂Java体系图书</caption>
	<#-- 使用list指令迭代输出books属性 -->
	<#list books as book>
	<tr <#if (book_index % 2 == 1)>
		style="background-color:#cccccc"</#if>>
		<td>书名：</td>
		<td>${book}</td>
	</tr>
	</#list>
</table>
</body>
</html>
