

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title> 使用JSON插件 </title>
	<script src="js/jquery-1.11.1.js" type="text/javascript">
	</script>
	<script type="text/javascript">
	var gotClick = function()
	{
		// 以form1表单封装的请求参数向jsonExample发送请求。
		$.post('jsonExample', $("#form1").serializeArray() 
			// data代表服务器响应，此处只是把服务器响应显示出来
			, function(data) {
				$("#show").empty();
				for(var propName in data)
				{
					$("#show").append(propName + " --> " 
						+ data[propName] + "<br />");
				}
			});
	}
	</script>
</head>
<body>
<s:form id="form1" method="post">
	<s:textfield name="field1" label="field1"/>
	<s:textfield name="field2" label="field2"/>
	<s:textfield name="field3" label="field3"/>
	<tr>
		<td colspan="2">
		<input type="button" value="提交" onClick="gotClick();"/></td>
	</tr>
</s:form>
<div id="show">
</div>
</body>
</html>