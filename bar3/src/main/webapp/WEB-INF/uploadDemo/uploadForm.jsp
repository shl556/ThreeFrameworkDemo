
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title> 简单的文件上传 </title>
</head>
<body>
<s:fielderror></s:fielderror>
<form action="uploadPro" method="post"
	enctype="multipart/form-data">
  	文件标题：<input type="text" name="title" /><br />
  	<!-- 选择文件：<input type="file" name="upload" /><br /> -->
  	选择第一个文件：<input type="file" name="upload" /><br />
  	选择第二个文件：<input type="file" name="upload" /><br />
  	选择第三个文件：<input type="file" name="upload" /><br />
	<input value="上传" type="submit" />
</form>
<ul>
<li>下载图片测试：
	<a href="download?inputPath=/image/logo.gif
	&contentType=image/gif&downFileName=testImage中国.gif">下载图形文件</a></li>
<li>下载WEB-INFO目录下的压缩文件：
	<a href="download?inputPath=/WEB-INF/ognl/U2图书商城.rar
	&contentType=application/rar&downFileName=testRar中国.rar">下载压缩文件</a></li>
</ul>
</body>
</html>
