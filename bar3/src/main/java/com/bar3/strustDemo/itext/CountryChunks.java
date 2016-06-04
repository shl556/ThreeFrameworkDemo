/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Writes a list of countries to a PDF file.
 */
public class CountryChunks {

    /** The resulting PDF file. */
    public static final String RESULT
        = "results/country_chunks.pdf";

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
        new CountryChunks().createPdf(RESULT);
    }

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException{
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename))
        //设置行间距  
        .setInitialLeading(16);
        // step 3
        document.open();
        // step 4
        // database connection and statement
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT country, id FROM film_country ORDER BY country");
        // add the ID in another font
        Font font = new Font(FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
        while (rs.next()) {
        	//Chunk是添加到document中的最小单位，一个Chunk相当于一个字符串
            document.add(new Chunk(rs.getString("country")));
            document.add(new Chunk("< 1 > "));
            Chunk id = new Chunk(rs.getString("id"), font);
            //设置背景色，后面的四个值是其范围，相对于字体本身
            id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
            //设置字体相对于基准行的向上偏移量
            id.setTextRise(8);
            document.add(id);
            //表示换行
            document.add(Chunk.NEWLINE);
        }
        stm.close();
        connection.close();
        // step 5
        document.close();
    }
}
