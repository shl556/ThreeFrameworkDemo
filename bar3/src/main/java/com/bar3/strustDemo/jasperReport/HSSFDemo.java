package com.bar3.strustDemo.jasperReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//HSSF是指2007年以前的,XSSF是指2007年版本以上的 
public class HSSFDemo {
	public static void main(String[] args) throws IOException {  
        //创建Workbook对象（这一个对象代表着对应的一个Excel文件）  
                     //HSSFWorkbook表示以xls为后缀名的文件  
        Workbook wb = new HSSFWorkbook();  
        //获得CreationHelper对象,这个应该是一个帮助类  
        CreationHelper helper = wb.getCreationHelper();  
        //创建Sheet并给名字(表示Excel的一个Sheet)  
        Sheet sheet1 = (Sheet) wb.createSheet("HSSF_Sheet_1");        
        Sheet sheet2 = (Sheet) wb.createSheet("HSSF_Sheet_2");  
        //给指定的sheet设定名称，从0开始计算
        wb.setSheetName(1, "工作表");
        HSSFDataFormat df = (HSSFDataFormat) wb.createDataFormat();    
        //给指定列设定列宽，单位为一个字符宽度，最大为256个字符宽度
        sheet1.setColumnWidth(4, 20);
        //使得每一个sheet都适合一页
        sheet1.setAutobreaks(true); 
        //Row表示一行Cell表示一列  
        Row row = null;  
        Cell cell = null;  
        for(int i=0;i<60;i=i+2){  
            //创建这个sheet的第i行  
            row = ((org.apache.poi.ss.usermodel.Sheet) sheet1).createRow(i);  
            //设置行高，setHeight和setHeightInPoints都是设置行高，不过单位不同，前者是后者的20分之一            
            //row.setHeight((short)500);  
            row.setHeightInPoints(20);
            //row.setZeroHeight(true);  
            for(int j=0;j<25;j++){         
                //设置每个sheet每一行的宽度,自动,根据需求自行确定,true表示合并的单元格同样对待
                ((org.apache.poi.ss.usermodel.Sheet) sheet1).autoSizeColumn(j+1, true);  
                //应用边框样式
                CellStyle cellStyle = HSSFDemo.createStyleCell(wb);  
                //应用数据样式
                cellStyle.setDataFormat(df.getFormat("0.00%"));
                //创建每一个行的列 
                cell = row.createCell(j);  
                if(j==0){  
                    //设置文字在单元格里面的位置  
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);  
                    //先创建字体样式,并把这个样式加到单元格的字体里面  
                    cellStyle.setFont(createFonts(wb));  
                    //应用字体对齐样式 
                    cell.setCellStyle(cellStyle);                     
                    //给单元格值类型并设值，值类型必须与单元格的值匹配 
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue("第"+i+"行");  
                }else if(j==1){  
                    //设置文字在单元格里面的位置  
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);  
                    //设置这个样式的格式(Format)  
                    cellStyle = HSSFDemo.setCellFormat(helper,cellStyle, "#,##0.0000");                    
                    //先创建字体样式,并把这个样式加到单元格的字体里面  
                    cellStyle.setFont(createFonts(wb));  
                    //把这个样式加到单元格里面  
                    cell.setCellStyle(cellStyle);  
                    //给单元格设值 
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(new Double(2008.2008));  
                }else if(j==2){  
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);                      
                    cellStyle.setFont(createFonts(wb));  
                    cell.setCellStyle(cellStyle);  
                    cell.setCellValue(helper.createRichTextString("RichString"+i+j));                     
                }else if(j==3){  
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);  
                    cellStyle = HSSFDemo.setCellFormat(helper,cellStyle, "MM-yyyy-dd");  
                    cell.setCellStyle(cellStyle);  
                    cell.setCellValue(new Date());  
                }else if(j==24){  
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);  
                    cellStyle.setFont(createFonts(wb));  
                    //设置公式  
                    cell.setCellFormula("SUM(E"+(i+1)+":X"+(i+1)+")");                    
                }else{                    
                    cellStyle = HSSFDemo.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);  
                    cellStyle = HSSFDemo.setFillBackgroundColors(cellStyle,IndexedColors.ORANGE.getIndex(),IndexedColors.ORANGE.getIndex(),CellStyle.SOLID_FOREGROUND);  
                    cell.setCellStyle(cellStyle);  
                    cell.setCellValue(1);  
                }  
            }  
        } 
        //设置脚注
        Footer footer=sheet1.getFooter();
        //HSSFFooter.page()返回当前页码，HSSFFooter.numPages()返回总页码
        footer.setRight("Page"+HSSFFooter.page()+" of " + HSSFFooter.numPages()+"当前时间："+HSSFFooter.time());
        //设置头注
        Header header = sheet1.getHeader();     
        header.setCenter("Center Header");     
        header.setLeft("Left Header");     
        header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +     
        HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16");  
        //输出  
        OutputStream os = new FileOutputStream(new File("d://HSSFDemo.xls"));  
        wb.write(os);  
        os.close();       
    }  
    /** 
     * 设置边框的样式和颜色
     * @param wb 
     * @return 
     */  
    public static CellStyle createStyleCell(Workbook wb){  
        CellStyle cellStyle = wb.createCellStyle();  
        //设置一个单元格四个边框样式  
        cellStyle.setBorderBottom(CellStyle.BORDER_DOUBLE);  
        cellStyle.setBorderTop(CellStyle.BORDER_DOUBLE);  
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);  
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);  
        //设置一个单元格边框颜色  
        cellStyle.setRightBorderColor(IndexedColors.GREEN.getIndex());  
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());  
        cellStyle.setBottomBorderColor(IndexedColors.RED.getIndex());  
        cellStyle.setTopBorderColor(IndexedColors.RED.getIndex());          
        return cellStyle;  
    }  
    /** 
     * 设置文字在单元格里面的位置 
     * CellStyle.ALIGN_CENTER 
     * CellStyle.VERTICAL_CENTER 
     * @param cellStyle 
     * @param halign 水平对齐方式
     * @param valign 垂直对齐方式
     * @return 
     */  
    public static CellStyle setCellStyleAlignment(CellStyle cellStyle,short halign,short valign){  
        //设置左右居中
//        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        //设置上下居中
//        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
    	return cellStyle;  
    }  
    /** 
     * 格式化单元格 
     * 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找 
     * @param cellStyle 
     * @param fmt 
     * @return 
     */  
    public static CellStyle setCellFormat(CreationHelper helper,CellStyle cellStyle,String fmt){  
        //还可以用其它方法创建format  
        cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));  
        return cellStyle;  
    }  
    /** 
     * 前景和背景填充的着色 
     * @param cellStyle 
     * @param bg IndexedColors.ORANGE.getIndex(); 
     * @param fg IndexedColors.ORANGE.getIndex(); 
     * @param fp CellStyle.SOLID_FOREGROUND 
     * @return 
     */  
    public static CellStyle setFillBackgroundColors(CellStyle cellStyle,short bg,short fg,short fp){  
        //设置背景色
    	cellStyle.setFillBackgroundColor(bg);  
        //设置前景色
    	cellStyle.setFillForegroundColor(fg);  
        //设置填充方式
        cellStyle.setFillPattern(fp);  
        return cellStyle;  
    }  
    /** 
     * 设置字体 
     * @param wb 
     * @return 
     */  
    public static Font createFonts(Workbook wb){  
        //创建Font对象  
        Font font = wb.createFont();  
        //设置字体  
        font.setFontName("宋体"); 
        //设置加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //着色  
        font.setColor(HSSFColor.BLUE.index);  
        //斜体  
        font.setItalic(true);  
        //字体大小  
        font.setFontHeight((short)300);  
        return font;  
    }
    
    public void readExcel() throws Exception{
    	InputStream is = new FileInputStream(new File("c://SummaryHSSF.xls"));  
        //根据输入流创建Workbook对象  
    	POIFSFileSystem fs=new POIFSFileSystem(is);
//    	HSSFWorkbook wb = new HSSFWorkbook(is);
    	HSSFWorkbook wb = new HSSFWorkbook(fs);
        //get到Sheet对象  
        Sheet sheet = wb.getSheetAt(0);  
        //这个必须用接口  
        for(Row row : sheet){  
            for(Cell cell : row){  
                //cell.getCellType是获得cell里面保存的值的type  
                //如Cell.CELL_TYPE_STRING  
                switch(cell.getCellType()){  
                    case Cell.CELL_TYPE_BOOLEAN:  
                        //得到Boolean对象的方法  
                        System.out.print(cell.getBooleanCellValue()+" ");  
                        break;  
                    case Cell.CELL_TYPE_NUMERIC:  
                        //先看是否是日期格式  
                        if(DateUtil.isCellDateFormatted(cell)){  
                            //读取日期格式  
                            System.out.print(cell.getDateCellValue()+" ");  
                        }else{  
                            //读取数字  
                            System.out.print(cell.getNumericCellValue()+" ");  
                        }  
                        break;  
                    case Cell.CELL_TYPE_FORMULA:  
                        //读取公式  
                        System.out.print(cell.getCellFormula()+" ");  
                        break;  
                    case Cell.CELL_TYPE_STRING:  
                        //读取String  
                        System.out.print(cell.getRichStringCellValue().toString()+" ");  
                        break;                    
                }  
            }  
            System.out.println("");  
        }
//        Sheet sheet = wb.getSheetAt(0);  
//        for (Iterator rit = sheet.rowIterator(); rit.hasNext(); ) {  
//            Row row = (Row)rit.next();  
//            for (Iterator cit = row.cellIterator(); cit.hasNext(); ) {  
//                Cell cell = (Cell)cit.next();  
//                // Do something here  
//            }  
//        }  
//                        HSSFSheet sheet = wb.getSheetAt(0);  
//        for (Iterator<HSSFRow> rit = (Iterator<HSSFRow>)sheet.rowIterator(); rit.hasNext(); ) {  
//            HSSFRow row = rit.next();  
//            for (Iterator<HSSFCell> cit = (Iterator<HSSFCell>)row.cellIterator(); cit.hasNext(); ) {  
//                HSSFCell cell = cit.next();  
//                // Do something here  
//            }  
//        }  
    } 
    
    }
  

