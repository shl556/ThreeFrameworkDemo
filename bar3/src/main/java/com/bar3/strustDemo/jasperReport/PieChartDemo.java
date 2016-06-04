package com.bar3.strustDemo.jasperReport;


import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


public class PieChartDemo
{
	private static String basePath="src/main/java/jasperReport/";
	public static  void test() throws Exception{
		// 生成普通饼图
//		JFreeChart chart = ChartFactory.createPieChart(
		// 生成3D饼图
		JFreeChart chart = ChartFactory.createPieChart3D(
			"图书销量统计图",  // 图表标题
			getDataSet(), // 数据
			true, // 是否显示图例
			true, // 是否显示工具提示
			false // 是否生成URL
		);
		// 重新设置图表标题，改变字体
		chart.setTitle(new TextTitle("图书销量"
			, new Font("黑体", Font.ITALIC , 26)));
		// 取得统计图表的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 获得饼图的Plot对象
		PiePlot plot = (PiePlot)chart.getPlot();
		// 设置饼图各部分的标签字体
		plot.setLabelFont(new Font("隶书", Font.BOLD, 18));
		// 设定背景透明度（0-1.0之间）
		plot.setBackgroundAlpha(1f);
		// 设定前景透明度（0-1.0之间）
		plot.setForegroundAlpha(0.5f);
		FileOutputStream fos = new FileOutputStream(basePath+"book.jpg");
		ChartUtilities.writeChartAsJPEG(
			fos, // 输出到哪个输出流
			1, // JPEG图片的质量，0~1之间
			chart, // 统计图表对象
			800, // 宽
			600,// 宽
			null // ChartRenderingInfo 信息
		);
		fos.close();
	}
	//输出柱状图
	public static  void test2() throws Exception {
//		JFreeChart chart = ChartFactory.createBarChart3D(
//	    JFreeChart chart = ChartFactory.createLineChart(
	    JFreeChart chart = ChartFactory.createLineChart3D(
				"图书销量统计图", // 图表标题
				"图书", // 目录轴的显示标签
				"销量", // 数值轴的显示标签
				getDataSet1(), // 数据集
				//PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL , // 图表方向：垂直
				false, 	// 是否显示图例(对于简单的柱状图必须是false)
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
			);

			// 重新设置图表标题，改变字体
			chart.setTitle(new TextTitle("图书销量统计图"
				, new Font("黑体", Font.ITALIC , 22)));
			CategoryPlot plot = (CategoryPlot)chart.getPlot();
			// 取得横轴
			CategoryAxis categoryAxis = plot.getDomainAxis();
			// 设置横轴显示标签的字体
			categoryAxis.setLabelFont(new Font("宋体"
				, Font.BOLD , 22));
			// 分类标签以45度角倾斜
			categoryAxis.setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
			categoryAxis.setTickLabelFont(new Font("宋体"
				, Font.BOLD , 18));
			// 取得纵轴
			NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
			// 设置纵轴显示标签的字体
			numberAxis.setLabelFont(new Font("宋体"
				, Font.BOLD , 22));
			// 输出到图片文件
			FileOutputStream fos = null;
			fos = new FileOutputStream(basePath+"book.jpg");
			// 将统计图表输出成JPG文件
			ChartUtilities.writeChartAsJPEG(
				fos, // 输出到哪个输出流
				1, // JPEG图片的质量，0~1之间
				chart, // 统计图表对象
				800, // 宽
				600,// 宽
				null // ChartRenderingInfo 信息
			);
			fos.close();
	}
	public static  void test3() throws Exception {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"图书销量统计图", // 图表标题
				"图书", // 目录轴的显示标签
				"销量", // 数值轴的显示标签
				getDataSet2(), // 数据集
				true, 	// 是否显示图例(对于简单的柱状图必须是false)
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
			);

