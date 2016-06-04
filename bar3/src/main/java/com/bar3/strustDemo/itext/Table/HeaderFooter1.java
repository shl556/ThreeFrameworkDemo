/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.Table;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.PojoToElementFactory;
import com.bar3.strutsDemo.itext.database.Screening;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooter1 {

    /** The resulting PDF file. */
    public static final String RESULT = "results/part1/chapter04/header_footer_1.pdf";

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws SQLException, DocumentException, IOException {
    	// create a database connection
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        List<Date> days = PojoFactory.getDays(connection);
        for (Date day : days) {
            document.add(getTable(connection, day));
            document.newPage();
        }
        // step 5
        document.close();
        // close the database connection
        connection.close();

    }

    /**
     * Creates a table with screenings.
     * @param connection the database connection
     * @param day a film festival day
     * @return a table with screenings
     * @throws SQLException
     * @throws DocumentException
     * @throws IOException
     */
    public PdfPTable getTable(DatabaseConnection connection, Date day)
        throws SQLException, DocumentException, IOException {
    	// Create a table with 7 columns
        PdfPTable table = new PdfPTable(new float[] { 2, 1, 2, 5, 1, 3, 2 });
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        // Add the first header row
        Font f = new Font();
        f.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(day.toString(), f));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(7);
        table.addCell(cell);
        // Add the second header row twice
        table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        for (int i = 0; i < 2; i++) {
            table.addCell("Location");
            table.addCell("Time");
            table.addCell("Run Length");
            table.addCell("Title");
            table.addCell("Year");
            table.addCell("Directors");
            table.addCell("Countries");
        }
        table.getDefaultCell().setBackgroundColor(null);
        //此时已经插入3行，setHeaderRows(3)就是告诉itext这3行是特殊的表示表头的3行
        table.setHeaderRows(3);
        //setFooterRows(1)表示插入的3行中最后一行是表脚，如果没有可设为0
        table.setFooterRows(1);
        //当一张表格的内容被分成多页显示时，setSkipLastFooter为true时当前表格在本页内无法全部
        //显示时就会显示表脚，如果能够全部显示就不显示表脚，默认值为false即无论什么时候都添加表脚
        table.setSkipLastFooter(true);
        //作用同上
//        table.setSkipFirstHeader(true);
        // Now let's loop over the screenings
        List<Screening> screenings = PojoFactory.getScreenings(connection, day);
        Movie movie;
        for (Screening screening : screenings) {
            movie = screening.getMovie();
            table.addCell(screening.getLocation());
            table.addCell(String.format("%1$tH:%1$tM", screening.getTime()));
            table.addCell(String.format("%d '", movie.getDuration()));
            table.addCell(movie.getMovieTitle());
            table.addCell(String.valueOf(movie.getYear()));
            cell = new PdfPCell();
            cell.setUseAscender(true);
            cell.setUseDescender(true);
            cell.addElement(PojoToElementFactory.getDirectorList(movie));
            table.addCell(cell);
            cell = new PdfPCell();
            cell.setUseAscender(true);
            cell.setUseDescender(true);
            cell.addElement(PojoToElementFactory.getCountryList(movie));
            table.addCell(cell);
        }
        return table;
    }

    /**
     * Main method.
     * @param args no arguments needed
     * @throws DocumentException 
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args)
        throws SQLException, DocumentException, IOException {
        new HeaderFooter1().createPdf(RESULT);
    }
}
