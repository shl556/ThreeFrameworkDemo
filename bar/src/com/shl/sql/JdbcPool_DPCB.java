package com.shl.sql;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
 
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;
 
/**
 * tomcat数据库连接池管理类<br>
 * 使用为tomcat部署环境<br>
 * 需要在类路径下准备数据库连接配置文件dbcp.properties
 * 
 */
public class JdbcPool_DPCB{
    private static final Log log = LogFactory.getLog(JdbcPool_DPCB.class);//获取记录日志的对象
    private static DataSource dataSource;
    //静态初始化
    static{
    	System.out.println("初始化");
        Properties dbProperties = new Properties();
        try {
        	//创建datasource连接池
            dbProperties.load(JdbcPool_DPCB.class.getResourceAsStream("dpcbconfig_mysql.properties"));
            String s=dbProperties.getProperty("username");
            System.out.println(s);
            dataSource = BasicDataSourceFactory.createDataSource(dbProperties);
             //尝试获取连接并记录数据库产品信息
            Connection conn = getConn();
            DatabaseMetaData mdm = conn.getMetaData();
            log.info("Connected to " + mdm.getDatabaseProductName() + " "
                    + mdm.getDatabaseProductVersion());
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            log.error("初始化连接池失败：" + e);
            e.printStackTrace();
        }
    }
    private JdbcPool_DPCB() {
		
	}
 
    /**
     * 获取链接
     */
    public static final Connection getConn() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            log.error("获取数据库连接失败：" + e);
        }
        return conn;
    }
 
    /**
     * 关闭连接
     * 
     * @param conn 需要关闭的连接
     * @param st 预编译SQL语句
     * @param rs 结果集
     */
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public static void main(String[] args){
//		long begin=System.currentTimeMillis();
//        for(int i=0;i<100;i++){
//            Connection conn=JdbcPool_DPCB.getConn();
//            System.out.print(i+"   ");
//            JdbcPool_DPCB.closeConn(conn);
//        }
//        long end=System.currentTimeMillis();
//        System.out.println("用时："+(end-begin));
//    }
}