<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="java.io.*,java.awt.*"%> 
<%@ page import="org.jfree.chart.labels.*"%> 
<%@ page import="org.jfree.chart.title.*"%> 

<% 
// 创建饼图所需的DefaultPieDataset数据
DefaultPieDataset data = new DefaultPieDataset();
data.setValue("疯狂Java讲义",47000);
data.setValue("轻量级Java EE企业应用实战",38000);
data.setValue("疯狂Ajax讲义",31000);
data.setValue("Struts 2权威指南",29000);
data.setValue("疯狂XML讲义",25000);
// 创建3D饼图的Plot对象
PiePlot3D plot = new PiePlot3D(data); 
plot.setLabelFont(new Font("隶书", Font.BOLD, 16)); 
// 生成3D饼图的图表
JFreeChart chart = new JFreeChart(""
	,JFreeChart.DEFAULT_TITLE_FONT, plot, true); 
chart.setTitle(new TextTitle("图书销量统计图"
	, new Font("黑体", Font.ITALIC , 22)));
// 获取统计图表的图例对象
LegendTitle legend = chart.getLegend(0);
// 修改图例的字体
legend.setItemFont(new Font("宋体", Font.BOLD, 13));
// 生成饼图各部分的提示，当鼠标悬停时显示实际统计值
plot.setToolTipGenerator(new StandardPieToolTipGenerator()); 
// 设定热点链接
plot.setURLGenerator(new StandardPieURLGenerator("b.action")); 
StandardEntityCollection entityCollection = 
	new StandardEntityCollection(); 
// 生成RenderingInfo实例
ChartRenderingInfo info = new ChartRenderingInfo(entityCollection); 
// 将页面输出流out包装成一个PrintWriter实例
PrintWriter pw = new PrintWriter(out); 
// 在Web服务器的临时目录生成一张图片，720是图片长度，450是图片高度 
String filename = ServletUtilities.saveChartAsPNG(
	chart, 720, 450, info, null); 
// writeImageMap()方法在HTML页面上输出map元素，也就是定义图片热点信息
// pw代表页面的输出流,map0是定义热点的Map标签ID
// info参数保存图片的热点信息。 
ChartUtilities.writeImageMap(pw, "map0", info, false);
%>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>图书销量饼图</title>
</head>
<body>
<div align="center"> 
<img src="<%=request.getContextPath() %>/displayChart.do?filename=<%=filename%>"
	width="720" height="450" usemap="#map0"> 
</div> 
</body>
</html>