package com.bar3.strustDemo.ajax;

public class HTMLDecoder
{
	public static String decode(String str)
	{
		//获取字符串中所有数字
		String[] tmp = str.split(";&#|&#|;");
		StringBuffer sb = new StringBuffer("");
		//处理每个tmp数组中每个字符串元素
		for (int i = 0; i < tmp.length ; i ++ )
		{
			//如果该元素是5位数字，将其转换成非西欧字符
			if (tmp[i].matches("\\d{5}") )
			{
				sb.append((char)Integer.parseInt(tmp[i]));
			}
			//对于普通字符
			else
			{
				sb.append(tmp[i]);
			}
		}
		return sb.toString();
	}
}
