package com.bar3.strustDemo.jasperReport;

import java.io.IOException;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;

public class PdfParagraph extends Paragraph {
	private static final long serialVersionUID = -244970043180837974L;
	public PdfParagraph(String content) {
		super(content, getChineseFont(12, false));
	}
	public PdfParagraph(String content, int fontSize, boolean isBold) {
		super(content, getChineseFont(fontSize, isBold));
	}
	// 设置字体-返回中文字体
	protected static Font getChineseFont(int fontsize, boolean isBold) {
		BaseFont bfChinese;
		Font fontChinese = null;
		try {
			bfChinese = BaseFont.createFont("c://windows//fonts//simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			if (isBold) {
				fontChinese = new Font(bfChinese, fontsize, Font.BOLD);
			} else {
				fontChinese = new Font(bfChinese, fontsize, Font.NORMAL);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fontChinese;
	}
	// 转化中文
	protected PdfPCell ChangeCell(String str, int nfontsize, boolean isBold) throws IOException, BadElementException,
			DocumentException {
		Phrase ph = ChangeChinese(str, nfontsize, isBold);
		PdfPCell cell = new PdfPCell(ph);
		// cell.setBorderWidth(3);
		return cell;
	}
	// 转化中文
	protected Chunk ChangeChunk(String str, int nfontsize, boolean isBold) throws IOException, BadElementException,
			DocumentException {
		Font FontChinese = getChineseFont(nfontsize, isBold);
		Chunk chunk = new Chunk(str, FontChinese);
		return chunk;
	}
	// 转化中文
	protected Phrase ChangeChinese(String str, int nfontsize, boolean isBold) throws IOException, BadElementException,
			DocumentException {
		Font FontChinese = getChineseFont(nfontsize, isBold);
		Phrase ph = new Phrase(str, FontChinese);
		return ph;
	}
}
