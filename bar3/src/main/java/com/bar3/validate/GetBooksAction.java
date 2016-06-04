package com.bar3.validate;


import com.opensymphony.xwork2.*;
/*
 * Action就是普通的POJO类加上一个返回字符串的execute()方法，pojo类封装的属性既可以用于接收参数
 * ，由strust负责从请求中解析参数并完成类型转换赋值给指定的action，也可以用于封装传递给显示页面的数据，
 * ，在调用execute（）的过程中赋值。execute()方法由strust调用完成业务逻辑功能。
 */
/*
 * Action类可以选择实现Action接口，该接口只是定义了5个标准的字符串常量，它们可以使execute方法的返回值
 * 标准化。
 */
public class GetBooksAction implements Action
{
	// 该属性并不用于封装用户请求参数，而用于封装Action需要输出到JSP页面的信息
	private String[] books;
	// books属性的setter、getter方法
	public void setBooks(String[] books)
	{
		this.books = books;
	}
	public String[] getBooks()
	{
		return books;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		// 获取Session中的user属性
		String user = (String)ActionContext.getContext()
			.getSession().get("user");
		// 如果user属性不为空，且该属性值为crazyit
		if (user != null && user.equals("crazyit"))
		{
			// 创建BookService实例
			BookService bs = new BookService();
			// 将业务逻辑组件的返回值设置成该Action的属性
			setBooks(bs.getLeeBooks());
			return SUCCESS;
		}
		else
		{
			return LOGIN;
		}
	}
}
