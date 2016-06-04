package com.bar3.strustDemo.jasperReport;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

//该Action实际并没有包含任何处理，继承ActionSupport
//将直接使用ActionSupport类的execute方法作为控制器的处理逻辑
public class JasperAction extends ActionSupport
{
	// 定义一个getBookList方法用于返回VO集合
	public List getBookList()
	{
		List<BookVo> result = new ArrayList<>();
		result.add(new BookVo(1 , "疯狂Java讲义" , "李刚"));
		result.add(new BookVo(2 , "轻量级Java EE企业应用实战" , "李刚"));
		result.add(new BookVo(3 , "疯狂Android讲义" , "李刚"));
		return result;
	}
}
