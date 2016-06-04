

<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@ page import="org.jfree.chart.ChartFactory, org.jfree.chart.JFreeChart, org.jfree.chart.plot.PlotOrientation" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities,org.jfree.data.category.*"%> 
<%@ page import="org.jfree.chart.title.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.axis.*"%> 
<%@ page import="java.awt.*"%> 

<% 
CategoryDataset dataset;
// 取得地址栏里的查询字符串
String queryString = request.getQueryString();
// 将地址栏里的查询字符串解码成正确的编码形式
queryString = java.net.URLDecoder.decode(queryString , "UTF-8");
String category = null;
// 取出查询字符串里的请求参数
for(String param : queryString.split("&"))
{
	String[] nameValue = param.split("=");
	category = nameValue[0].equals("category") 
		? nameValue[1] : category;
}
String subTitle = "";
// 根据category请求参数来决定dataset值，以及subTitle的字符串值
if(category.equals("疯狂Java讲义")  || 
	category.equals("轻量级Java EE企业应用实战") ||
	category.equals("疯狂Ajax讲义")) 
{
	dataset = leeGetDataSet(); 
	subTitle="疯狂Java体系";
}
else 
{
	dataset = getDataSet(); 
	subTitle="其他";
}
System.out.println(subTitle);
String title = subTitle + "图书的销售情况"; 
JFreeChart chart = ChartFactory.createBarChart3D(
	title,  
	"月份", 
	"销量", 
	dataset, 
	PlotOrientation.VERTICAL, 
	true, 
	false, 
	false
); 
// 重新设置图表标题，改变字体
chart.setTitle(new TextTitle(title
	, new Font("黑体", Font.ITALIC , 22))); 
// 取得统计图表的第一个图例
LegendTitle legend = chart.getLegend(0);
// 修改图例的字体
legend.setItemFont(new Font("宋体", Font.BOLD, 14)); 
CategoryPlot plot = (CategoryPlot)chart.getPlot();
// 取得横轴
CategoryAxis categoryAxis = plot.getDomainAxis();
// 设置横轴显示标签的字体
categoryAxis.setLabelFont(new Font("宋体" , Font.BOLD , 22));
// 分类标签以45度角倾斜
categoryAxis.setCategoryLabelPositions(
	CategoryLabelPositions.UP_45);
categoryAxis.setTickLabelFont(new Font("宋体"
	, Font.BOLD , 18));
// 取得纵轴
NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
// 设置纵轴显示标签的字体
numberAxis.setLabelFont(new Font("宋体" , Font.BOLD , 22));
// 将JFreeChart统计图表输出到Web服务器的临时目录下
String filename = ServletUtilities.saveChartAsPNG(
	chart, 650, 390, null, session);
%> 
<%! 
private static CategoryDataset leeGetDataSet() 
{ 
	DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	dataset.addValue(3000, "疯狂Java讲义", "06年10月");
	dataset.addValue(2800, "疯狂Java讲义", "06年11月");
	dataset.addValue(2100, "疯狂Java讲义", "06年12月");
	dataset.addValue(3200, "疯狂Java讲义", "07年01月");
	dataset.addValue(2800, "轻量级Java EE企业应用实战", "07年01月"); 
	dataset.addValue(2680, "疯狂Ajax讲义", "07年01月"); 
	dataset.addValue(2690, "疯狂Java讲义", "07年02月");
	dataset.addValue(1830, "轻量级Java EE企业应用实战", "07年02月"); 
	dataset.addValue(3490, "疯狂Ajax讲义", "07年02月");
	dataset.addValue(1890, "疯狂Java讲义", "07年03月");
	dataset.addValue(2640, "轻量级Java EE企业应用实战", "07年03月"); 
	dataset.addValue(3180, "疯狂Ajax讲义", "07年03月");
	return dataset; 
} 
private static CategoryDataset getDataSet() 
{ 
	DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	dataset.addValue(3500, "Struts 2权威指南", "06年10月");
	dataset.addValue(4200, "疯狂XML讲义", "06年10月"); 
	dataset.addValue(3800, "Struts 2权威指南", "06年11月");
	dataset.addValue(2300, "疯狂XML讲义", "06年11月"); 
	dataset.addValue(2590, "Struts 2权威指南", "06年12月");
	dataset.addValue(1590, "疯狂XML讲义", "06年12月"); 
	dataset.addValue(3180, "Struts 2权威指南", "07年01月");
	dataset.addValue(1200, "疯狂XML讲义", "07年01月"); 
	dataset.addValue(3140, "Struts 2权威指南", "07年02月");
	dataset.addValue(940, "疯狂XML讲义", "07年02月"); 
	return dataset; 
} 
%>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title><%=title%></title>
</head>
<body>
<div align="center"> 
<img src="<%=request.getContextPath() %>/displayChart.do?filename=<%=filename%>" 
	width="650" height="390" border="0"/>  
</div>
</body>
</html>