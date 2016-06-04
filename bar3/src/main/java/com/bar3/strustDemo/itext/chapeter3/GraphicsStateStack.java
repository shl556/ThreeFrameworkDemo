/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapeter3;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GraphicsStateStack {
    
    /** The resulting PDF. */
    public static final String RESULT
        = "results/part1/chapter03/graphics_state.pdf";

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
        Document document = new Document(new Rectangle(200, 120));
        // step 2
        PdfWriter writer
             = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfContentByte canvas = writer.getDirectContent();
        // 设置填充颜色
        canvas.setRGBColorFill(0xFF, 0x45, 0x00);
        // 四个参数是相对于左下角的x，y位移和图形的宽高
        canvas.rectangle(10, 10, 60, 60);
        //执行颜色填充过程
        canvas.fill();
        //设置绘画状态保存点1
        canvas.saveState();
        // state 2;
        //设置边框宽度
        canvas.setLineWidth(3);
        canvas.setRGBColorFill(0x8B, 0x00, 0x00);
//         fill and stroke a rectangle in state 2
        canvas.rectangle(40, 20, 60, 60);
        //填充并描边
        canvas.fillStroke();
        //设置绘画状态保存点2
//        canvas.saveState();
        // state 3:
        //设置图形的变形（旋转）
        canvas.concatCTM(1, 0, 0.1f, 1, 0, 0);
        //设置边框颜色
        canvas.setRGBColorStroke(0xFF, 0x45, 0x00);
        canvas.setRGBColorFill(0xFF, 0xD7, 0x00);
        // fill and stroke a rectangle in state 3
        canvas.rectangle(70, 30, 60, 60);
        canvas.fillStroke();
        //恢复画笔状态至上一个保存点2，在此之前必须调用saveState方法否则报异常.restoreState方法必须与saveState平衡，
        //数量对应
        canvas.restoreState();
        // stroke a rectangle in state 2
        canvas.rectangle(100, 40, 60, 60);
        //画边框
        canvas.stroke();
        canvas.fillStroke();
        //恢复画笔状态至上一个保存点1
//        canvas.restoreState();
        // fill and stroke a rectangle in state 1
        canvas.rectangle(130, 50, 60, 60);
        canvas.fillStroke();
        // step 5
        document.close();
    }
}
