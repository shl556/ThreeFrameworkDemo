/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package com.bar3.strustDemo.itext.chapeter3;

import java.io.IOException;

import com.bar3.strutsDemo.itext.database.Screening;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

/**
 * Draws a time table to the direct content using lines and simple shapes,
 * adding blocks representing a movies.
 */
public class MovieCalendar extends MovieTextInfo {

    /** The resulting PDF. */
    public static final String RESULT = "results/part1/chapter03/movie_calendar.pdf";
    
    /**
     * Draws the info about the movie.
     * @throws DocumentException 
     */
    protected void drawMovieInfo(Screening screening, PdfContentByte directcontent)
        throws DocumentException {
        super.drawMovieInfo(screening, directcontent);
        Rectangle rect = getPosition(screening);
        ColumnText column = new ColumnText(directcontent);
       //系统会自动让文本换行，让其能够在单元格范围内展示
        column.setSimpleColumn(new Phrase(screening.getMovie().getMovieTitle()),
                rect.getLeft(), rect.getBottom(),
                rect.getRight(), rect.getTop(), 18, Element.ALIGN_CENTER);
        column.go();
    }
    
    /**
     * Constructor for the MovieCalendar class; initializes the base font object.
     * @throws IOException 
     * @throws DocumentException 
     */
    public MovieCalendar() throws DocumentException, IOException {
        super();
    }
    
    /**
     * Main method creating the PDF.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        new MovieCalendar().createPdf(RESULT);
    }
}
