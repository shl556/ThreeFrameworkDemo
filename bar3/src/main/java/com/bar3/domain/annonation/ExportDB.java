package com.bar3.domain.annonation;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.slf4j.Logger;

import com.bar3.util.LogInit;
import com.bar3.util.MyNamingStrategy;

public class ExportDB {
	public static void main(String[] args) {
		Logger log=LogInit.getlog("ExportDB");
		String cfgPath="resource/hibernate.cfg.xml";
		// 从默认路径读取hibernate.cfg.xml文件    
//        Configuration cfg = new Configuration().configure();    
        //从指定路径读取hibernate.cfg.xml文件   
        Configuration cfg= new Configuration().configure(cfgPath);
        		//设置命名策略
//                .setNamingStrategy(new MyNamingStrategy());    
        // 生成并输出sql到文件（当前目录）和数据库    
        SchemaExport export = new SchemaExport(cfg);    
        //设置生成sql的输出文件地址
        export.setOutputFile("src/main/java/config/sample.sql");
        //设置是否对输出的sql格式化显示
        export.setFormat(true);
        // 创建表结构，第一个true 表示在控制台打印sql语句，第二个true 表示导入sql语句到数据库  
        export.create(true, true);   
	}
}
