<#list ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as x>
	${x_index + 1}. ${x}<#if x_has_next>,</#if>
	<#if x = "星期四"><#break></#if>
</#list>
