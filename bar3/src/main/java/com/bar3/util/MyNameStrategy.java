package com.bar3.util;
import org.apache.commons.lang3.ClassUtils;
import org.hibernate.cfg.ImprovedNamingStrategy;

/**
* @ClassName: MyNameStrategy
* @Description: 数据库命名策略，可定制表、字段等的前后缀 
* @author shl
* @date 2016年2月12日 下午2:52:36
*/
public class MyNameStrategy extends ImprovedNamingStrategy {  
  
    /**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = -5896835372188856018L;
    /** 
     * 数据库表命名格式信息 
     */  
    private static SchemaTableName dbcfg = new SchemaTableName("/config/NamingStrategy.properties");  
    
    public MyNameStrategy() {  
    	
    }  
    
    /** 
     * 转化为物理表名 
     *  
     * @param className hbm.xml中的对应表的class值 
     */  
    @Override  
    public String classToTableName(String className) {  
          
        if(className == null ) return null;  
        String simpleClassName=ClassUtils.getShortClassName(className);
        //改变大小写  
        String str =UpdateStyle(simpleClassName,dbcfg.getTableStyle().name());  
              
        //添加前后缀  
        str = addPrefixORStuffix(str, dbcfg.getTablePrefix(),dbcfg.getTableSuffix());  
          
        //添加分隔符  
        str = addSeparator(str,dbcfg.getTableSeparator());  
          
        return str;  
    }  
  
      
    /** 
     * 将读取到的列名传递过来进行加工处理，变为物理表的字段名 
     *  
     * @param columnName logicalColumnName方法读取到的列名 
     */  
    @Override  
    public String columnName(String columnName) {  
        //先调用logicalColumnName方法，拿到处理过的值，  
        //再传递到该方法中，所以可以在这两个方法中任一选择修改。         
        //return columnName;  
          
        if(columnName == null ) return null;  
          
        //改变大小写  
        String str =UpdateStyle(columnName,dbcfg.getColumnTyle().name());  
              
        //添加前后缀  
        str = addPrefixORStuffix(str, dbcfg.getColumnPrefix(),dbcfg.getColumnSuffix());  
          
        //添加分隔符  
        str = addSeparator(str,dbcfg.getColumnSeparator());  
          
        return str;  
          
    }  
  
      
    /** 
     * 处理外键列名 
     *  
     */  
//    @Override  
//    public String foreignKeyColumnName(String propertyName,  
//            String propertyEntityName, String propertyTableName,  
//            String referencedColumnName) {  
//          
//        if(referencedColumnName == null ) return null;  
//          
//        //改变大小写  
//        String str =UpdateStyle(referencedColumnName,dbcfg.getColumnTyle().name());  
//              
//        //添加前后缀  
//        str = addPrefixORStuffix(str, dbcfg.getColumnPrefix(),dbcfg.getColumnSuffix());  
//          
//        //添加分隔符  
//        str = addSeparator(str,dbcfg.getColumnSeparator());  
//          
//        return str;  
//    }  
  
    /** 
     * 关联键的名称 
     */  
//    @Override  
//    public String joinKeyColumnName(String joinedColumn, String joinedTable) {  
//          
//        if(joinedColumn == null ) return null;  
//          
//        //改变大小写  
//        String str =UpdateStyle(joinedColumn,dbcfg.getColumnTyle().name());  
//              
//        //添加前后缀  
//        str = addPrefixORStuffix(str, dbcfg.getColumnPrefix(),dbcfg.getColumnSuffix());  
//          
//        //添加分隔符  
//        str = addSeparator(str,dbcfg.getColumnSeparator());  
//          
//        return str;  
//    }  
  
    /** 
     * 处理逻辑列名 
     * <b>若设置了column属性，会直接调用调用该方法</b> 
     *  
     * @param columnName    列名 
     * @param propertyName  实体列名 
     */  
//    @Override  
//    public String logicalColumnName(String columnName, String propertyName) {  
//          
//        //name值对应propertyName，column值对应columnName  
//        //判断columnName是否设置，若设置了，则返回column值，否则返回propertyName值  
//        return columnName == null || columnName =="" ? propertyName:columnName;  
//          
//    }  
  
    /** 
     * 处理逻辑列名 
     * <b>若未设置column属性，则先调用该方法，再调用logicalColumnName方法</b> 
     *  
     * @param propertyName  实体列名 
     */  
    @Override  
    public String propertyToColumnName(String propertyName) {  
  
        if(propertyName == null ) return null;  
          
        //改变大小写  
        String str =UpdateStyle(propertyName,dbcfg.getColumnTyle().name());  
              
        //添加前后缀  
        str = addPrefixORStuffix(str, dbcfg.getColumnPrefix(),dbcfg.getColumnSuffix());  
          
        //添加分隔符  
        str = addSeparator(str,dbcfg.getColumnSeparator());  
          
        return str;  
    }  
  
      
    /** 
     * 处理表名 
     * <b>若设置了table属性，才会调用该方法</b> 
     */  
    @Override  
    public String tableName(String tableName) {  
          
        if(tableName == null ) return null;  
          
        //改变大小写  
        String str =UpdateStyle(tableName,dbcfg.getTableStyle().name());  
              
        //添加前后缀  
        str = addPrefixORStuffix(str, dbcfg.getTablePrefix(),dbcfg.getTableSuffix());  
          
        //添加分隔符  
        str = addSeparator(str,dbcfg.getTableSeparator());  
          
        return str;  
    }  
    public String propertyToTableName(String className, String propertyName) {
        return classToTableName(className) + '_' +
             propertyToColumnName(propertyName);
    }
    /** 
     * 单词分隔符 
     *  
     * @param name 
     * @return 
     */  
    private String addSeparator(String str, String flag) {  
        StringBuffer buf = new StringBuffer(str.substring(str.lastIndexOf(".")+1));  
        for (int i = 1; i < buf.length() - 1; i++) {  
            if ('_' != buf.charAt(i - 1)  
                    && Character.isUpperCase(buf.charAt(i))  
                    && !Character.isUpperCase(buf.charAt(i + 1))) {  
                // buf.insert(i++, '_');  
                buf.insert(i++, flag);  
            }  
        }  
        return buf.toString();  
    }  
  
    /** 
     * 添加前后缀 
     *  
     * @param str 
     *            字符串 
     * @param prefix 
     *            前缀 
     * @param suffix 
     *            后缀 
     * @return 
     */  
    private String addPrefixORStuffix(String str, String prefix, String suffix) {  
        StringBuffer buf = new StringBuffer(str.substring(str.lastIndexOf(".")+1));  
        buf.insert(buf.length(), suffix).insert(0, prefix);  
        return buf.toString();  
    }  
  
    /** 
     * 更新样式 
     * @param str 
     * @param style 
     * @return 
     */  
    private String UpdateStyle(String str, String style) {        
        if ("AU".equals(style)) {  
            str = str.toUpperCase();  
        } else if ("AL".equals(style)) {  
            str = str.toLowerCase();  
        } else if ("FU".equals(style)) {  
            StringBuffer buf = new StringBuffer(str.substring(str.lastIndexOf(".")+1));  
            String upper =buf.substring(0,1).toUpperCase();  
            buf.delete(0, 1).insert(0, upper);  
            str = buf.toString();  
        } else if ("FL".equals(style)) {  
            StringBuffer buf = new StringBuffer(str.substring(str.lastIndexOf(".")+1));  
            String lower =buf.substring(0,1).toLowerCase();  
            buf.delete(0, 1).insert(0, lower);  
            str = buf.toString();  
        }      
        return str;  
    }  
      
      
}  
