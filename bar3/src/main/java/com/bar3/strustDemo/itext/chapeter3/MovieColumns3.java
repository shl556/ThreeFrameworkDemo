/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapeter3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;

public class MovieColumns3 extends MovieColumns1 {

    /** The resulting PDF file. */
    public static final String RESULT = "results/part1/chapter03/movie_columns3.pdf";
    
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
        // Create a database connection
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer
            = PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        List<Movie> movies = PojoFactory.getMovies(connection);
        ColumnText ct = new ColumnText(writer.getDirectContent());
        int column = 0;
        ct.setSimpleColumn(
            COLUMNS[column][0], COLUMNS[column][1],
            COLUMNS[column][2], COLUMNS[column][3]);
        int status = ColumnText.START_COLUMN;
        Phrase p;
        float y;
        for (Movie movie : movies) {
            y = ct.getYLine();
            p = createMovieInformation(movie);
            ct.addText(p);
            //go(true)方法是模拟写入，相关的文本内容也会被消耗，但没有实际写入，
             //通过模拟可以确保同一个段落不会被分割成两个页面
            status = ct.go(true);
            if (ColumnText.hasMoreText(status)) {
                column = Math.abs(column - 1);
                if (column == 0)
                    document.newPage();
                ct.setSimpleColumn(
                    COLUMNS[column][0], COLUMNS[column][1],
                    COLUMNS[column][2], COLUMNS[column][3]);
                y = COLUMNS[column][3];
            }
            //如果模拟写入后发现能够在一个文本框内写完就需要回到起始位置，真正开始写入
            ct.setYLine(y);
            //setText方法会从内存中移除已经写入的内容，避免同一内容写两次，
            ct.setText(p);
            status = ct.go(false);
        }
        // step 5
        document.close();
        // Close the database connection
        connection.close();
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
        new MovieColumns3().createPdf(RESULT);
    }
}
