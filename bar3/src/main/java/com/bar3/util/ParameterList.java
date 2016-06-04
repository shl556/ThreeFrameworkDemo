package com.bar3.util;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: ParamList
 * @Description:表示查询参数的实体类
 * @author: shl
 * @date: 2016-1-10 下午1:07:42
 */
public class ParameterList{
	/**
	 * @Fields params : 存储参数的列表
	 */
	private List<Object> params = new ArrayList<Object>();
	/**
	 * @Fields length : 表示该列表内的参数个数
	 */
	public int length;

	public ParameterList(Object... param) {
		for (Object obj : param) {
			params.add(obj);
		}
		length = params.size();
	}
   
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		if (params.isEmpty()) {
			return null;
		}
		for (Object obj : params) {
			stringBuffer.append(obj.toString() + " / ");
		}
		return stringBuffer.toString();
	}
	public Object[] toAarry(){
		return params.toArray();
	}
}
