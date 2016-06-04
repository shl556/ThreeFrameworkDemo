/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;

/**
 * Writes a list of directors to a PDF file.
 */
public class DirectorPhrases2 extends DirectorPhrases1 {
    
    /** The resulting PDF file. */
    public static final String RESULT = "results/director_phrases_2.pdf";

    /** A font that will be used in our PDF. */
    public static final Font BOLD;
    /** A font that will be used in our PDF. */
    public static final Font NORMAL;
    
    static {
        BaseFont timesbd = null;
        BaseFont times = null;
        try {
            //根据系统自带的字体文件显示加载一个指定的字体
        	//应该避免使用Itext自带的字体，该字体会在显示时由PDF阅读器替换成平台所安装的字体，容易造成因不同字体编码导致的某些字符无法显示的问题
        	//因此应该显示指定并设置所有的字体
            timesbd = BaseFont.createFont(
            		//此方法不支持宋体，楷体等中文字体
//                "C:/Program Files/Java/jre7/lib/fonts/simsun.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
            "C:/Program Files/Java/jre7/lib/fonts/ariblk.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
            // create a font that will be embedded
            times = BaseFont.createFont(
                "C:/Program Files/Java/jre7/lib/fonts/ariblk.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        BOLD = new Font(timesbd, 12);
        NORMAL = new Font(times, 12);
    }
    
    /**
     * Creates a Phrase with the name and given name of a director using different fonts.
     * @param    rs    the ResultSet containing director records.
     */
    public Phrase createDirectorPhrase(ResultSet rs)
        throws UnsupportedEncodingException, SQLException {
        Phrase director = new Phrase();
        Chunk name = new Chunk(new String(rs.getBytes("name"), "UTF-8"), BOLD);
        //设置下划线，第一个参数是表示粗细，第二个参数表示相对于字体下面的垂直位移
        name.setUnderline(1f, -10f);
        director.add(name);
        //微软雅黑字体不支持汉字，即使设置了汉字也不显示
        director.add(new Chunk(",sunhonglaing", BOLD));
        director.add(new Chunk("shabi", NORMAL));
        director.add(
            new Chunk(new String(rs.getBytes("given_name"), "UTF-8"), NORMAL));
        //显示设置间距
        director.setLeading(24);
        return director;
    }
    
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args)
        throws IOException, DocumentException, SQLException {
        new DirectorPhrases2().createPdf(RESULT);
    }
}
