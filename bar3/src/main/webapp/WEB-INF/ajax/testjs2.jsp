<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%
	// ��ֹ���������ҳ��
    request.setAttribute("decorator", "none");
    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
    response.setHeader("Pragma","no-cache"); // HTTP 1.0
    response.setDateHeader ("Expires", 0);
%>
${param.data}
<script type="text/javascript">
var table = document.createElement("table");
var a = document.createElement("table");
// ���ñ��ı߿�Ϊ1��
a.border=1;
var caption = a.createCaption();
a.style.backgroundColor = "#ddd";
caption.innerHTML = "���Java��ϵͼ��";
// ֱ��ȡ���ַ������飨ʵ��Ӧ�ÿɴ����ݿ���ȡ�����ݣ�
books = ['���Java����' , '������Java EE��ҵӦ��ʵս' 
	, '���Ajax����' , '���XML����' , '����Java EE��ҵӦ��ʵս'
	, '���Android����'];
//Ϊ���ѭ���������
for (var i = 0 ; i < books.length ; i++)
{
	//������
	var tr = a.insertRow(i);
	//���뵥Ԫ��
	var td = tr.insertCell(0);
	//���õ�Ԫ�������
	td.innerHTML = books[i];
}
//�����Ԫ����ӵ�HTML�ĵ���
document.body.appendChild(a);
</script>