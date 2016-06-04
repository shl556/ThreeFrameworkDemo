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
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooter2 extends HeaderFooter1 {

    /** The resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter04/header_footer_2.pdf";

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
            PdfPTable table = getTable(connection, day);
            //默认情况下itext会确保同一行的内容显示在同一页内，如果setsetSplitLate为false就会完全依据文本需要的高度
            //在文本需要的高度大于单元格高度时，该单元格会被拆分成两个单元格，分页显示
            table.setSplitLate(false);
            document.add(table);
            document.newPage();
        }
        // step 5
        document.close();
        // close the database connection
        connection.close();
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
        new HeaderFooter2().createPdf(RESULT);
    }
}
