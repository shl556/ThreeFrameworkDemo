package com.bar3.strustDemo.jasperReport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class MyFill {
	private static String basePath = "src/main/java/jasperReport/";
	public static void test() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("author", "孙大圣");
		params.put("book1", "疯狂Java讲义");
		params.put("book2", "轻量级Java EE企业应用实战");
		params.put("book3", "疯狂Ajax讲义");
		// 填充时，即使没有使用数据源，也必须指定一个新建的
		// JREmptyDataSource实例，而不能直接使用null
		// 使用params填充报表中的参数,生成jrprint文件
		JasperFillManager.fillReportToFile(basePath + "simpleVariable.jasper", params, new JREmptyDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}
	/*
	 * <queryString>元素用于指定查询语句，<paramter>元素用于定义参数，<field>元素表示所查询表格的字段，通过$V{name}访问变量
	 * ，$P{name}访问参数，通过 填充报表时使用Map对象传入，$F{name}访问字段，通常对应查询字段或者集合元素的属性等
	 */
	public static void test2() throws Exception {
		// 设置填充报表时使用Map对象作为参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
		// 填充时，直接指定一个Connection作为数据库连接
		JasperFillManager.fillReportToFile(basePath + "simpleQuery.jasper", params, getConnection());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String connectString = "jdbc:mysql://localhost:3306/sampledb";
		String user = "root";
		String password = "shl556161";
		// 加载驱动
		Class.forName(driver);
		// 获得数据库连接
		Connection conn = DriverManager.getConnection(connectString, user, password);
		return conn;
	}
	public static void test3() throws Exception {
		// 填充时指定一个JRDataSource作为数据库连接
		JasperFillManager.fillReportToFile(basePath+"voList.jasper", null, getDataSource());
		System.out.println("成功填充了一个报表文件(*.jrprint)");
	}
	// 定义用于获取JRDataSource的方法，将VO集合包装成JRDataSource
	private static JRDataSource getDataSource() {
		List<BookVo> books = new ArrayList<BookVo>();
		books.add(new BookVo(1, "疯狂Java讲义", "李刚"));
		books.add(new BookVo(2, "轻量级Java EE企业应用实战", "李刚"));
		books.add(new BookVo(3, "疯狂Android讲义", "李刚"));
		return new JRBeanCollectionDataSource(books);
	}
	public static void main(String[] args) throws Exception {
		test3();
	}
}
