<#--mX表示小数部分最少X位，MX表示小数部分最多X为-->
<#assign x=2.582/>
<#assign y=4/>
#{x; M2}   <#-- 输出2.58 -->
#{y; M2}   <#--输出4 -->
#{x; m1}   <#-- 输出2.6 -->
#{y; m1}   <#-- 输出4.0 -->
#{x; m1M2} <#-- 输出2.58 -->
#{y; m1M2} <#-- 输出4.0 -->