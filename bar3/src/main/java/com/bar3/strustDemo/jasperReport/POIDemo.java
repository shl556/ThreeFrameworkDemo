package com.bar3.strustDemo.jasperReport;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class POIDemo {
	/*
	 * HSSF 是Horrible SpreadSheet
	 * Format的缩写，通过HSSF，你可以用纯Java代码来读取、写入、修改Excel文件。HSSF 为读取操作提供了两类API：
	 * usermodel和eventusermodel，即“用户模型”和“事件-用户模型”。
	 * 
	 * HSSFWorkbook excel文档对象;HSSFSheet excel的sheet即单个工作簿 HSSFRow excel的行 ;
	 * HSSFCell excel的单元格;HSSFFont excel字体 ; HSSFName 名称;HSSFDataFormat 日期格式
	 * ;HSSFHeader sheet头 ; HSSFFooter sheet尾 ; HSSFCellStyle cell样式
	 * ;HSSFDateUtil 日期 ; HSSFPrintSetup 打印 ;HSSFErrorConstants 错误信息表;
	 * 
	 * 1.得到Excel常用对象   
	 * POIFSFileSystem fs=newPOIFSFileSystem(new FileInputStream("d:/test.xls"));
	 *  //得到Excel工作簿对象 
	 *  HSSFWorkbook wb = new HSSFWorkbook(fs);
	 *  //设置sheet名称
	 *  wb.setSheetName(1, "第一张工作表",HSSFCell.ENCODING_UTF_16);    
	 *  //得到sheet的数目
	 *  wb.getNumberOfSheets()
	 *  //根据index得到指定序列的Excel工作表对象
	 *  HSSFSheet sheet = wb.getSheetAt(0);
	 *  //获得该sheet中的有效行数
	 *  int rowcount = sheet.getLastRowNum(); 
	 *  //设置列宽
	 *  sheet.setColumnWidth((short)column,(short)width);    
	 * //得到Excel工作表的行 
	 * HSSFRow row = sheet.getRow(i); 
	 * 获取一行中有效单元格个数
	 * row.getLastCellNum(); 
	 * 设置行高
	 * row.setHeight((short)height);       
	 * //得到Excel工作表指定行的单元格
	 * HSSFCell cell = row.getCell((short) j);
	 * //设置单元格为STRING类型   
     * cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
     * //读取为数值类型的单元格内容   
     * cell.getNumericCellValue();
	 * //得到单元格样式
	 * cellStyle =cell.getCellStyle();
	 * 
	 * 
	 * 2.建立Excel常用对象
     * HSSFWorkbook wb = new HSSFWorkbook();//创建Excel工作簿对象   
     * HSSFSheet sheet = wb.createSheet("new sheet");//创建Excel工作表对象     
     * HSSFRow row = sheet.createRow((short)0); //创建Excel工作表的行   
     *  cellStyle = wb.createCellStyle();//创建单元格样式   
     * row.createCell((short)0).setCellStyle(cellStyle); //创建Excel工作表指定行的单元格   
     * row.createCell((short)0).setCellValue(1); //设置Excel工作表的值  
	 * 保存excel文件
	 * FileOutputStream fileOut = new FileOutputStream(path);   
	 * wb.write(fileOut); 
	 *  
	 * 3、合并单元格
	 * //合并从第rowFrom行columnFrom列到rowTo行columnTo的区域
     * Region region = new Region((short)rowFrom,(short)columnFrom,(short)rowTo  
     * ,(short)columnTo);  
     * sheet.addMergedRegion(region);     
     * //得到所有区域       
     * sheet.getNumMergedRegions() 
     * 
     * 4.常用单元格边框样式
     * HSSFCellStyle style = wb.createCellStyle();  
     * style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);//下边框   
     * style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);//左边框      
     * style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框     
     * style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框   
     * 
     * 5.设置字体大小及样式
     * 
    HSSFFont f  = wb.createFont();      
    f.setFontHeightInPoints((short) 11);//字号       
    f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗       
    style.setFont(f);      
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中       
    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中       
    style.setRotation(short rotation);//单元格内容的旋转的角度       
    HSSFDataFormat df = wb.createDataFormat();      
    style1.setDataFormat(df.getFormat("0.00%"));//设置单元格数据格式       
    cell.setCellFormula(string);//给单元格设公式       
    style.setRotation(short rotation);//单元格内容的旋转的角度   
     * 
     * 
     * 15、插入图片
     * 
     * //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray       
      ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();      
      BufferedImage bufferImg = ImageIO.read(new File("ok.jpg"));      
      ImageIO.write(bufferImg,"jpg",byteArrayOut);      
      //读进一个excel模版       
      FileInputStream fos = new FileInputStream(filePathName+"/stencil.xlt");       
      fs = new POIFSFileSystem(fos);      
      //创建一个工作薄       
       HSSFWorkbook wb = new HSSFWorkbook(fs);      
       HSSFSheet sheet = wb.getSheetAt(0);      
       HSSFPatriarch patriarch = sheet.createDrawingPatriarch();      
        HSSFClientAnchor anchor = new HSSFClientAnchor(0,0,1023,255,(short) 0,0,(short)10,10);           
       patriarch.createPicture(anchor , wb.addPicture(byteArrayOut.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG));
      *
      *
      *调整工作表位置
      *
    HSSFWorkbook wb = new HSSFWorkbook();     
    HSSFSheet sheet = wb.createSheet("format sheet");     
    HSSFPrintSetup ps = sheet.getPrintSetup();     
    sheet.setAutobreaks(true);     
    ps.setFitHeight((short)1);     
    ps.setFitWidth((short)1); 
    
      *
      *
      *设置打印区域
    HSSFSheet sheet = wb.createSheet("Sheet1");     
    wb.setPrintArea(0, "$A$1:$C$2");  
    
      *
      *标注脚注
      *HSSFSheet sheet = wb.createSheet("format sheet");     
       HSSFFooter footer = sheet.getFooter()     
       footer.setRight( "Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages() ); 
      *
      *
      *在工作单中清空行数据，调整行位置
     HSSFWorkbook wb = new HSSFWorkbook();     
     HSSFSheet sheet = wb.createSheet("row sheet");     
     // Create various cells and rows for spreadsheet.      
     // Shift rows 6 - 11 on the spreadsheet to the top (rows 0 - 5)      
     sheet.shiftRows(5, 10, -5);
     
      *
      *工作表的放大缩小
      *
    HSSFSheet sheet1 = wb.createSheet("new sheet");     
    sheet1.setZoom(1,2);   // 50 percent magnification    
    
    *
    *头注
    *HSSFSheet sheet = wb.createSheet("new sheet");     
     HSSFHeader header = sheet.getHeader();     
     header.setCenter("Center Header");     
     header.setLeft("Left Header");     
     header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +     
     HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16"); 
	 *
	 *填充和颜色设置
    HSSFCellStyle style = wb.createCellStyle();     
    style.setFillForegroundColor(HSSFColor.LIME.index);     
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);     
    HSSFFont font = wb.createFont();     
    font.setColor(HSSFColor.RED.index);     
    style.setFont(font);     
    cell.setCellStyle(style);     
	 *
	 *
	 *
	 */
	
	public static void test() {
	}
	//根据单元格不同属性返回字符串数值
    public String getCellStringValue(HSSFCell cell) {      
            String cellValue = "";      
            switch (cell.getCellType()) {      
            case HSSFCell.CELL_TYPE_STRING://字符串类型   
                cellValue = cell.getStringCellValue();      
                if(cellValue.trim().equals("")||cellValue.trim().length()<=0)      
                    cellValue=" ";      
                break;      
            case HSSFCell.CELL_TYPE_NUMERIC: //数值类型   
                cellValue = String.valueOf(cell.getNumericCellValue());      
                break;      
            case HSSFCell.CELL_TYPE_FORMULA: //公式   
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);      
                cellValue = String.valueOf(cell.getNumericCellValue());      
                break;      
            case HSSFCell.CELL_TYPE_BLANK:      
                cellValue=" ";      
                break;      
            case HSSFCell.CELL_TYPE_BOOLEAN:      
                break;      
            case HSSFCell.CELL_TYPE_ERROR:      
                break;      
            default:      
                break;      
            }      
            return cellValue;      
        }     
	public static void main(String[] args) {
	}
}
