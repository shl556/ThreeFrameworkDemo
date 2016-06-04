<#-- 定义一个Map对象-->
<#assign score={"语文":78, "数学":83,"Java":89}>
<#-- 输出map对象 -->
<#list score?keys as x>
${x} ---> ${score[x]}
</#list>
