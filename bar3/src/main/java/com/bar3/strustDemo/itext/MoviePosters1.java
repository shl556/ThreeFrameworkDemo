/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class MoviePosters1 {
    /** Path to the resulting PDF */
    public static final String RESULT
        = "results/movie_posters_1.pdf";
    /** Path to the resources. */
    public static final String RESOURCE = "resources/posters/%s.jpg";
    
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
        new MoviePosters1().createPdf(RESULT);
    }
    
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        
        // step 1
        Document document = new Document();
        // step 2
//        PdfWriter.getInstance(document, new FileOutputStream(filename));
        //setStrictImageSequence(true)方法会确保图片的顺序与文字的顺序严格一致，而不是默认的会为了确保页面中充足的内容而导致可能顺序问题
        PdfWriter.getInstance(document,
                new FileOutputStream(filename)).setStrictImageSequence(true);
        // step 3
        document.open();
        Rectangle rect = new Rectangle(0, 806, 36, 842);
        rect.setBackgroundColor(BaseColor.RED);
        document.add(rect);
        // step 4
        List<Movie> movies = PojoFactory.getMovies(connection);
        for (Movie movie : movies) {
            document.add(new Paragraph(movie.getMovieTitle()));
            // 添加图片
            document.add(
                Image.getInstance(String.format(RESOURCE, movie.getImdb())));
        }
        // step 5
        document.close();
        
        connection.close();
    }
}
