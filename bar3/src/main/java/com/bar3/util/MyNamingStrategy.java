package com.bar3.util;
import org.apache.commons.lang3.ClassUtils;
import org.hibernate.cfg.ImprovedNamingStrategy;
/**
* @ClassName: MyNamingStrategy
* @Description:表示命名策略的类 
* @author shl
* @date 2016年2月5日 下午5:36:17
*/
/*
 * 命名策略主要针对property元素和class元素，对column元素和many-to-one等元素无用
 */
public class MyNamingStrategy extends ImprovedNamingStrategy {
   /**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = 5793197923510761924L;
//当没有显示设置表名时根据类名生成表名
   public String classToTableName(String className) {
        return  ClassUtils.getShortClassName(className).toUpperCase()+'S';
   }
   //当显示设置表名时根据表名生成表名
   public String tableName(String tableName) {
       return tableName.toUpperCase();
   }
   //当没有显示设置字段名时根据属性名生成字段名
   public String propertyToColumnName(String propertyName) {
       return propertyName.toUpperCase();
   }
   //当显示设置字段名时根据字段名生成字段名
   public String columnName(String columnName) {
       return columnName.toUpperCase();
   }
   public String propertyToTableName(String className, String propertyName) {
       return classToTableName(className) + '_' +
            propertyToColumnName(propertyName);
   }
}

