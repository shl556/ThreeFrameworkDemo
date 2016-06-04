package com.bar3.hibernateDemo2;

import org.hibernate.*;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.*;

import java.sql.*;
import java.io.Serializable;

/**
* @ClassName: PhoneUserType
* @Description: 客户化映射类型
* @author shl
* @date 2016年2月10日 下午3:47:19
*/
public  class PhoneUserType implements UserType {

  private static final int[] SQL_TYPES = {Types.VARCHAR};
  /* 设置CUSTOMER表的PHONE字段的SQL类型
 * @see org.hibernate.usertype.UserType#sqlTypes()
 */
public int[] sqlTypes() { return SQL_TYPES; }

  /* 设置Customer类的phone属性的Java类型
 * @see org.hibernate.usertype.UserType#returnedClass()
 */
public Class returnedClass() { return Integer.class; }

  /* Hibernate调用isMutable()方法来了解Integer类是否是可变类。Hibernate处理
   * 一些不可变类型的属性时会采取一些性能优化措施
 * @see org.hibernate.usertype.UserType#isMutable()
 */
public boolean isMutable() { return false; }

  /* Hibernate调用deepCopy()方法生成对phone属性的快照，value参数代表Customer类的
   * phone属性。由于phone属性是Integer不可变类所以本方法直接返回value参数
 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
 */
public Object deepCopy(Object value) {
    return value; // Integer is immutable
  }

  /* Hibernate调用equals()方法来比较Customer类的phone属性的当前值是否和它的快照值相同。
   * x参数代表phone属性的当前值，参数y代表有deepCopy()方法生成的phone属性的快照
 * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
 */
public boolean equals(Object x, Object y) {
    if (x == y) return true;
    if (x == null || y == null) return false;
    return x.equals(y);
  }

  /* Hibernate调用hashCode()方法来获得Customer类的phone属性的哈希码
 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
 */
public int hashCode(Object x){
    return x.hashCode();
  }

  /* 当Hibernate把第二级缓存中的Customer对象加载到Session缓存中时调用assemble()方法来
   * 获得phone属性的反序列化数据。第二级缓存中存放了Customer对象的序列化数据。参数cached代表
   * phone属性的反序列化数据，参数owner代表phone属性的宿主。如果参数cached为不可变类型，可以
   * 直接返回cached参数，如果cached为可变类型则应该返回参数cached的快照，即调用deepCopy()方法的返回值
 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
 */
public Object assemble(Serializable cached, Object owner){
    return cached;
  }

  /* 当Hibernate把Session缓存中的Customer对象保存到第二级缓存中时调用disassemble()方法
   *来获得phone属性的序列化数据。参数value代表phone属性的序列化数据。如果参数value为不可变类型
   *可以直接返回value参数；如果参数value为可变类型，则应该返回参数value的快照。
 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
 */
public Serializable disassemble(Object value) {
    return (Serializable)value;
  }
  
  public Object replace(Object original,Object target,Object owner){
    return original;
  }
  /**
  * @Description: 当Hibernate从数据库中加载Customer对象时调用nullSafeGet()方法类取得当前phone属性值。
  * @param resultSet代表JDBC查询结果集
  * @param names 为存放了属性对应的表字段名的数组，此处为{"PHONE"}
  * @param owner代表phone属性的宿主，此处为Customer对象
  * @return 返回Customer类中的phone属性值
  * @throws HibernateException
  * @throws SQLException     
  */
/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
 */
@Override
public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
		throws HibernateException, SQLException {
	String phone = rs.getString(names[0]);
    //ResultSet的wasNull()方法判断上一次读取的字段（这里为PHONE字段）是否为null
    if (rs.wasNull()) return null;
    return new Integer(phone);
}
/**
* @Description: 当Hibernate把Customer对象持久化到数据库时，调用nullSafeSet()方法来把phone属性添加到
* SQL insert语句中。
* @param statement 预定义的SQL语句
* @param value 代表phone属性值
* @param index 代表把phone属性值插入到SQLinsert语句中的位置
* @throws HibernateException
* @throws SQLException     
*/
/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
 */
@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
		throws HibernateException, SQLException {
	if (value == null) {
	      st.setNull(index, Types.VARCHAR);
	    } else {
	      String phone=((Integer)value).toString();
	      st.setString(index, phone);
	    }
}
}


