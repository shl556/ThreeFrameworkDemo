/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.Table;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bar3.strutsDemo.itext.database.Country;
import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.Director;
import com.bar3.strutsDemo.itext.database.FilmFonts;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.PojoToElementFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class MovieTextMode {

    /** The resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter04/movie_text_mode.pdf";
    
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
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Movies:"));
        List<Movie> movies = PojoFactory.getMovies(connection);
        for (Movie movie : movies) {
            PdfPTable table = new PdfPTable(2);
            table.setWidths(new int[]{1, 4});
            PdfPCell cell;
            //设置标题
            cell = new PdfPCell(new Phrase(movie.getTitle(), FilmFonts.BOLD));
            //设置水平方向的对齐方式
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //设置该单元格为合并两列的单元格
            cell.setColspan(2);
            table.addCell(cell);
            //设置原名
            if (movie.getOriginalTitle() != null) {
                cell = new PdfPCell(PojoToElementFactory.getOriginalTitlePhrase(movie));
                cell.setColspan(2);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
            }
            //设置导演
            List<Director> directors = movie.getDirectors();
            cell = new PdfPCell(new Phrase("Directors:"));
            //设置该单元格为合并指定行的单元格
            cell.setRowspan(directors.size());
            //设置垂直方向上的对齐方式
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
            int count = 0;
            for (Director pojo : directors) {
                cell = new PdfPCell(PojoToElementFactory.getDirectorPhrase(pojo));
                cell.setIndent(10 * count++);
                table.addCell(cell);
            }
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell("Year:");
            table.addCell(String.valueOf(movie.getYear()));
            table.addCell("Run length:");
            table.addCell(String.valueOf(movie.getDuration()));
            List<Country> countries = movie.getCountries();
            cell = new PdfPCell(new Phrase("Countries:"));
            cell.setRowspan(countries.size());
            cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            table.addCell(cell);
            //可以通过new PdfPCell()方法创建一个新的cell对象，也可以通过table实例的getDefaultCell方法获得cell实例，
            //该实例由table实例负责创建和维护
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            for (Country country : countries) {
                table.addCell(country.getCountry());
            }
            document.add(table);
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
        new MovieTextMode().createPdf(RESULT);
    }
}
