package com.bar3.hibernateDemo2;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * Manages persistence for the {@link Name} composite type.
 */
/**
* @ClassName: NameCompositeUserType
* @Description: 
* @author shl
* @date 2016年2月10日 下午4:34:39
*/
public class NameCompositeUserType implements CompositeUserType {


    /**
     * Get the names of the properties that make up this composite type,
     * and that may be used in a query involving it.
     */
    /* 返回Name类所有属性的名字
     * @see org.hibernate.usertype.CompositeUserType#getPropertyNames()
     */
    public String[] getPropertyNames() {
        // Allocate a new response each time, because arrays are mutable
        return new String[] { "firstname", "lastname" };
    }

    /**
     * Get the types associated with the properties that make up this
     * composite type.
     *
     * @return the types of the parameters reported by
     *         {@link #getPropertynames}, in the same order.
     */
    /* 返回Name类所有属性的Hibernate映射类型
     * @see org.hibernate.usertype.CompositeUserType#getPropertyTypes()
     */
    public Type[] getPropertyTypes() {
        return new Type[] {StringType.INSTANCE, StringType.INSTANCE };
    }

    /**
     * Look up the value of one of the properties making up this composite
     * type.
     *
     * @param component a {@link Name} instance being managed.
     * @param property the index of the desired property.
     * @return the corresponding value.
     * @see #getPropertyNames
     */
    /* 根据Name对象中的某个属性的在Name对象中的位置读取属性值。参数component代表Name对象，参数property代表
     * 属性在Name对象中的位置
     * @see org.hibernate.usertype.CompositeUserType#getPropertyValue(java.lang.Object, int)
     */
    public Object getPropertyValue(Object component, int property) {
        Name name = (Name)component;
        String result;

        switch (property) {

        case 0:
            result = name.getFirstname();
            break;

        case 1:
            result = name.getLastname();
            break;

        default:
            throw new IllegalArgumentException("unknown property: " +
                                               property);
        }

        return result;
    }

    /**
     * Set the value of one of the properties making up this composite
     * type.
     *
     * @param component a {@link Name} instance being managed.
     * @param property the index of the desired property.
     * @object value the new value to be established.
     * @see #getPropertyNames
     */
    /* 设置Name对象的某个属性值，参数component代表Name对象，参数property代表属性在Name对象中的位置，参数value代表属性值
     * @see org.hibernate.usertype.CompositeUserType#setPropertyValue(java.lang.Object, int, java.lang.Object)
     */
    public void setPropertyValue(Object component, int property, Object value)
    {
        Name name = (Name)component;
        String nameValue = (String)value;
        switch (property) {

        case 0:
            name.setFirstname(nameValue);
            break;

        case 1:
            name.setLastname(nameValue);
            break;

        default:
            throw new IllegalArgumentException("unknown property: " +
                                               property);
        }
    }

    /**
     * Determine the class that is returned by {@link #nullSafeGet1}.
     *
     * @return {@link Name}, the actual type returned
     * by {@link #nullSafeGet1}.
     */
    public Class returnedClass() {
		return Name.class;
    }

    /**
     * Compare two instances of the class mapped by this type for persistence
     * "equality".
     *
     * @param x first object to be compared.
     * @param y second object to be compared.
     * @return <code>true</code> iff both represent the same volume levels.
     * @throws ClassCastException if x or y isn't a {@link Name}.
     */
    public boolean equals(Object x, Object y) {
        if (x == y) {  // This is a trivial success
            return true;
        }
        if (x == null || y == null) {  // Don't blow up if either is null!
            return false;
        }
        // Now it's safe to delegate to the class' own sense of equality
        return x.equals(y);
    }

    public int hashCode(Object x){
      return x.hashCode();
    }

    /**
     * Return a deep copy of the persistent state, stopping at
     * entities and collections.
     *
     * @param value the object whose state is to be copied.
      * @throws ClassCastException for non {@link Name} values.
     */
    /* 因为Name是可变类，因此必须把Name对象的属性复制到一个新的Name实例中
     * @see org.hibernate.usertype.CompositeUserType#deepCopy(java.lang.Object)
     */
    public Object deepCopy(Object value) {
        if (value == null) return null;
        Name name = (Name)value;
        //return name;
        return new Name(name.getFirstname(), name.getLastname());
    }

    /**
     * Indicates whether objects managed by this type are mutable.
     *
     * @return <code>true</code>, since {@link Name} is mutable.
     */
    public boolean isMutable() {
        return true;
    }

    /**
     * Retrieve an instance of the mapped class from a JDBC {@link ResultSet}.
     *
     * @param rs the results from which the instance should be retrieved.
     * @param names the columns from which the instance should be retrieved.
     * @param session, an extension of the normal Hibernate session interface
     *        that gives you much more access to the internals.
     * @param owner the entity containing the value being retrieved.
     * @return the retrieved {@link Name} value, or <code>null</code>.
     * @throws HibernateException if there is a problem performing the mapping.
     * @throws SQLException if there is a problem accessing the database.
     */
	public Object nullSafeGet(ResultSet resultSet,
							  String[] names,SessionImplementor session,
							  Object owner)
			throws HibernateException, SQLException {

		String firstname= resultSet.getString(names[0]);
                String lastname= resultSet.getString(names[1]);
                
                if(firstname==null && lastname==null) return null; 
                return new Name(firstname,lastname);
	}

    /**
     * Write an instance of the mapped class to a {@link PreparedStatement},
     * handling null values.
     *
     * @param st a JDBC prepared statement.
     * @param value the Name value to write.
     * @param index the parameter index within the prepared statement at which
     *        this value is to be written.
     * @param session, an extension of the normal Hibernate session interface
     *        that gives you much more access to the internals.
     * @throws HibernateException if there is a problem performing the mapping.
     * @throws SQLException if there is a problem accessing the database.
     */


	public void nullSafeSet(PreparedStatement statement,Object value,int index,SessionImplementor session)
			throws HibernateException, SQLException {

		if (value == null) {
			statement.setNull(index, Types.VARCHAR);
                        statement.setNull(index+1, Types.VARCHAR);
		} else {
		       Name name=(Name)value;
			statement.setString(index, name.getFirstname());
                        statement.setString(index+1, name.getLastname());
 		}
	}

    /**
     * Reconstitute a working instance of the managed class from the cache.
     *
     * @param cached the serializable version that was in the cache.
     * @param session, an extension of the normal Hibernate session interface
     *        that gives you much more access to the internals.
     * @param owner the entity containing the value being retrieved.
     * @return a copy of the value as a {@link Name} instance.
     */
    public Object assemble(Serializable cached, SessionImplementor session,
                           Object owner)
    {
        // Our value type happens to be serializable, so we have an easy out.
        return deepCopy(cached);
    }

    /**
     * Translate an instance of the managed class into a serializable form to
     * be stored in the cache.
     *
     * @param session, an extension of the normal Hibernate session interface
     *        that gives you much more access to the internals.
     * @param value the Name value to be cached.
     * @return a serializable copy of the value.
     */
    public Serializable disassemble(Object value,
                                    SessionImplementor session) {
        return (Serializable) deepCopy(value);
    }

    public Object replace(Object original,Object target,SessionImplementor session,Object owner){
      return deepCopy(original);
    }
}
