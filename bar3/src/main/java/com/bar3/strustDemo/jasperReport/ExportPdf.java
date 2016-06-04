package com.bar3.strustDemo.jasperReport;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportPdf<T> {
	public void exportPdf(Collection<T> dataset, OutputStream out) {
		exportPdf("测试iText导出PDF文档", null, dataset, out, "yyyy-MM-dd");
	}
	public void exportPdf(String[] headers, Collection<T> dataset, OutputStream out) {
		exportPdf("测试iText导出PDF文档", headers, dataset, out, "yyyy-MM-dd");
	}
	public void exportPdf(String[] headers, Collection<T> dataset, OutputStream out, String pattern) {
		exportPdf("测试iText导出PDF文档", headers, dataset, out, pattern);
	}
	/**
	 * 
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以PDF 的形式输出到指定IO设备上
	 * 
	 *
	 * 
	 * @param title
	 * 
	 *            表格标题名
	 * 
	 * @param headers
	 * 
	 *            表格属性列名数组
	 * 
	 * @param dataset
	 * 
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 * 
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * 
	 * @param out
	 * 
	 *            与输出设备关联的流对象，可以将PDF文档导出到本地文件或者网络中
	 * 
	 * @param pattern
	 * 
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	public void exportPdf(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) {
		// 作为报表的PDF文件，一定要适合打印机的输出打印
		Rectangle rectPageSize = new Rectangle(PageSize.A4);// 定义A4页面大小
		// rectPageSize = rectPageSize.rotate();// 加上这句可以实现A4页面的横置
		Document document = new Document(rectPageSize);// 其余4个参数，设置了页面的4个边距
		try {
			// 将PDF文档写出到out所关联IO设备上的书写对象
			PdfWriter.getInstance(document, out);
			// 添加文档元数据信息
			document.addTitle(StrHelp.getChinese(title));
			document.addSubject("export information");
			document.addAuthor("leno");
			document.addCreator("leno");
			document.addKeywords("pdf itext");
			// 打开PDF文档
			document.open();
			PdfPTable table = new PdfPTable(headers.length);
			// table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.setWidthPercentage(100);
			// 产生表格标题行
			for (int i = 0; i < headers.length; i++) {
				PdfPCell cell = new PdfPCell(new PdfParagraph(headers[i], 14, true));
				cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.GREEN);
				cell.setBorderColor(BaseColor.GREEN);
				cell.setBorderWidth(0.5f);
				table.addCell(cell);
			}
			// 遍历集合数据，产生数据行
			for (int i = 0; i < dataset.size(); i++) {
				T t = (T) CollectionUtils.get(dataset, i);
				Field[] fields = FieldUtils.getAllFields(t.getClass());
				String textValue = null;
				PdfPCell cell = null;
				for (Field field : fields) {
					Object value = FieldUtils.readField(field, t, true);
					if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						textValue = "男";
						if (!bValue) {
							textValue = "女";
						}
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						byte[] bsValue = (byte[]) value;
						Image img = Image.getInstance(bsValue);
						cell = new PdfPCell(img, true);
						cell.setPadding(3);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 如果不是图片数据,就当做文本处理
					if (textValue != null) {
						cell = new PdfPCell(new PdfParagraph(textValue));
						textValue=null;
					}
					cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
					cell.setBorderColor(BaseColor.GREEN);
					cell.setBorderWidth(0.5f);
					table.addCell(cell);
				}
			}
			document.add(table);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		// 测试学生
		ExportPdf<Student> ex = new ExportPdf<Student>();
		String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
		java.util.List<Student> dataset = new ArrayList<Student>();
		dataset.add(new Student(10000001, "张三", 20, true, new Date()));
		dataset.add(new Student(20000002, "李四", 24, false, new Date()));
		dataset.add(new Student(30000003, "王五", 22, true, new Date()));
		// 测试图书
		ExportPdf<Book> ex2 = new ExportPdf<Book>();
		String[] headers2 = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN", "图书出版社", "封面图片" };
		java.util.List<Book> dataset2 = new ArrayList<Book>();
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("resources/watermark.jpg"));
			byte[] buf = new byte[bis.available()];
			while ((bis.read(buf)) != -1) {
				//
			}
			dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567", "阳光出版社", buf));
			dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567", "汤春秀出版社", buf));
			OutputStream out = new FileOutputStream("d://a.pdf");
			OutputStream out2 = new FileOutputStream("d://b.pdf");
			ex.exportPdf(headers, dataset, out);
			ex2.exportPdf(headers2, dataset2, out2);
			out.close();
			out2.close();
			JOptionPane.showMessageDialog(null, "pdf导出成功!");
			System.out.println("pdf导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
