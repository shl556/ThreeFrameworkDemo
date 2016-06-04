package com.bar3.strustDemo.jasperReport;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import com.bar3.strustDemo.spring.MyServiceImpl;


/**
* @ClassName: MyCellStyle
* @Description: 封装常用单元格样式设置选项
* @author shl
* @date 2016年3月16日 上午10:40:23
*/
public class MyCellStyle implements Cloneable{
	private  CellStyle cellStyle;
	private  Workbook workbook;
	private  Font font;
	public MyCellStyle(){
		
	}
	public MyCellStyle(Workbook workBook){
		cellStyle=workBook.createCellStyle();
		this.workbook=workBook;
	}
	public CellStyle getCellStyle(){
		return cellStyle;
	}
	public Font getFont() {
		return font;
	}
	public CellStyle getCellStyleCopy(){
		CellStyle cellStyle=workbook.createCellStyle();
		cellStyle.cloneStyleFrom(this.cellStyle);
		return cellStyle;
	}
	/**
	* @Description: 设置边框样式和颜色，默认左右边框，上下边框样式相同
	* @param cellStyle
	* @param leftBorder 左边框
	* @param leftBorderColor 左边框颜色
	* @param topBorder 右边框
	* @param topBorderColor 右边框颜色
	* @return     
	*/
	public void setBorderStyle(short leftBorder,short leftBorderColor,
			short topBorder,short topBorderColor){
		cellStyle.setBorderLeft(leftBorder);
		cellStyle.setLeftBorderColor(leftBorderColor);
		cellStyle.setBorderRight(leftBorder);
		cellStyle.setRightBorderColor(leftBorderColor);
		cellStyle.setBorderTop(topBorder);
		cellStyle.setTopBorderColor(topBorderColor);
		cellStyle.setBorderBottom(topBorder);
		cellStyle.setBottomBorderColor(topBorderColor);
	}
	
	/**
	* @Description: 设置前景色，背景色和填充方式
	* @param cellStyle
	* @param foregroundColor 前景色
	* @param backGroundColor 背景色
	* @param fillStyle 填充方式
	* @return     
	*/
	public  void  setCellFillColor(short backGroundColor){
		cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		cellStyle.setFillBackgroundColor(backGroundColor);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}
	
	/**
	* @Description: 设置单元格中文字对齐方式
	* @param cellStyle
	* @param align 左右对齐方式
	* @param verticalAlign 上下对齐方式
	* @return     
	*/
	public  void setCellAlignStyle(short align,short verticalAlign){
		cellStyle.setAlignment(align);
		cellStyle.setVerticalAlignment(verticalAlign);
	}
	
	/**
	* @Description: 设置字体名称，字体大小和颜色，默认加粗
	* @param fontName
	* @param fontSize
	* @param fontColor     
	*/
	public void setFontStyle(String fontName,int fontSize,short fontColor){
		font=workbook.createFont();
		font.setFontName(fontName);
		font.setFontHeightInPoints((short)fontSize);
		font.setColor(fontColor);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(font);
	}
	/**
	* @Description: 设置数字或者日期格式
	* @param dateFormate     
	*/
	public void setDataFomate(String dateFormate){
		short format=workbook.createDataFormat().getFormat(dateFormate);
		cellStyle.setDataFormat(format);
	}

   public void setCellStyle(CellStyle cellStyle) {
	this.cellStyle = cellStyle;
}	
}
