<%@page import="java.awt.Font"%>
<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<%@ page import="org.jfree.chart.*,org.jfree.data.category.*,
org.jfree.chart.servlet.*,org.jfree.chart.plot.PlotOrientation,org.jfree.data.general.DatasetUtilities"%>
<%
/* double[][] data = new double[][] {{1320}, {720}, {830}, {400}};
String[] rowKeys = {"苹果", "香蕉", "橘子", "梨子"};
String[] columnKeys = {""}; */
double[][] data = new double[][] {{1230,1110,1120,1210}, {720,750,860,800}, {830,780,790,700,}, {400,380,390,450}};
String[] rowKeys = {"苹果", "香蕉", "橘子", "梨子"};
String[] columnKeys = {"鹤壁","西安","深圳","北京"};
CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);
StandardChartTheme mChartTheme = new StandardChartTheme("CN");  
//设置标题字体  
mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));  
//设置轴向字体  
mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
//设置图例字体  
mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
//应用主题样式  
ChartFactory.setChartTheme(mChartTheme);   
JFreeChart chart = ChartFactory.createBarChart3D("水果销量统计图",
                  "水果",
                  "销量",
                  dataset,
                  PlotOrientation.VERTICAL,
                  true,
                  false,
                  false);
String filename = ServletUtilities.saveChartAsPNG(chart, 800, 600, null, session);
String graphURL = request.getContextPath() + "/displayChart.do?filename=" + filename;
%>
<img src="<%= graphURL %>" width="800" height="600" border=0>