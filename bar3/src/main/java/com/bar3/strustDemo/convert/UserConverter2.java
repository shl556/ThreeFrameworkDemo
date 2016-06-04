package com.bar3.strustDemo.convert;

import java.text.ParseException;
import java.util.*;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import com.bar3.util.ToStringUtil;
//StrutsTypeConverter是DefaultTypeConverter的子类，已经实现了convertValue
//方法并且将双向转换分别独立成两个方法，我们只需重写这两个方法即可。
public class UserConverter2 extends StrutsTypeConverter
{
	// 处理将字符串类型转换成复合类型的方法
	public Object convertFromString(Map context,
		String[] values, Class toClass)
	{
		// 如果请求参数数组的长度大于1
		if (values.length > 1)
		{
			// 创建一个User数组
			User[] result = new User[values.length];
			// 遍历请求参数数组
			for (int i = 0; i < values.length ; i++ )
			{
				// 将每个数组元素转换成一个User实例
				User user = new User();
				String[] userValues = values[i]
					.split(",");
				user.setName(userValues[0]);
				user.setPass(userValues[1]);
				user.setAge(Integer.parseInt(userValues[2]));
				try {
					user.setBirth(DateUtils.parseDate(userValues[3], "yyyy-MM-dd"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 将转换的User实例装入数组
				result[i] = user;
			}
			return result;
		}
		// 如果请求参数数组的长度为1
		else
		{
			// 创建一个User实例
			User user = new User();
			// 将请求参数转换成一个User实例
			String[] userValues = values[0].split(",");
			user.setName(userValues[0]);
			user.setPass(userValues[1]);
			user.setAge(Integer.parseInt(userValues[2]));
			try {
				user.setBirth(DateUtils.parseDate(userValues[3], "yyyy-MM-dd"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
	}
	// 处理把复合类型转换成字符串类型的方法
	public String convertToString(Map context, Object o)
	{
		// 如果需要转换的值是单个的User实例
		if (o instanceof User)
		{
			User user = (User)o;
			return ToStringUtil.ObjectToString(this);
		}
		// 如果需要转换的值是User数组
		else if (o instanceof User[])
		{
			User[] users = (User[])o;
			String result = "[";
			for (User user : users )
			{
				result += ToStringUtil.ObjectToString(this);
			}
			return result + "]";
		}
		else
		{
			return "";
		}
	}
}
