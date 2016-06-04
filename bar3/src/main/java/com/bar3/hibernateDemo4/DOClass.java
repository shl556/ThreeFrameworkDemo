package com.bar3.hibernateDemo4;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

public class DOClass implements Serializable {

    private Long id;
 
    public DOClass() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
