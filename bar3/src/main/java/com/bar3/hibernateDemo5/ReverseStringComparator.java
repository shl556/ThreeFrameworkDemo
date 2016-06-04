package com.bar3.hibernateDemo5;

import java.util.*;
public class ReverseStringComparator implements Comparator{

  public int compare(Object o1,Object o2){
    String s1=(String)o1;
    String s2=(String)o2;

    if(s1.compareTo(s2)>0) return -1;
    if(s1.compareTo(s2)<0) return 1;

    return 0;
  }
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
