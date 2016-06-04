package com.bar3.strustDemo.jasperReport;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;


import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;

import java.awt.Font;
import java.awt.geom.Ellipse2D.Float;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.LegendTitle;


public class ChartAction extends ActionSupport
{
	private JFreeChart chart;
	// 必须提供getChart()方法，且由该方法返回JFreeChart对象
	public JFreeChart getChart()
	{
		chart = ChartFactory.createPieChart3D(
			"图书销量统计图",  // 图表标题
			getDataSet(), //数据
			true, // 是否显示图例
			false, //是否显示工具提示
			false //是否生成URL
		);
		// 重新设置图表标题，改变字体
		chart.setTitle(new TextTitle("图书销量统计图"
			, new Font("黑体", Font.ITALIC , 22)));
		// 取得统计图表的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 获得饼图的Plot对象
		PiePlot plot = (PiePlot)chart.getPlot();
		// 设置饼图各部分的标签字体
		plot.setLabelFont(new Font("隶书", Font.BOLD, 18));
		// 设定背景透明度（0-1.0之间）
        plot.setBackgroundAlpha(0.9f);
		// 设定前景透明度（0-1.0之间）
        plot.setForegroundAlpha(0.50f);
		return chart;
	}
	// 获取生成统计图的Dataset
	private DefaultPieDataset getDataSet()
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
}
