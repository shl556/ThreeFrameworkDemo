package com.bar3.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
/**
* @ClassName: SchemaTableName
* @Description: 数据库库表命名模式
* @author shl
* @date 2016年2月12日 下午2:57:18
*/
public final class SchemaTableName {  
  
  
    /** 
     * 列名样式 
     * AU-all upper case 
     * AL-all lower case 
     * FU-first upper case per word 
     * FL-first lower case ,Other first letter upper case 
     */  
    public static enum ColumnTyle {  
        AU,AL,FU,FL;          
    }  
      
    /** 
     * 表名称样式 
     * AU-all upper case 
     * AL-all lower case 
     * FU-first upper case per word 
     * FL-first lower case ,Other first letter upper case 
     */  
    public static enum TableStyle{  
        AU,AL,FU,FL;  
    }  
  
    /** 
     * 列名样式 
     * AU-all upper case 
     * AL-all lower case 
     * FU-first upper case per word 
     * FL-first lower case ,Other first letter upper case 
     */  
    private ColumnTyle columnTyle = ColumnTyle.FL;  
      
    /** 
     * 表名称样式 
     * AU-all upper case 
     * AL-all lower case 
     * FU-first upper case per word 
     * FL-first lower case ,Other first letter upper case 
     */  
    private TableStyle tableStyle = TableStyle.FU;  
      
    /** 
     * 表名称前缀 
     */  
    private String tablePrefix = "";  
      
    /** 
     * 表名称后缀 
     */  
    private String tableSuffix = "";  
      
    /** 
     * 表名称分隔符 
     */  
    private String tableSeparator = "";  
      
    /** 
     * 列名前缀 
     */  
    private String columnPrefix = "";  
      
    /** 
     * 列名后缀 
     */  
    private String columnSuffix = "";  
      
    /** 
     * 列名分隔符 
     */  
    private String columnSeparator = "";  
      
    public ColumnTyle getColumnTyle() {  
        return columnTyle;  
    }  
  
    public void setColumnTyle(ColumnTyle columnTyle) {  
        this.columnTyle = columnTyle;  
    }  
  
    public TableStyle getTableStyle() {  
        return tableStyle;  
    }  
  
    public void setTableStyle(TableStyle tableStyle) {  
        this.tableStyle = tableStyle;  
    }  
  
    public String getTablePrefix() {  
        return tablePrefix;  
    }  
  
    public void setTablePrefix(String tablePrefix) {  
        this.tablePrefix = tablePrefix;  
    }  
  
    public String getTableSuffix() {  
        return tableSuffix;  
    }  
  
    public void setTableSuffix(String tableSuffix) {  
        this.tableSuffix = tableSuffix;  
    }  
  
    public String getTableSeparator() {  
        return tableSeparator;  
    }  
  
    public void setTableSeparator(String tableSeparator) {  
        this.tableSeparator = tableSeparator;  
    }  
  
    public String getColumnPrefix() {  
        return columnPrefix;  
    }  
  
    public void setColumnPrefix(String columnPrefix) {  
        this.columnPrefix = columnPrefix;  
    }  
  
    public String getColumnSuffix() {  
        return columnSuffix;  
    }  
  
    public void setColumnSuffix(String columnSuffix) {  
        this.columnSuffix = columnSuffix;  
    }  
  
    public String getColumnSeparator() {  
        return columnSeparator;  
    }  
  
    public void setColumnSeparator(String columnSeparator) {  
        this.columnSeparator = columnSeparator;  
    }  
      
  
    /** 
     * 初始化，读取配置参数,默认读取NamingStrategy.properties 
     * @param cfg 
     */  
    public SchemaTableName(){  
        String cfgPath="/config/NamingStrategy.properties";
    	ReadConfig(cfgPath);   
    }  
      
    /** 
     * 初始化，读取配置文件 
     * @param cfg 
     */  
    public SchemaTableName(String cfgPath){  
        ReadConfig(cfgPath);   
    }  
      
  
    /** 
     * 自动读取配置信息 
     * @param cfg 
     */  
    private void ReadConfig(String cfgPath){
    	Logger log=LogInit.getlog(getClass());
    	InputStream in=this.getClass().getResourceAsStream(cfgPath);
    	Properties cfg=new Properties();
    	try {
			cfg.load(in);
        tableStyle = cfg.getProperty("tableStyle")==""?TableStyle.FU:TableStyle.valueOf(cfg.getProperty("tablestyle"));  
        tablePrefix = cfg.getProperty("tablePrefix");  
        tableSuffix = cfg.getProperty("tableSuffix");  
        tableSeparator = cfg.getProperty("tableSeparator");  
          
        columnTyle = cfg.getProperty("columnStyle")==""?ColumnTyle.FU:ColumnTyle.valueOf(cfg.getProperty("columntyle"));  
        columnPrefix = cfg.getProperty("columnPrefix");  
        columnSuffix = cfg.getProperty("columnSuffix");  
        columnSeparator = cfg.getProperty("columnSeparator");  
    	} catch (IOException e) {
			log.error("没有找到数据库表命名样式文件",e);
			throw new RuntimeException(e);
		}  
    }  
      
}  