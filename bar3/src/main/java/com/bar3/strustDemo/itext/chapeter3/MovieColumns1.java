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

import com.bar3.strutsDemo.itext.database.Country;
import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.Director;
import com.bar3.strutsDemo.itext.database.FilmFonts;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.PojoToElementFactory;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class MovieColumns1 {

    /** The resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter03/movie_columns1.pdf";
    
    /** Definition of two columns */
    public static final float[][] COLUMNS = {
        { 36, 36, 296, 806 } , { 299, 36, 559, 806 }
    };
    
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
        //将文本值写入缓存，但没有写入实际的PDF中
        for (Movie movie : movies) {
            ct.addText(createMovieInformation(movie));
            ct.addText(Chunk.NEWLINE);
        }
        //设置对齐方式,ALIGN_JUSTIFIED与左对齐的区别是，左对齐不会调整字符间距，可能一行后面有空格，而ALIGN_JUSTIFIED
        //会调整字符间距
        ct.setAlignment(Element.ALIGN_JUSTIFIED);
        //设置段落间距
        ct.setExtraParagraphSpace(12);
        //设置行间距,第一个参数为fixedLeading，第二个参数为multipliedLeading
        //实际行间距计算公式为fixedLeading+multipliedLeading*maxFontSize，maxFontSize为该行字符串的最大字体大小
        ct.setLeading(1, 1.2f);
        //设置缩进
        ct.setFollowingIndent(5);
        //设置字符间距
        ct.setSpaceCharRatio(PdfWriter.SPACE_CHAR_RATIO_DEFAULT);
        int linesWritten = 0;
        int column = 0;
        //文本写入的状态，START_COLUMN表示开始写入，实际值为0，NO_MORE_COLUMN表示没有多余的单元格空间，
        //NO_MORE_TEXT表示没有待写入的文本了
        int status = ColumnText.START_COLUMN;
        while (ColumnText.hasMoreText(status)) {
            ct.setSimpleColumn(
                    COLUMNS[column][0], COLUMNS[column][1],
                    COLUMNS[column][2], COLUMNS[column][3]);
            ct.setYLine(COLUMNS[column][3]);
            //获取写入的状态，go（）方法会自动移动到指定的区域，执行实际的写入操作
            status = ct.go();
            System.out.println("status:"+status);
            //获取写入的行数
            linesWritten += ct.getLinesWritten();
            System.out.println("linesWritten:"+linesWritten);
            column = Math.abs(column - 1);
            if (column == 0)
                document.newPage();
        }
        
        ct.addText(new Phrase("Lines written: " + linesWritten));
        ct.go();
        // step 5
        document.close();
        // Close the database connection
        connection.close();
    }
    
    /**
     * Creates a Phrase containing information about a movie.
     * @param    movie    the movie for which you want to create a Paragraph
     */
    public Phrase createMovieInformation(Movie movie) {
        Phrase p = new Phrase();
        p.setFont(FilmFonts.NORMAL);
        p.add(new Phrase("Title: ", FilmFonts.BOLDITALIC));
        p.add(PojoToElementFactory.getMovieTitlePhrase(movie));
        p.add(" ");
        if (movie.getOriginalTitle() != null) {
            p.add(new Phrase("Original title: ", FilmFonts.BOLDITALIC));
            p.add(PojoToElementFactory.getOriginalTitlePhrase(movie));
            p.add(" ");
        }
        p.add(new Phrase("Country: ", FilmFonts.BOLDITALIC));
        for (Country country : movie.getCountries()) {
            p.add(PojoToElementFactory.getCountryPhrase(country));
            p.add(" ");
        }
        p.add(new Phrase("Director: ", FilmFonts.BOLDITALIC));
        for (Director director : movie.getDirectors()) {
            p.add(PojoToElementFactory.getDirectorPhrase(director));
            p.add(" ");
        }
        p.add(new Chunk("Year: ", FilmFonts.BOLDITALIC));
        p.add(new Chunk(String.valueOf(movie.getYear()), FilmFonts.NORMAL));
        p.add(new Chunk(" Duration: ", FilmFonts.BOLDITALIC));
        p.add(new Chunk(String.valueOf(movie.getDuration()), FilmFonts.NORMAL));
        p.add(new Chunk(" minutes", FilmFonts.NORMAL));
        p.add(new LineSeparator(0.3f, 100, null, Element.ALIGN_CENTER, -2));
        return p;
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
        new MovieColumns1().createPdf(RESULT);
    }
}
