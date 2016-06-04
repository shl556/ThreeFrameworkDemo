/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello World: document constructor.
 */
public class HelloWorldNarrow {

    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "results/hello_narrow.pdf";
    
    /**
     * Creates a PDF file: hello_narrow.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
         throws DocumentException, IOException {
        // step 1
    	// 指定页面大小和页边距
//        Rectangle pagesize = new Rectangle(300f, 200f);
        //采用标准页面大小,rotate()方法表示横向打印
//        Rectangle pagesize=new Rectangle(PageSize.A4.rotate());
//        Document document = new Document(pagesize, 50f, 50f, 100f, 100f);
//        Document document = new Document(pagesize);
        Document document=new Document();
       //在程序运行的过程中可以随时调用该方法改变页面大小和页边距但是不会影响当前页，只会影响下一页
        document.setPageSize(PageSize.A4);
        document.setMargins(50, 50,100,100);
        document.setMarginMirroring(true);
        // step 2
        PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // 完成相关资源的初始化
        document.open();
        //显示设置pdf版本
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
        //获取画布
        PdfContentByte canvas = writer.getDirectContentUnder();
        //禁用压缩，方便调试，生产环境下应恢复默认值
        writer.setCompressionLevel(0);
        //通过添加Phrase或者Paragraph或者在canvas操作三种的最终生成的PDF在PDFviewer下是一样的，但是通过text编辑器打开却稍微不一样
        //即使同一份代码生成两份PDF文档，在Text编辑器下也会轻微的不同
        Phrase hello = new Phrase("Hello World"+"Hello Sky! Hello Sun! Hello Moon! Hello Stars!");
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
            hello, 36, 788, 0);
//        canvas.saveState();                               // q
//        canvas.beginText(); 
//        //设置起始坐标，相对于左顶点的x，y的平移量
//        canvas.moveText(36, 400);                         // 36 788 Td
//        canvas.setFontAndSize(BaseFont.createFont(), 12); // /F1 12 Tf
//        canvas.showText("Hello World"+"Hello Sky! Hello Sun! Hello Moon! Hello Stars!");                   // (Hello World)Tj
//        canvas.endText();                                 // ET
//        canvas.restoreState();    
        // step 4
//        document.add(new Paragraph(
//            "Hello World! Hello People! " +
//            "Hello Sky! Hello Sun! Hello Moon! Hello Stars!"));
//        // outputStream由writer方法负责关闭,当输出完毕会自动关闭
        document.close();
    }
}
