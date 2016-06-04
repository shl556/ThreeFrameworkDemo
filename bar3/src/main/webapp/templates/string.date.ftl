<#assign test1="2009-01-12"?date("yyyy-MM-dd")>
<#assign test2="16:45:22"?time("HH:mm:ss")>
<#assign test3="2009-01-12 16:45:22"?datetime("yyyy-MM-dd HH:mm:ss")>
${test1?string.full}
${test2?string.full}
${test3?string.full}  
