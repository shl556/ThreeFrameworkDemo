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
import com.bar3.strutsDemo.itext.database.Director;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;

public class MovieLists2 {

    /** The resulting PDF file. */
    public static final String RESULT = "results/movie_lists_2.pdf";
    
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        // Create a database connection and statement
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT DISTINCT mc.country_id, c.country, count(*) AS c "
            + "FROM film_country c, film_movie_country mc WHERE c.id = mc.country_id "
            + "GROUP BY mc.country_id, country ORDER BY c DESC");
        // Create a list
        List list = new List();
        //设置自动缩进为false，设为false后必须显示设置缩进，否则会出现文本重叠
        list.setAutoindent(false);
        //设置序列符号缩进为36
        list.setSymbolIndent(36);
        
        // Loop over the countries
        while (rs.next()) {
            // Create a list item for a country
            ListItem item = new ListItem(
               String.format("%s: %d movies", rs.getString("country"), rs.getInt("c")));
            //设置序列的序列号，默认为数字
            item.setListSymbol(new Chunk(rs.getString("country_id")));
            // Create a list for the movies produced in the current country
            List movielist = new List(List.ORDERED, List.ALPHABETICAL);
//            movielist.setAlignindent(false);
            for(Movie movie :
                PojoFactory.getMovies(connection, rs.getString("country_id"))) {
                ListItem movieitem = new ListItem(movie.getMovieTitle());
                List directorlist = new List(List.ORDERED);
                //默认的序列号为数字，setPreSymbol为数字前面的部分，setPostSymbol为数字后面的部分
                directorlist.setPreSymbol("Director ");
                directorlist.setPostSymbol(": ");
                for (Director director : movie.getDirectors()) {
                    directorlist.add(
                        String.format("%s, %s", director.getName(), director.getGivenName()));
                }
                movieitem.add(directorlist);
                movielist.add(movieitem);
            }
            item.add(movielist);
            list.add(item);
        }
        document.add(list);
        // Close the statement and database connection
        stm.close();
        connection.close();
        // step 5
        document.close();
    }
    
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, DocumentException, SQLException {
        new MovieLists2().createPdf(RESULT);
    }
}
