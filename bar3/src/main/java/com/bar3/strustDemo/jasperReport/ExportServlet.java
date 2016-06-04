package com.bar3.strustDemo.jasperReport;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExportServlet
 */
@WebServlet("/ExportServlet")
public class ExportServlet extends HttpServlet {
	static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(getServletContext().getRealPath("WEB-INF/book.jpg"));
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename=test.xls");
		// 测试图书
		ExportExcel<Book> ex = new ExportExcel<Book>();
		String[] headers = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN", "图书出版社", "封面图片" };
		List<Book> dataset = new ArrayList<Book>();
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buf = new byte[bis.available()];
			while ((bis.read(buf)) != -1) {
				// 将图片数据存放到缓冲数组中
			}
			dataset.add(new Book(1, "jsp", "leno", 300.33f, "1234567", "清华出版社", buf));
			dataset.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567", "阳光出版社", buf));
			dataset.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567", "清华出版社", buf));
			dataset.add(new Book(4, "c++经典", "leno", 400.33f, "1234567", "清华出版社", buf));
			dataset.add(new Book(5, "c#入门", "leno", 300.33f, "1234567", "汤春秀出版社", buf));
			OutputStream out = response.getOutputStream();
			ex.exportExcel(headers, dataset, out);
			out.close();
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}
}
