

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> ʹ��s:checkboxlist���ɶ����ѡ�� </title>
</head>
<body>
<s:form>
<!-- ʹ�ü򵥼��������ɶ����ѡ�� -->
<s:checkboxlist name="a" label="��ѡ����ϲ����ͼ��" 
	labelposition="top" list="{'���Java����' , 
	'������Java EE��ҵӦ��ʵս' , '���Android����'}" />
<!-- ʹ�ü�Map���������ɶ����ѡ��
	ʹ��Map�����key����������Ϊ��ѡ���value��
	ʹ��Map�����value������ʱ�䣩��Ϊ��ѡ��ı�ǩ-->
	<!-- listkey������Ϊ��ѡ���ֵ���ݸ���̨��listvalue��Ϊ��ʾ��ҳ���ϵ�ֵ -->
<s:checkboxlist name="b" label="��ѡ������ѡ���������" 
	labelposition="top" list="#{'���Java����':'2008��10��',
	'������Java EE��ҵӦ��ʵս':'2011��3��',
	'���Ajax����':'2007��6��'}"
	listKey="key"
	listValue="value"/>
<!-- ����һ��JavaBean���󣬲��������Stack Context�� -->
<s:bean name="com.bar3.strustDemo.tags.BookService" var="bs"/>
<!-- ʹ�ü�����Ŷ��JavaBeanʵ�������ɶ����ѡ��
	ʹ�ü���Ԫ����name������Ϊ��ѡ��ı�ǩ
	ʹ�ü���Ԫ����author������Ϊ��ѡ���value-->
<s:checkboxlist name="c" label="��ѡ����ϲ����ͼ��" 
	labelposition="top"
	list="#bs.books"
	listKey="author"
	listValue="name"/>
</s:form>
</body>
</html>