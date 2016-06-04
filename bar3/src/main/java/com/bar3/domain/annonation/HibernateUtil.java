package com.bar3.domain.annonation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigUtils;

import com.bar3.util.LogInit;
import com.bar3.util.MyNamingStrategy;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	 private static Logger log =LogInit.getlog(HibernateUtil.class);
//	 private static UserTransaction userTransaction=null;
	  static {
	        try {
	            String cfgPath="config/hibernate.cfg.xml";
	        	//从hibernate.cfg.xml中的Mapping元素加载所有的映射文件
	        	//configue()方法默认从类路径下查找配置文件，也可指定路径
//	            Configuration configuration= new Configuration().configure()
	            Configuration configuration= new Configuration().configure(cfgPath)
	            		//设置命名策略
	                    .setNamingStrategy(new MyNamingStrategy());
	            //得到工厂实例
	            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
	            .applySettings(configuration.getProperties())
	            .build();
	            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	            log.info("获取SessionFactory成功");
//	            userTransaction=(UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
//	            log.info("获取UserTransaction成功");
	        } catch (Exception ex) {
                log.error("获取SessionFactory失败",ex);
	        	throw new ExceptionInInitializerError(ex);
	        }
	    }
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    public static Session getSession(){
	    	return sessionFactory.getCurrentSession();
	    }
	    public static void shutdown() {
	       sessionFactory.close();
	    }
//	    public static UserTransaction getUserTransaction(){
//	    	return userTransaction;
//	    }
	    public static Query setParameters(Query query, Object...objects){
	    	for(int i=0;i<objects.length;i++){
	    		query.setParameter(i, objects[i]);
	    	}
	    	return query;
	    }
}
