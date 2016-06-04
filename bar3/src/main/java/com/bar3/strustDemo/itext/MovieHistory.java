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
import java.util.Set;
import java.util.TreeSet;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.MovieComparator;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.PojoToElementFactory;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;

public class MovieHistory {

    /** The resulting PDF file. */
    public static final String RESULT = "results/movie_history.pdf";
    
    /** The different epochs. */
    public static final String[] EPOCH =
        { "Forties", "Fifties", "Sixties", "Seventies", "Eighties",
          "Nineties", "Twenty-first Century" };
    /** The fonts for the title. */
    public static final Font[] FONT = new Font[4];
    static {
        FONT[0] = new Font(FontFamily.HELVETICA, 24);
        FONT[1] = new Font(FontFamily.HELVETICA, 18);
        FONT[2] = new Font(FontFamily.HELVETICA, 14);
        FONT[3] = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
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
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        Set<Movie> movies = 
            new TreeSet<Movie>(new MovieComparator(MovieComparator.BY_YEAR));
        movies.addAll(PojoFactory.getMovies(connection));
        int epoch = -1;
        int currentYear = 0;
        Paragraph title = null;
        Chapter chapter = null;
        Section section = null;
        Section subsection = null;
        // loop over the movies
        for (Movie movie : movies) {
            // add the chapter if we're in a new epoch
            if (epoch < (movie.getYear() - 1940) / 10) {
                epoch = (movie.getYear() - 1940) / 10;
                if (chapter != null) {
                    document.add(chapter);
                }
                title = new Paragraph(EPOCH[epoch], FONT[0]);
                chapter = new Chapter(title, epoch + 1);
            }
            // switch to a new year
            if (currentYear < movie.getYear()) {
                currentYear = movie.getYear();
                title = new Paragraph(
                    String.format("The year %d", movie.getYear()), FONT[1]);
                //增加节点
                section = chapter.addSection(title);
                //设置该节点的书签
                section.setBookmarkTitle(String.valueOf(movie.getYear()));
                //设置该节点的缩进
                section.setIndentation(30);
                //设置书签的状态为关闭
                section.setBookmarkOpen(false);
                //设置数字的风格
                section.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);
                section.add(new Paragraph(
                    String.format("Movies from the year %d:", movie.getYear())));
            }
            title = new Paragraph(movie.getMovieTitle(), FONT[2]);
            subsection = section.addSection(title);
            subsection.setIndentationLeft(20);
            subsection.setNumberDepth(1);
            subsection.add(new Paragraph("Duration: " + movie.getDuration(), FONT[3]));
            subsection.add(new Paragraph("Director(s):", FONT[3]));
            subsection.add(PojoToElementFactory.getDirectorList(movie));
            subsection.add(new Paragraph("Countries:", FONT[3]));
            subsection.add(PojoToElementFactory.getCountryList(movie));
        }
        document.add(chapter);
        // step 5
        document.close();
        connection.close();
    }
}
