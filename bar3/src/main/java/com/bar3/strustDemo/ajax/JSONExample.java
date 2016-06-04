package com.bar3.strustDemo.ajax;

import java.util.*;

import com.opensymphony.xwork2.*;

import org.apache.struts2.json.annotations.*;


public class JSONExample
{
	// 模拟处理结果的属性
    private int[] ints = {10, 20};
    private Map map = new HashMap();
    private String customName = "顾客";
	// 封装请求参数的三个属性
    private String field1;
    private String field2;
    // 没有setter和getter方法的字段不会被序列化
    private String field3;
    public String execute()
	{
		map.put("name", "李刚");
		return Action.SUCCESS;
	}
	/* 使用注释语法来改变该属性序列化后的属性名,json注释还支持如下属性：
	 * serialize:设置是否序列化该属性
	 * deserialize：设置是否反序列化该属性
	 * format：设置用于格式化输出、解析日期表单域的格式。
    */
	@JSON(name="newName")
	public Map getMap()
	{
		return this.map;
	}
	// ints属性的getter方法
	public int[] getInts()
	{
		return this.ints;
	}
	public void setCustomName(String customName)
	{
		this.customName = customName;
	}
	public String getCustomName()
	{
		return this.customName;
	}
	// 此处省略field1、field2属性的setter和getter方法

	// field1的setter和getter方法
	public void setField1(String field1)
	{
		this.field1 = field1;
	}
	public String getField1()
	{
		return this.field1;
	}

	// field2的setter和getter方法
	public void setField2(String field2)
	{
		this.field2 = field2;
	}
	public String getField2()
	{
		return this.field2;
	}
}
