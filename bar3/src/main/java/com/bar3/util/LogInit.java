package com.bar3.util;

import java.io.InputStream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.*;
public class LogInit {
   static{
	   String uri="/config/log4j.properties";
	   System.out.println("初始化日志配置文件");
	   InputStream in =LogInit.class.getResourceAsStream(uri);
	   if(in!=null){
		   PropertyConfigurator.configure(in);
		   Logger log=LoggerFactory.getLogger(LogInit.class);
		   log.info("加载日志配置文件成功！");
	   }else{
		   BasicConfigurator.configure();
		   Logger log=LoggerFactory.getLogger(LogInit.class);
		   log.error("没有找到日志配置文件");
	   }		
   }
   private LogInit(){
	   
   }
   public static Logger getlog(Class classname){
	   Logger log=LoggerFactory.getLogger(classname);
	   return log;
   }
   public static Logger getlog(String classname){
	   Logger log=LoggerFactory.getLogger(classname);
	   return log;
   }
   
}
