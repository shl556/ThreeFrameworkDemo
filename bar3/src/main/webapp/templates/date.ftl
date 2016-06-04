<!--指定日期显示格式 -->
<#assign lastUpdated="2009-01-07 15:05"?datetime("yyyy-MM-dd HH:mm")>
${lastUpdated?string("yyyy-MM-dd HH:mm:ss zzzz")}<br />
${lastUpdated?string("EEE, MMM d, yy")}<br />
${lastUpdated?string("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'")} <br />
${lastUpdated?string.short}<br />
${lastUpdated?string.long}<br />
${lastUpdated?string.full}<br />
