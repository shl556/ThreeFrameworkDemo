package com.shl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Testsql {
    public void c3p0DataSourceTest() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
        	System.out.println("初始化");
            //获取数据库连接
            conn = JdbcPool_DPCB.getConn();
            String sql = "insert into test(name) values('gfd5')";
            st = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,  
                    java.sql.ResultSet.CONCUR_UPDATABLE);    
            st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcPool_JNDI.release(conn, st, rs);
        }
    }
}