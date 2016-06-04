<#macro page title>
<!DOCTYPE html>
<html>
<head>
	<title>FreeMarker示例页面 - ${title?html}</title>
</head>
<body>
	<h1>${title?html}</h1>
	<hr />
	<!-- 用于引入用户定义指令的标签体 -->
	<#nested>
</body>
</html>
</#macro>
