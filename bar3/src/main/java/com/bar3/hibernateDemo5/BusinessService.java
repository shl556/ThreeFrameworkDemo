package com.bar3.hibernateDemo5;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.*;
import java.sql.*;

public class BusinessService{
  public static SessionFactory sessionFactory;
  static{
     try{
    	 Configuration configuration= new Configuration().configure();
         //得到工厂实例
         ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
         .applySettings(configuration.getProperties())
         .build();
         sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }catch(RuntimeException e){e.printStackTrace();throw e;}

  }

  public void saveCustomer(Customer customer){
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      List results=new ArrayList();
      try {
       tx = session.beginTransaction();
       session.save(customer);
       tx.commit();
    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public Customer loadCustomer(long id){
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      try {
       tx = session.beginTransaction();
       Customer customer=(Customer)session.get(Customer.class,new Long(id));
       Hibernate.initialize(customer.getImages());
       tx.commit();
      return customer;
    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

   @SuppressWarnings("unchecked")
public void test(){
      Map images=new TreeMap();
      images.put("image1","image1.jpg");
      images.put("image4","image4.jpg");
      images.put("image2","image2.jpg");
      images.put("imageTwo","image2.jpg");
      images.put("image5","image5.jpg");
      
      Customer customer=new Customer("Tom",21,images);
      saveCustomer(customer);
      
      customer=loadCustomer(1);
      printCustomer(customer);  

  }

  private void printCustomer(Customer customer){
     System.out.println(customer.getImages().getClass().getName());
     Map images=customer.getImages();
     Set keys=images.keySet();
     Iterator it=keys.iterator();
     while(it.hasNext()){
       String key=(String)it.next();
       String filename=(String)images.get(key);
       System.out.println(customer.getName()+" "+key+" "+filename);
     }

  }
  public static void main(String args[]) {
    new BusinessService().test();
    sessionFactory.close();
  }
}
