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
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
    <title>Pub-Subģ��</title>
	<sx:head/>
</head>
<script type="text/javascript">
//dojo.event.topic.publish("/refresh","foo","bar"),��ʾ��foo�����bar����ע�ᵽ/refresh�����£��������һ��������ַ���
// ����/lee���⣬ʹ��������������
dojo.event.topic.subscribe("/lee", function(data, type, request)
{
	alert('������Dojo���첽���������У������ǣ�' + type);
	alert(request);
	alert('����������ӦΪ��'+data);
});
</script>
<body>
<h3>��Pub-Subģ��</h3>
<!-- �����ð�ťʱ�������¼���/lee���� -->
<!-- 
�󲿷�ajax��ǩ����A��ǩ����listenTopics���ԣ�������ָ��һЩ�е����������������֮����Ӣ�Ķ��Ÿ��������������������µ��¼�������ʱ��A��ǩ���Զ��첽���ط���������Ӧ
����һ�����Ծ���notifyTopics��ָ��һϵ���¼�������������������Ӣ�Ķ��Ÿ��������ø����Ե�HTMLԪ�ػ�Ѽ�����Ԫ�ص��¼�����submit��ǩ�Ͱѵ���¼�������ָ���������£�
��submit��ǩ�����ʱ��ָ�������µ����ж����߼�listenTopics������ı�ǩ�ͻ��Զ����ط���������Ӧ
strust2�����ı�ǩ���ǻᷢ������������data���ӷ������˷��ص����ݣ�type����������˽�����״̬��ֻ������ֵ����before������֮ǰ����load�����������У���error����
 -->
<sx:submit type="submit" value="�ύ"
	align="left" notifyTopics="/lee"/>
<sx:div id="t1" cssStyle="background-color:#bbbbbb;width:360px;
	height:80px" listenTopics="/lee" href="book"/>
<sx:div id="t2" cssStyle="border:2px solid black;width:360px;
	height:120px" listenTopics="/lee" href="price"/>
</body>
</html>