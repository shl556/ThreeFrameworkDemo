package com.shl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;
/**
 * @ClassName: BaseDao
 * @Description:数据库操作辅助类
 * @author: shl
 * @date: 2015-12-11 下午2:30:04
 */
public class BaseDao {
   
	/**
	 * @Description: 根据给定的查询语句和参数集合返回结果集
	 * @param sql sql语句
	 * @param paramlist 参数集合
	 * @return ResultSet 结果集  
	 * @throws Exception 
	 */
	public static QureyResult doQueuy(String sql, List<Object> paramlist)
			throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getConnection();
		preparedStatement = connection.prepareStatement(sql);
		setParamlist(preparedStatement, paramlist);
		resultSet = preparedStatement.executeQuery();
		return new QureyResult(resultSet, connection);
	}
	/**
	 * @Description: 根据给定的delete/insert/update语句和参数集合返回受影响
	 *               的行数；
	 * @param sql sql语句
	 * @param paramlist 参数集合
	 * @return int 受影响的行数  
	 * @throws Exception 
	 */
	public static int doUpdate(String sql,List<Object> paramlist) throws Exception{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int result=-1;
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(sql);
			setParamlist(preparedStatement, paramlist);
			result=preparedStatement.executeUpdate();
		}finally{
			 preparedStatement.close();
			connection.close();
		}
		return result;
	}
	/**
	 * @return 返回连接
	 * @throws Exception 
	 */
	private static Connection getConnection() throws Exception{
		Connection connection=JdbcPool_DPCB.getConn();
		if(connection==null){
			throw new Exception("获取连接失败");
		}
		return connection;
	}
	/**
	 * @Description 给预编译SQL语句对象设置参数
	 * @param pre
	 * @param paramlist   
	 * @throws Exception 
	 */
	private static void setParamlist(PreparedStatement pre,List<Object> paramlist) throws Exception{
		if(pre==null||paramlist.isEmpty()){
			throw new Exception("参数集合为空");
		}
		for(int i=0;i<paramlist.size();i++){
			Object object=paramlist.get(i);
			if(object instanceof Integer){
				pre.setInt(i+1,(Integer)object);
			}else if(object instanceof Double){
				pre.setDouble(i+1, (Double)object);
			}else if(object instanceof Float){
				pre.setFloat(i+1, (Float)object);
			}else if(object instanceof Long){
				pre.setLong(i+1, (Long)object);
			}else if(object instanceof String){
				pre.setString(i+1, (String)object);
			}else if(object instanceof Boolean){
				pre.setBoolean(i+1, (Boolean)object);
			}else if(object instanceof Date){
				pre.setDate(i+1, (java.sql.Date)object);
			}
		}
	}
}
