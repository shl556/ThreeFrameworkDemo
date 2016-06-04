package com.bar3.strustDemo.jasperReport;

import java.io.UnsupportedEncodingException;

public class StrHelp {
	/**
	* @Description:对中文字符串解码转换成iso编码 
	* @param s
	* @return     
	*/
	public static String getChinese(String s) {
		try {
			return new String(s.getBytes("gb2312"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}
}