			// 重新设置图表标题，改变字体
			chart.setTitle(new TextTitle("图书销量统计图"
				, new Font("黑体", Font.ITALIC , 22)));
			// 取得统计图表的第一个图例
			LegendTitle legend = chart.getLegend(0);
			// 修改图例的字体
			legend.setItemFont(new Font("宋体", Font.BOLD, 14));
			// 取得时间顺序图的Plot对象
			XYPlot plot = (XYPlot)chart.getPlot();
			// 取得横轴
			ValueAxis categoryAxis = plot.getDomainAxis();
			// 设置横轴显示标签的字体
			categoryAxis.setLabelFont(new Font("宋体"
				, Font.BOLD , 22));
			categoryAxis.setTickLabelFont(new Font("宋体"
				, Font.BOLD , 18));
			// 取得纵轴
			NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
			// 设置纵轴显示标签的字体
			numberAxis.setLabelFont(new Font("宋体" , Font.BOLD , 22));
			FileOutputStream fos = null;
			fos = new FileOutputStream("book.jpg");
			// 将统计图表输出成JPG文件
			ChartUtilities.writeChartAsJPEG(
				fos, // 输出到哪个输出流
				1, // JPEG图片的质量，0~1之间
				chart, // 统计图表对象
				800, // 宽
				600,// 宽
				null // ChartRenderingInfo 信息
			);
			fos.close();
	}
	public static  void test4() {
		DefaultPieDataset data = getDataSet4();
        JFreeChart chart = ChartFactory.createPieChart3D("水果产量",data,true,false,false);
      //设置百分比
        PiePlot pieplot = (PiePlot) chart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
     
    //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
     
        pieplot.setIgnoreNullValues(true);//设置不显示空值
        pieplot.setIgnoreZeroValues(true);//设置不显示负值
        ChartPanel frame1=new ChartPanel (chart,true);
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
        JFrame frame=new JFrame("Java数据统计图");
        frame.setLayout(new GridLayout(2,2,10,10));
        frame.add(frame1);
        frame.setBounds(50, 50, 600, 800);
        frame.setVisible(true);
	}
	public static  void test5() {
		
	}
	public static void main(String[] args) throws Exception
	{
		test4();
	}
	private static DefaultPieDataset getDataSet()
	{
		// 提供生成饼图的数据
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("疯狂Java讲义",42000);
		dataset.setValue("轻量级Java EE企业实战",48000);
		dataset.setValue("疯狂Ajax讲义",31000);
		dataset.setValue("疯狂Android讲义",59000);
		dataset.setValue("疯狂XML讲义",25000);
		return dataset;
	}
	private static CategoryDataset getDataSet1()
	{
		// 提供创建统计图表的数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(42000 , "" , "疯狂Java讲义");
		dataset.addValue(48000 , "" , "轻量级Java EE企业实战");
		dataset.addValue(31000 , "" , "疯狂Ajax讲义");
		dataset.addValue(59000 , "" , "疯狂Android讲义");
		dataset.addValue(25000 , "" , "疯狂XML讲义");
		return dataset;
	}
	
	// 返回一个CategoryDataset实例
		private static CategoryDataset getDataSet3()
		{
			// 创建DefaultCategoryDataset数据集
			DefaultCategoryDataset dataset =
				new DefaultCategoryDataset();
			dataset.addValue(45000 , "北京" , "疯狂Java讲义");
			dataset.addValue(38000 , "北京" , "轻量级Java EE企业实战");
			dataset.addValue(24000 , "北京" , "疯狂Ajax讲义");
			dataset.addValue(32000 , "北京" , "Struts 2权威指南");
			dataset.addValue(21000 , "北京" , "疯狂XML讲义");
			dataset.addValue(37000 , "上海" , "疯狂Java讲义");
			dataset.addValue(36000 , "上海" , "轻量级Java EE企业实战");
			dataset.addValue(34000 , "上海" , "疯狂Ajax讲义");
			dataset.addValue(42000 , "上海" , "Struts 2权威指南");
			dataset.addValue(12000 , "上海" , "疯狂XML讲义");
			dataset.addValue(42000 , "广州" , "疯狂Java讲义");
			dataset.addValue(40000 , "广州" , "轻量级Java EE企业实战");
			dataset.addValue(34000 , "广州" , "疯狂Ajax讲义");
			dataset.addValue(18000 , "广州" , "Struts 2权威指南");
			dataset.addValue(26000 , "广州" , "疯狂XML讲义");
			return dataset;
		}
		private static DefaultPieDataset getDataSet4() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("苹果",100);
	        dataset.setValue("梨子",200);
	        dataset.setValue("葡萄",300);
	        dataset.setValue("香蕉",400);
	        dataset.setValue("荔枝",500);
	        return dataset;
	  }
		@SuppressWarnings("deprecation")
		private static XYDataset getDataSet2()
		{
			// 创建第一个TimeSeries对象,必须指定是针对月，年或者天等
			TimeSeries spring = new TimeSeries("疯狂Java讲义",Month.class);
			spring.add(new Month(10, 2006), 3400);
			spring.add(new Month(11, 2006), 2700);
			spring.add(new Month(12, 2006), 3100);
			spring.add(new Month(1, 2007), 1800);
			spring.add(new Month(2, 2007), 2200);
			// 创建第二个TimeSeries对象
			TimeSeries lightWeight = new TimeSeries(
				"轻量级Java EE企业应用实战",Month.class);
			lightWeight.add(new Month(10, 2006), 2800);
			lightWeight.add(new Month(11, 2006), 3700);
			lightWeight.add(new Month(12, 2006), 2600);
			lightWeight.add(new Month(1, 2007), 2100);
			lightWeight.add(new Month(2, 2007), 1100);
			// 将两个TimeSeries对象组合成TimeSeriesCollection
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			dataset.addSeries(spring);
			dataset.addSeries(lightWeight);
			return dataset;
		}
}
