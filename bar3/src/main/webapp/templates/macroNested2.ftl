<#macro repeat count>
	<#list 1..count as x>
		<#-- 使用nested指令时指定了三个循环变量 -->
		<#nested x, x/2, x==count>
	</#list>
</#macro>
<#-- 使用repeat指令时需使用三个占位符 -->
<@repeat count=4 ;c,halfc,last>
	${c}. ${halfc} <#if last> 结束!</#if>
</@repeat>
