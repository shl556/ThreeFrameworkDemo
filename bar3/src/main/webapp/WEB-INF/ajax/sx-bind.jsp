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
	<title>ʹ��sx:bind��ǩ</title>
	<sx:head/>
	<script type="text/javascript">
	dojo.event.topic.subscribe("/after"
		, function(data, type, e)
		{
			alert('������Dojo���첽���������У������ǣ�' + type);
		});
	</script>
</head>
<body>
<!-- 
sx:bind��ǩ���ڽ����еı�ǩת��Ϊ�����첽����ı�ǩ�����ڸñ�ǩ��Ҫ�����еı�ǩת��Ϊ�����첽����ı�ǩ��ʹ��
ʱ��Ҫָ�������������ԣ�1.sourse��������ֵΪһ�����߶��Ԫ�ص�id����ֵ�����id����ֵ֮�� ��Ӣ�Ķ��Ÿ�����sx:bind
��Ѹ�����ָ���Ķ��Ԫ��ת��Ϊ�����첽�����Ԫ��2.events��������ֵΪһ�����߶���¼����ƣ�����¼�����֮����Ӣ�Ķ��Ÿ�����
ָ���������������Ժ󣬵�ҳ���sources����ָ����Ԫ�ص�events�¼�������ʱ��sx:bind��ǩ���𽫷����첽����
 -->
<div id="t1" style="background-color:#bbbbbb;
	width:360px;height:80px">ʢװ��������Ӧ��divԪ��</div>
<s:form id="form" action="ajaxTest">
	<input type="text" name="data"/>
	<s:submit id="btn1" type="submit" value="����"/>
</s:form>
��һ����ͨ��ťת��Ϊ�첽��ť������form��������ı���<br />
<sx:bind sources="btn1"
	events="onclick" 
	targets="t1"
	formId="form"
	listenTopics="/after"
	showLoadingText="false"/>
<img id="img1"
	src="image/struts-power.gif"
	alt="struts2" /><br />
��һ����ͨͼƬת��Ϊ�첽����ť<br />
<sx:bind sources="img1"
	events="onclick"
	targets="t1"
	notifyTopics="/after"
	href="ajaxTest"/><br/>
</body>
</html>
