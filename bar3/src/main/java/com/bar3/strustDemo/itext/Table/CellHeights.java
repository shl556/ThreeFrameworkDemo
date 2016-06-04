/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.Table;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CellHeights {
    /** The resulting PDF file. */
    public static final String RESULT = "results/part1/chapter04/cell_heights.pdf";

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args) throws DocumentException, IOException {
    	// step 1
        Document document = new Document(PageSize.A5.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfPTable table = new PdfPTable(2);
        // a long phrase
        Phrase p = new Phrase(
            "Dr. iText or: How I Learned to Stop Worrying and Love PDF.");
        PdfPCell cell = new PdfPCell(p);
        // the prhase is wrapped
        table.addCell("wrap");
        cell.setNoWrap(false);
        table.addCell(cell);
        // the phrase isn't wrapped
        table.addCell("no wrap");
        //禁用自动换行，多余的部分会超出单元格范围并且很可能无法完全显示
        cell.setNoWrap(true);
        table.addCell(cell);
        // a long phrase with newlines
        p = new Phrase(
            "Dr. iText or:\nHow I Learned to Stop Worrying\nand Love PDF.");
        cell = new PdfPCell(p);
        // the phrase fits the fixed height
        table.addCell("fixed height (more than sufficient)");
        cell.setFixedHeight(250f);
        table.addCell(cell);
        // the phrase doesn't fit the fixed height
        table.addCell("fixed height (not sufficient)");
        //当设计的固定高度不能满足内容文本需要的高度时，超过固定高度的文本内容不会被写入pdf文档中
        cell.setFixedHeight(250f);
        table.addCell(cell);
        //设置最小高度时itext会保证单元格的最小高度为指定值，当文本需要的高度大于最小高度时最自动调整行高度
        table.addCell("minimum height");
        cell = new PdfPCell(new Phrase("Dr. iText"));
        cell.setMinimumHeight(200f);
        table.addCell(cell);
        table.addCell("minimum height");
        cell = new PdfPCell(p);
        cell.setMinimumHeight(200f);
        table.addCell(cell);
        // 设为true时itext会自动加宽最后一行，使整个表格基本布满页面
//        table.setExtendLastRow(true);
//        table.addCell("extend last row");
//        table.addCell(cell);
//        table.setExtendLastRow(false);
        //第一个参数表明是否让最后一行自动加宽值页面下边距处，第二个参数表明当表格在当前页面无法完全显示时是否自动扩展至下一页
        table.setExtendLastRow(true,true);
        table.addCell("extend last row");
        table.addCell(cell);
        document.add(table);
        // step 5
        document.close();
    }
}