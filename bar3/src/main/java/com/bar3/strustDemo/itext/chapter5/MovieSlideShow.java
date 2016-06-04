/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapter5;

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
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTransition;
import com.itextpdf.text.pdf.PdfWriter;

public class MovieSlideShow {
    /** The resulting PDF file. */
    public static final String RESULT = "results/part1/chapter05/movie_slides.pdf";
    /** Path to the resources. */
    public static final String RESOURCE = "resources/posters/%s.jpg";
    
    
    /**
     * Page event to set the transition and duration for every page.
     */
    class TransitionDuration extends PdfPageEventHelper {
   
        public void onStartPage(PdfWriter writer, Document document) {
            //该效果在全屏的模式下可以像幻灯平一样播放PDF文档
        	//指定切换方式，第二个参数是转换操作的时间
        	writer.setTransition(new PdfTransition(PdfTransition.DISSOLVE, 3));
            //指定图片展示时间
        	writer.setDuration(5);
        }
        
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
        Document document = new Document(PageSize.A5.rotate());
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        writer.setPdfVersion(PdfWriter.VERSION_1_5);
        writer.setViewerPreferences(PdfWriter.PageModeFullScreen);
        writer.setPageEvent(new TransitionDuration());
        // step 3
        document.open();
        // step 4
        List<Movie> movies = PojoFactory.getMovies(connection);
        Image img;
        PdfPCell cell;
        PdfPTable table = new PdfPTable(6);
        for (Movie movie : movies) {
            img = Image.getInstance(String.format(RESOURCE, movie.getImdb()));
            cell = new PdfPCell(img, true);
            cell.setBorder(PdfPCell.NO_BORDER);
            table.addCell(cell);
        }
        document.add(table);
        // step 5
        document.close();
        // Close the database connection
        connection.close();
    }
    
    /**
     * Main method creating the PDF.
     * @param    args    no arguments needed
     * @throws IOException 
     * @throws DocumentException 
     * @throws SQLException
     */
    public static void main(String[] args)
        throws IOException, SQLException, DocumentException {
        new MovieSlideShow().createPdf(RESULT);
    }
}
