<#-- 定义一个自定义指令,booklist是参数 -->
<#macro book booklist>
	<#list booklist as book>
		${book}
	</#list>
</#macro>
<#-- 使用自定义指令 -->
<@book booklist=["疯狂Java讲义","轻量级Java EE企业应用实战","疯狂Ajax讲义"]/>
