/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapter5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.bar3.strutsDemo.itext.database.DatabaseConnection;
import com.bar3.strutsDemo.itext.database.HsqldbConnection;
import com.bar3.strutsDemo.itext.database.Movie;
import com.bar3.strutsDemo.itext.database.PojoFactory;
import com.bar3.strutsDemo.itext.database.Screening;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfWriter;

public class AlternatingBackground implements PdfPTableEvent {

	/** The resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter05/alternating.pdf";

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename) throws SQLException, DocumentException, IOException {
        // Create a database connection 
        DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        List<Date> days = PojoFactory.getDays(connection);
        PdfPTableEvent event = new AlternatingBackground();
        for (Date day : days) {
            PdfPTable table = getTable(connection, day);
            table.setTableEvent(event);
            document.add(table);
            document.newPage();
        }
        // step 5
        document.close();
        // Close the database connection
        connection.close();
    }
    
    /**
     * Creates a table with film festival screenings.
     * @param connection a database connection
     * @param day a film festival day
     * @return a table with screenings.
     * @throws SQLException
     * @throws DocumentException
     * @throws IOException
     */
    public PdfPTable getTable(DatabaseConnection connection, Date day)
        throws SQLException, DocumentException, IOException {
        PdfPTable table = new PdfPTable(new float[] { 2, 1, 2, 5, 1 });
        table.setWidthPercentage(100f);
        table.getDefaultCell().setPadding(3);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        table.getDefaultCell().setColspan(5);
        table.getDefaultCell().setBackgroundColor(BaseColor.RED);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(day.toString());
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table.getDefaultCell().setColspan(1);
        table.getDefaultCell().setBackgroundColor(BaseColor.ORANGE);
        for (int i = 0; i < 2; i++) {
            table.addCell("Location");
            table.addCell("Time");
            table.addCell("Run Length");
            table.addCell("Title");
            table.addCell("Year");
        }
        table.getDefaultCell().setBackgroundColor(null);
        table.setHeaderRows(3);
        table.setFooterRows(1);
        List<Screening> screenings = PojoFactory.getScreenings(connection, day);
        Movie movie;
        for (Screening screening : screenings) {
            movie = screening.getMovie();
            table.addCell(screening.getLocation());
            table.addCell(String.format("%1$tH:%1$tM", screening.getTime()));
            table.addCell(String.format("%d '", movie.getDuration()));
            table.addCell(movie.getMovieTitle());
            table.addCell(String.valueOf(movie.getYear()));
        }
        return table;
    }
    
    /**
     * Draws a background for every other row.
     * @see com.itextpdf.text.pdf.PdfPTableEvent#tableLayout(
     *      com.itextpdf.text.pdf.PdfPTable, float[][], float[], int, int,
     *      com.itextpdf.text.pdf.PdfContentByte[])
     */
    /*
     * table表示激发该事件的PdfPTable的实例，注意不能通过该实例修改表格内容
     * widths表示是一个二维数组表示表格中所有交叉点的x坐标，widths[0][0]表示左顶点的x坐标，widths[1][0]表示第二行第一个单元格左顶点的x坐标
     * heights是一个一维数组，表示表格中所有横线的y坐标，heights[0]表示表格顶边的y坐标，heights[1]表示表格中从上往下数第二条横线的y坐标
     * headerRows表示表头的行数
     * rowStart表示起始行，对于add（）方法起始行为0，对于writeSelectedRows()方法则是指定的值
     * canvases则是表格的四个绘画层的实例
     */
    public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
        int headerRows, int rowStart, PdfContentByte[] canvases) {
        int columns;
        Rectangle rect;
        //得到哪一行是表脚行
        int footer = widths.length - table.getFooterRows();
        //计算哪一行是表头行
        int header = table.getHeaderRows() - table.getFooterRows() + 1;
        for (int row = header; row < footer; row += 2) {
            //计算该行总共多少列
        	columns = widths[row].length - 1;
            rect = new Rectangle(widths[row][0], heights[row],
                        widths[row][columns], heights[row + 1]);
            rect.setBackgroundColor(BaseColor.YELLOW);
            rect.setBorder(Rectangle.NO_BORDER);
            canvases[PdfPTable.BASECANVAS].rectangle(rect);
        }
    }

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException, DocumentException, IOException {
        new AlternatingBackground().createPdf(RESULT);
    }
}
