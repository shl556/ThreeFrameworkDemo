package com.bar3.hibernateDemo;

import java.util.HashSet;
import java.util.Set;

public class Category  implements java.io.Serializable {

     private long id;
     private String name;
     private Set childCategories = new HashSet(0);
     private Category parentCategory;

    public Category() {
    }

    public Category(String name, Set childCategories, Category parentCategory) {
       this.name = name;
       this.childCategories = childCategories;
       this.parentCategory = parentCategory;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getChildCategories() {
        return this.childCategories;
    }
    
    public void setChildCategories(Set childCategories) {
        this.childCategories = childCategories;
    }
    public Category getParentCategory() {
        return this.parentCategory;
    }
    
    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void addChildCategory(Category category) {
	if (category == null)
		throw new IllegalArgumentException("Can't add a null Category as child.");
	// 删除旧的父类别Category
	if (category.getParentCategory() != null)
		category.getParentCategory().getChildCategories().remove(category);
	//设置新的父类别Category
	category.setParentCategory(this);
	//向当前Category对象中加入子类别
	this.getChildCategories().add(category);
   }

}






/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
