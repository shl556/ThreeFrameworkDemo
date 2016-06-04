/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapeter3;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;

public class FoobarFilmFestival {

    public static final String RESULT
        = "results/part1/chapter03/foobar_film_festival.pdf";

    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter writer
            = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        Chunk c;
        String foobar = "Foobar Film Festival";
        // Measuring a String in Helvetica
        Font helvetica = new Font(FontFamily.HELVETICA, 12);
        //通过BaseFont实例计算字符串宽度
        BaseFont bf_helv = helvetica.getCalculatedBaseFont(false);
        float width_helv = bf_helv.getWidthPoint(foobar, 12);
        c = new Chunk(foobar + ": " + width_helv, helvetica);
        document.add(new Paragraph(c));
        //调用Chunk的getWidthPoint方法返回字符串的宽度
        document.add(new Paragraph(String.format("Chunk width: %f", c.getWidthPoint())));
        // Measuring a String in Times
        BaseFont bf_times = BaseFont.createFont(
            "c:/windows/fonts/times.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
        Font times = new Font(bf_times, 12);
        float width_times = bf_times.getWidthPoint(foobar, 12);
        c = new Chunk(foobar + ": " + width_times, times);
        document.add(new Paragraph(c));
        document.add(new Paragraph(String.format("Chunk width: %f", c.getWidthPoint())));
        document.add(Chunk.NEWLINE);
        //getAscentPoint返回该字符串相对于基准线向上的偏移量，具体而言相当于字母的高度 
        document.add(new Paragraph("Ascent Helvetica: "
                + bf_helv.getAscentPoint(foobar, 12)));
        document.add(new Paragraph("Ascent Times: "
                + bf_times.getAscentPoint(foobar, 12)));
        //getDescentPoint返回该字符串相对于基准线向下的偏移量，具体而言就是g,j,p等字母向下偏移的距离。向上的偏移量减去向下的偏移量
        //即可得到该字符串的高度，该高度不等于字体大小
        document.add(new Paragraph("Descent Helvetica: "
                + bf_helv.getDescentPoint(foobar, 12)));
        document.add(new Paragraph("Descent Times: "
                + bf_times.getDescentPoint(foobar, 12)));
        document.add(Chunk.NEWLINE);
        //获取字符串的总字符间距
        width_helv = bf_helv.getWidthPointKerned(foobar, 12);
        c = new Chunk(foobar + ": " + width_helv, helvetica);
        document.add(new Paragraph(c));
        // Drawing lines to see where the text is added
        PdfContentByte canvas = writer.getDirectContent();
        canvas.saveState();
        canvas.setLineWidth(0.05f);
        canvas.moveTo(400, 806);
        canvas.lineTo(400, 626);
        canvas.moveTo(508.7f, 806);
        canvas.lineTo(508.7f, 626);
        canvas.moveTo(280, 788);
        canvas.lineTo(520, 788);
        canvas.moveTo(280, 752);
        canvas.lineTo(520, 752);
        canvas.moveTo(280, 716);
        canvas.lineTo(520, 716);
        canvas.moveTo(280, 680);
        canvas.lineTo(520, 680);
        canvas.moveTo(280, 644);
        canvas.lineTo(520, 644);
        canvas.stroke();
        canvas.restoreState();
        // Adding text with PdfContentByte.showTextAligned()
        canvas.beginText();
        canvas.setFontAndSize(bf_helv, 12);
        //最后三个参数是相对于左下角的x，y位移及字符串的旋转角度
        //左对齐是字符串的左边对齐400
        canvas.showTextAligned(Element.ALIGN_LEFT, foobar, 400, 788, 0);
        //右对齐是字符串的右边对齐400
        canvas.showTextAligned(Element.ALIGN_RIGHT, foobar, 400, 752, 0);
        //居中是字符串的中间对齐400
        canvas.showTextAligned(Element.ALIGN_CENTER, foobar, 400, 716, 0);
        canvas.showTextAligned(Element.ALIGN_CENTER, foobar, 400, 680, 30);
        canvas.showTextAlignedKerned(Element.ALIGN_LEFT, foobar, 400, 644, 0);
        canvas.endText();
        // More lines to see where the text is added
        canvas.saveState();
        canvas.setLineWidth(0.05f);
        canvas.moveTo(200, 590);
        canvas.lineTo(200, 410);
        canvas.moveTo(400, 590);
        canvas.lineTo(400, 410);
        canvas.moveTo(80, 572);
        canvas.lineTo(520, 572);
        canvas.moveTo(80, 536);
        canvas.lineTo(520, 536);
        canvas.moveTo(80, 500);
        canvas.lineTo(520, 500);
        canvas.moveTo(80, 464);
        canvas.lineTo(520, 464);
        canvas.moveTo(80, 428);
        canvas.lineTo(520, 428);
        canvas.stroke();
        canvas.restoreState();
        // Adding text with ColumnText.showTextAligned()
        Phrase phrase = new Phrase(foobar, times);
        //ColumnText.showTextAligned方法不需要beginText，endText等操作
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 200, 572, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, 200, 536, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 500, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 464, 30);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 428, -30);
        // Chunk attributes
        c = new Chunk(foobar, times);
        //设置压缩字符串，即压缩字符间距和字符大小，正常是1，不压缩
        c.setHorizontalScaling(0.5f);
        phrase = new Phrase(c);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 400, 572, 0);
        c = new Chunk(foobar, times);
        //设置旋转角度和斜体角度
//        c.setSkew(15, 15);
        c.setSkew(0, 15);
        phrase = new Phrase(c);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 400, 536, 0);
        c = new Chunk(foobar, times);
        c.setSkew(0, 25);
        phrase = new Phrase(c);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 400, 500, 0);
        c = new Chunk(foobar, times);
        //设置字体描边效果，第一个参数是字体渲染方式，第二参数是字体的粗细，第三个是颜色
        c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, (float)1.5, BaseColor.RED);
        phrase = new Phrase(c);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 400, 464, 0);
        c = new Chunk(foobar, times);
        //设置加粗效果
        c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 1, null);
        phrase = new Phrase(c);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 400, 428, -0);
        // step 5
        document.close();
    }
}
