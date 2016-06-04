package com.bar3.strustDemo.jasperReport;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import oracle.net.aso.d;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.chainsaw.Main;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 
 * 利用开源组件POI3.0.2动态导出EXCEL文档
 * 
 * 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * 
 * @version v1.0
 * 
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 * 
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 * 
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel<T> {
	public void exportExcel(Collection<T> dataset, OutputStream out) {
		exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
	}
	public void exportExcel(String[] headers, Collection<T> dataset, OutputStream out) {
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
	}
	public void exportExcel(String[] headers, Collection<T> dataset, OutputStream out, String pattern) {
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);
	}
	/**
	 * 
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
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
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * 
	 * @param pattern
	 * 
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		Sheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为20和列的高度个字节
		sheet = setSheetStyle(sheet, 20, 20);
		// 生成一个样式
		MyCellStyle cellStyle = new MyCellStyle(workbook);
		// 设置边框样式
		cellStyle.setBorderStyle(HSSFCellStyle.BORDER_THIN, HSSFColor.BLACK.index, HSSFCellStyle.BORDER_THIN,
				HSSFColor.BLACK.index);
		// 设置填充颜色样式
		cellStyle.setCellFillColor(HSSFColor.BLUE.index);
		// 设置文字对齐样式
		cellStyle.setCellAlignStyle(HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER);
		// 设置字体样式
		cellStyle.setFontStyle("宋体", 18, HSSFColor.YELLOW.index);
		cellStyle.getFont().setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 生成并设置另一个样式
		MyCellStyle cellStyle2 = new MyCellStyle(workbook);
		cellStyle2.setCellStyle(cellStyle.getCellStyleCopy());
		cellStyle2.setFontStyle("宋体", 14, HSSFColor.RED.index);
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("leno");
       //产生标题行
		Row row = sheet.createRow(0);
		row.setHeightInPoints(30);
		for (short i = 0; i < headers.length; i++) {
			Cell cell=row.createCell(i);
			if(i==0){
				cell.setCellValue(title);
				MyCellStyle cellStyle3=new MyCellStyle(workbook);
				cellStyle3.setCellStyle(cellStyle.getCellStyleCopy());
				cellStyle3.setFontStyle("宋体", 20, HSSFColor.RED.index);
				cell.setCellStyle(cellStyle3.getCellStyle());
			}
		}
		//合并标题行单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (headers.length-1)));
		// 产生表格标题行,标题行的顺序与javabean中的属性声明顺序相同
		Row row1=sheet.createRow(1);
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row1.createCell(i);
			cell.setCellStyle(cellStyle.getCellStyle());
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		int a=2,i=0;
		// 遍历集合数据，产生数据行
		for(i=0;i<dataset.size();i++,a++){	
			row = sheet.createRow(a);
			T t = (T) CollectionUtils.get(dataset, i);
			BeanMap beanMap=new BeanMap(t);
			String textValue = null;
			int j=0;
			for(Object value:beanMap.values()){
				if(value instanceof Class<?>){
					continue;
				}
				HSSFCell cell = (HSSFCell) row.createCell(j);
				cell.setCellStyle(cellStyle2.getCellStyle());
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
					// 有图片时，设置行高为60px;
					row.setHeightInPoints(60);
					// 设置图片所在列宽度为80px,注意这里单位的一个换算
					sheet.setColumnWidth(j, (short) (35.7 * 80));
					// sheet.autoSizeColumn(i);
					byte[] bsValue = (byte[]) value;
					HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, a, (short) 6,
							a);
					anchor.setAnchorType(2);
					patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
				} else {
					// 其它数据类型都当作字符串简单处理
					textValue = value.toString();
				}
				// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
				if (textValue != null) {
					Pattern p = Pattern.compile("^//d+(//.//d+)?$");
					Matcher matcher = p.matcher(textValue);
					if (matcher.matches()) {
						// 是数字当作double处理
						cell.setCellValue(Double.parseDouble(textValue));
					} else {
						HSSFRichTextString richString = new HSSFRichTextString(textValue);
						cell.setCellValue(richString);
					}
			}
			j++;
			}
		}
			try {
				workbook.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public static void main(String[] args) {
		// 测试学生
		ExportExcel<Student> ex = new ExportExcel<Student>();
		String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
		List<Student> dataset = new ArrayList<Student>();
		dataset.add(new Student(10000001, "张三", 20, true, new Date()));
		dataset.add(new Student(20000002, "李四", 24, false, new Date()));
		dataset.add(new Student(30000003, "王五", 22, true, new Date()));
		// 测试图书
		ExportExcel<Book> ex2 = new ExportExcel<Book>();
		String[] headers2 = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN", "图书出版社", "封面图片" };
		List<Book> dataset2 = new ArrayList<Book>();
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/java/book.jpg"));
			byte[] buf = new byte[bis.available()];
			while ((bis.read(buf)) != -1) {
				//
			}
			dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567", "阳光出版社", buf));
			dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567", "清华出版社", buf));
			dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567", "汤春秀出版社", buf));
			OutputStream out = new FileOutputStream("E://a.xls");
			OutputStream out2 = new FileOutputStream("E://b.xls");
			ex.exportExcel(headers, dataset, out);
			ex2.exportExcel(headers2, dataset2, out2);
			out.close();
			out2.close();
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(HSSFFont.BOLDWEIGHT_BOLD);
	}
	/**
	 * @Description: 设置默认的列宽和行高
	 * @param sheet
	 * @param columnWidth
	 *            列宽
	 * @param rowHeight
	 *            行高
	 * @return
	 */
	private Sheet setSheetStyle(Sheet sheet, int columnWidth, int rowHeight) {
		// 设置默认的列宽和行高
		sheet.setDefaultColumnWidth((short) (columnWidth));
		sheet.setDefaultRowHeightInPoints(rowHeight);
		// 设置自动分页
		sheet.setAutobreaks(true);
		return sheet;
	}
	
}