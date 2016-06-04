<#macro book>
	<#-- 使用book指令时指定了一个循环变量值 -->
	<#nested 1>
	<#nested 2>
</#macro>
<@book;x>${x} .图书</@book >
