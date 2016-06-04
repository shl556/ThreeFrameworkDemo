<%@page import="com.shl.sql.Testsql"%>
<%@page import="javax.naming.*" %>
<%@page import="javax.sql.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
  Context ctx = new InitialContext() ;
  DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/JNDI") ;
  Connection conn = ds.getConnection() ;
  String sql = "insert into test(name) values('gfd5')";
  Statement st= conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,  
          java.sql.ResultSet.CONCUR_UPDATABLE);    
  st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
  //获取数据库自动生成的主键
  ResultSet rs = st.getGeneratedKeys();
  if(rs.next()){
      System.out.println(rs.getInt(1));
  }
 %>
 <%=conn%>
 <%
  conn.close() ;
 %>
</body>
</html>