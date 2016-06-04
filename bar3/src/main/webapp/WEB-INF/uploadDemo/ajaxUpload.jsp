    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
    <head>  
    <title>MyWebProject</title>  
    <meta charset="utf-8" />  
    <link type="text/css" href="${pageContext.request.contextPath}/jsnew/ajaxfileupload.css" rel="stylesheet" />  
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsnew/jquery.js"></script>  
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsnew/ajaxfileupload.js"></script>  
    <script type="text/javascript">  
    function ajaxFileUpload() {  
        $.ajaxFileUpload({  
            url : "${pageContext.request.contextPath}/space/quicklogin/fileUpload.html",   //submit to UploadFileServlet  
            secureuri : false,  
            fileElementId : "file", //input file 的id  
            dataType : "text", //or json xml whatever you like~  
            success : function(data, status) {  
                $("#result").append(data);  
            },  
            error : function(data, status, e) {  
                $("#result").append(data);  
            }  
        });  
        return false;  
    }  
    </script>  
    </head>  
      
    <body>  
        <input id="file" type="file" size="45" name="file" class="input"/><br/>  
        <button class="button" id="buttonUpload" onclick="return ajaxFileUpload();">Upload</button>  
        <div id="result"></div>  
    </body>  
    </html>  
      
    </html>  