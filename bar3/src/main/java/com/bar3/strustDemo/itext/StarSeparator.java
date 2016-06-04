/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.draw.DrawInterface;

public class StarSeparator implements DrawInterface {
    
    /** The font that will be used to draw the arrow. */
    protected BaseFont bf;
    
    public static final StarSeparator LINE = new StarSeparator();
    
    /**
     * Constructs a positioned Arrow mark.
     * @param    left    if true, an arrow will be drawn on the left;
     * otherwise, it will be drawn on the right.
     * @throws IOException 
     * @throws DocumentException 
     */
    public StarSeparator() {
        try {
            bf = BaseFont.createFont();
        } catch (DocumentException e) {
            bf = null;
        } catch (IOException e) {
            bf = null;
        }
    }
    
    /**
     * Draws three stars to separate two paragraphs.
     * @see com.itextpdf.text.pdf.draw.DrawInterface#draw(
     * com.itextpdf.text.pdf.PdfContentByte, float, float, float, float, float)
     */
    //四个参数依次表示画布实例，左边框，下边框，右边框和上边框的相对于左顶点的位移，y表示所在行在页面垂直方向的位置，该方法由系统调用并传值
    public void draw(PdfContentByte canvas,
        float llx, float lly, float urx, float ury, float y) {
        float middle = (llx + urx) / 2;
        canvas.beginText();
        canvas.setFontAndSize(bf, 10);
       //四个参数依次是对齐方式，画的内容，中心点x,y坐标，最后一个表示旋转的角度
        canvas.showTextAligned(Element.ALIGN_LEFT, "*  *", middle, y, 0);
        canvas.showTextAligned(Element.ALIGN_RIGHT, "*  *", middle, y -10, 0);
        canvas.endText();
    }

}
