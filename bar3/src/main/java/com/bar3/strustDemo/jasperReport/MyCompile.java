package com.bar3.strustDemo.jasperReport;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

public class MyCompile {
	private static String basePath="src/main/java/jasperReport/";
	public static void test() throws Exception {
		//编译前调整字体和编码
		// 编译static.jrxml报表设计文件，生成一个static.jasper报表文件
		JasperCompileManager.compileReportToFile(basePath+"voList.jrxml", basePath+"voList.jasper");
		System.out.println("成功编译成JasperReport文件(*.jasper)");
	}
	public static void test2() throws Exception {
		// 填充时，即使没有使用数据源
		// 也必须指定一个新建的JREmptyDataSource实例，而不能直接使用null
		// static.jspprint报表是格式无关的，可以通过它转换成PDF格式或者Excel格式的报表，还可以直接使用JasperReports的报表浏览工具来浏览
		JasperFillManager.fillReportToFile("src/main/java/static.jasper", "src/main/java/static.jrprint", null,
				new JREmptyDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}
	public static void test3() throws Exception {
		// 以指定的*.jsprint文件创建一个JRViewer实例
		// JRViewer可以用JFrame装载也可以通过Applet装载
		JRViewer jr = new JRViewer(basePath+"voList.jrprint", false);
		// 创建一个主窗口
		JFrame jf = new JFrame("报表预览");
		// 把JRViewer实例加载在窗口中
		jf.add(jr);
		jf.pack();
		// 显示窗口
		jf.setVisible(true);
	}
	@SuppressWarnings("deprecation")
	public static void test4() throws Exception {
		// 使用JRLoader来加载一个*.jrprint文件，生成一个JasperPrint实例
		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObjectFromFile("src/main/java/static.jrprint");
		// 创建一个JRXlsExporter实例(依赖于POI)，用于导出Excel文档
//		JRXlsExporter exporter = new JRXlsExporter();
		JRHtmlExporter exporter=new JRHtmlExporter();
		// // 创建一个JExcelApiExporter实例(依赖于JXL)，用于导出Excel文档
		// JExcelApiExporter exporter = new JExcelApiExporter();
		// 设置要导出的JasperPrint实例
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		// 设置要导出的目标文件
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "src/main/java/static.html");
		// 设置每张报表都写在不同的文件里
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporter.exportReport();
		System.out.println("成功创建了一个Excel文档");
	}
	public static void test5() throws Exception {
		JasperExportManager.exportReportToPdfFile(basePath+"voList.jrprint"
				, basePath+"voList.pdf");
//		JasperRunManager.runReportToHtmlFile("src/main/java/static.jrprint", "src/main/java/static.html", null);
		System.out.println("src/main/java/成功创建了一个PDF文档");
	}
	public static void test6() throws Exception {
	}
	public static void test7() throws Exception {
	}
	public static void test8() throws Exception {
	}
	public static void main(String[] args) throws Exception {
//	    test();
//	    test2();
//	    test3();
//	    test4();
	    test5();
	}
}
