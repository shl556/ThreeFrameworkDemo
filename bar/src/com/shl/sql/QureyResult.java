/**
 * FileName:     QureyResult.java
 * @Description: TODO(用一句话描述该文件做什么)
* All rights Reserved, Designed By ZTE-ITS
 * Copyright:    Copyright(C) 2010-2011
 * Company       ZTE-ITS WuXi LTD.
 * @author:    名字
 * @version    V1.0 
 * Createdate:         2015-12-11 下午4:19:26
 *
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2015-12-11       wu.zh          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
 
package com.shl.sql;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @ClassName: QureyResult
 * @Description:用来保存查询结果和相关数据库连接的实体bean
 * @author: shl
 * @date: 2015-12-11 下午4:19:26
 */
public class QureyResult {
	/**
	 * @Fields resultSet :查询结果的结果集
	 */
	private ResultSet resultSet;
	/**  
	 * @Fields connection : 跟查询结果集相匹配的数据库连接
	 */  
	private Connection connection;
	/**
	 * @param resultSet
	 * @param connection
	 */
	public QureyResult(ResultSet resultSet, Connection connection) {
		super();
		this.resultSet = resultSet;
		this.connection = connection;
	}
	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}
	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
