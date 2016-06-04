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
import com.bar3.strutsDemo.itext.database.FilmFonts;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.PojoToElementFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MoviePosters3 {
    /** Path to the resulting PDF */
    public static final String RESULT
        = "results/movie_posters_3.pdf";
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
        new MoviePosters3().createPdf(RESULT);
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
    	// Create a database connection
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer =
            PdfWriter.getInstance(document, new FileOutputStream(filename));
        writer.setStrictImageSequence(true);
        writer.setInitialLeading(18);
        // step 3
        document.open();
        // step 4
        List<Movie> movies = PojoFactory.getMovies(connection);
        for (Movie movie : movies) {
        	// Create an image
            Image img = Image.getInstance(String.format(RESOURCE, movie.getImdb()));
            //设置对齐方式
            img.setAlignment(Image.LEFT | Image.TEXTWRAP);
            //设置边框
            img.setBorder(Image.BOX);
            //设置边框宽度
            img.setBorderWidth(10);
            //设置边框颜色
            img.setBorderColor(BaseColor.WHITE);
            //设置缩略图大小,宽度设为1000可以确保生成的缩略图的高度为72，宽度由图片本身的宽高比决定
            img.scaleToFit(1000, 72);
            document.add(img);
            // Create text elements
            document.add(new Paragraph(movie.getMovieTitle(), FilmFonts.BOLD));
            document.add(PojoToElementFactory.getCountryList(movie));
            document.add(new Paragraph(String.format("Year: %d", movie.getYear())));
            document.add(new Paragraph(
                String.format("Duration: %d minutes", movie.getDuration())));
            document.add(new Paragraph("Directors:"));
            document.add(PojoToElementFactory.getDirectorList(movie));
            document.add(Chunk.NEWLINE);
        }
        // step 5
        document.close();
        // Close the database connection
        connection.close();
    }
}
