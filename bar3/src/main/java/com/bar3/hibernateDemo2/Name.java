package com.bar3.hibernateDemo2;
import java.io.Serializable;

/**
* @ClassName: Name
* @Description: 可变类实例
* @author shl
* @date 2016年2月10日 下午4:34:28
*/
public class Name implements Serializable {

    private String firstname;
    private String lastname;

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname){
       this.firstname=firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname){
       this.lastname=lastname;
    }


    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

	 final Name name = (Name) o;

	 if(!firstname.equals(name.firstname)) return false;
	 if(!lastname.equals(name.lastname)) return false;
	 return true;
    }

    public int hashCode(){
        int result;
	result= (firstname==null?0:firstname.hashCode());
	result = 29 * result + (lastname==null?0:lastname.hashCode());
 	return result;
    }

    public String toString(){
      return lastname+" "+firstname;
    }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
