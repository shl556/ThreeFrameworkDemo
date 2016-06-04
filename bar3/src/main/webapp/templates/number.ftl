<#-- 设置数字值转换为字符串的格式-->
<#setting number_format="currency"/>
<#--设置变量值-->
<#assign price=42/>

${price }
<#--- 
${expr}称为通用插值，插值结果为字符串时直接输出表达式结果。插值结果为数字值时，根据默认格式（由#setting指令设置）
将表达式结果转换为文本输出
-->
${price?string}
${price?string.number}
${price?string.currency}
${price?string.percent}