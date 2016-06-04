/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Writing one PDF file to a ZipOutputStream.
 */
public class HelloZip {
    
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "results/hello.zip";
    
    /**
     * Creates a zip file with five PDF documents:
     * hello1.pdf to hello5.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
        throws DocumentException, IOException {
    	// creating a zip file with different PDF documents
        ZipOutputStream zip =
            new ZipOutputStream(new FileOutputStream(RESULT));
        for (int i = 1; i <= 3; i++) {
            //将待压缩的实体转换成流对象
        	ZipEntry entry = new ZipEntry("hello_" + i + ".pdf");
            zip.putNextEntry(entry);
            // step 1
            Document document = new Document();
            //将生成的PDF文档输出成zip压缩文件
            PdfWriter writer = PdfWriter.getInstance(document, zip);
            //为了防止writer在输出完毕自动关闭输出流应该设置自动关闭为true，等zip调用closeEntry()后才能关闭，否则报错stream close
            writer.setCloseStream(false);
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Hello " + i));
            // step 5
            document.close();
            
            zip.closeEntry();
        }
        zip.close();
    }
}
