<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>1、集合合并标签append和merge</h3>
   <s:append var="newCollection">

<s:param value="{'中国', '美国', '日本'}"></s:param>

<s:param value="{'德国', '泰国', '新加坡'}"></s:param>

 </s:append>
<s:merge var="newCollection2">
<s:param value="{'中国', '美国', '日本'}"></s:param>

<s:param value="{'德国', '泰国', '新加坡'}"></s:param>
</s:merge>
 <s:iterator value="#newCollection"var="cur">

<s:property value="#cur"/><br/>

 </s:iterator>
 <s:iterator value="#newCollection2"var="cur">

<s:property value="#cur"/><br/>

 </s:iterator>
 <h3>2、字符串分割标签generator</h3>
 <s:generator separator=","val="'中,华人,民共和,国'" var="arr"/>
<s:iterator value="#arr"var="cur">
    <s:property value="#cur"/><Br/>
</s:iterator>
 <h3>3、集合子集标签  subset</h3>
 <s:subset source="{'中国', '美国', '日本', '德国', '泰国', '新加坡'}" start="1"count="3">

<s:iterator  var="cur">

<s:property value="#cur"/>

</s:iterator>

</s:subset>
 <h3>4、排序标签 sort</h3><!-- 根据定义的排序规则,对集合中的元素进行排序,排序后生成的新的集合放在值栈顶部,标签结束后自动删除. -->
 <s:bean name="com.aptech.sorted.LengthSorted"var="ls" />

<s:sort comparator="#ls"source="{'中1','88w','777','6666'}">

<s:iterator>

<s:property/><br/>

</s:iterator>

</s:sort>
 <h3>5、设置变量标签 set</h3><!-- 注:如果不指定,默认放在Stack Context中 -->
 <s:set var="v1"value="'中华人民共和国'" scope="page"></s:set>

<s:property value="#attr.v1"/>
 <h3>6、栈顶置值标签 push</h3>
 <s:push value="'中华人民共和国'" >

<s:property/>

</s:push>
 <h3>7、javabean创建标签 bean</h3>
 <s:bean name="com.aptech.entity.Student"var="stu">

<s:param name="sid">1</s:param>

<s:param name="sname">张三好</s:param>

<s:param name="sbirthday">2009-9-9</s:param>

</s:bean>

<s:property value="#stu.sbirthday"/>
<h3>8、日期格式化标签 date</h3>
<%pageContext.setAttribute("d", new Date()); %>

<s:date name="#attr.d"format="yyyy年MM月dd日 HH时mm分ss秒"/>
<h3>9、URL生成标签 url</h3>
<s:url value="control.jsp"var="url">

<s:param name="id">中华人民共和国</s:param>

</s:url>

<a href="<s:propertyvalue="#url" />">链接</a>

<s:url action="test"var="url2"></s:url>

<s:property value="#url2"/>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
<h3>、</h3>
</body>
</html>