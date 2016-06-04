package com.bar3.hibernateDemo2;
import org.hibernate.*;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.*;

import java.sql.*;
import java.io.Serializable;

public class AddressUserType implements UserType {

  private static final int[] SQL_TYPES = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
  
  /* 设置address类的四个属性依次对应的SQL类型
 * @see org.hibernate.usertype.UserType#sqlTypes()
 */
public int[] sqlTypes() { return SQL_TYPES; }

  /* 设置address属性所映射地Java类
 * @see org.hibernate.usertype.UserType#returnedClass()
 */
public Class returnedClass() { return Address.class; }

  public boolean isMutable() { return false; }

  public Object deepCopy(Object value) {
    return value; // Address is immutable
  }

  public boolean equals(Object x, Object y) {
    if (x == y) return true;
    if (x == null || y == null) return false;
    return x.equals(y);
  }

  public int hashCode(Object x){
    return x.hashCode();
  }
  
 public Object assemble(Serializable cached, Object owner){
    return cached;
  }

  public Serializable disassemble(Object value) {
    return (Serializable)value;
  }
  
  public Object replace(Object original,Object target,Object owner){
    return original;
  }

/* 从jdbc ResultSet中读取province、city、street和zipcode字段值，然后根据字段值构造并返回一个Address对象
 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
 */
@Override
public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
		throws HibernateException, SQLException {
	 String province = rs.getString(names[0]);
	    String city = rs.getString(names[1]);
	    String street = rs.getString(names[2]);
	    String zipcode = rs.getString(names[3]);
	    if(province ==null  && city==null  && street==null  && zipcode==null)
	      return null;
	    return new Address(province,city,street,zipcode);
}

/* 把Address对象的属性添加到JDBC PreparedStatement中
 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
 */
@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
		throws HibernateException, SQLException {
    if (value == null) {
      st.setNull(index, Types.VARCHAR);
      st.setNull(index+1, Types.VARCHAR);
      st.setNull(index+2, Types.VARCHAR);
      st.setNull(index+3, Types.VARCHAR);
    } else {
      Address address=(Address)value;
      st.setString(index, address.getProvince());
      st.setString(index+1, address.getCity());
      st.setString(index+2, address.getStreet());
      st.setString(index+3, address.getZipcode());
    }
}
}

