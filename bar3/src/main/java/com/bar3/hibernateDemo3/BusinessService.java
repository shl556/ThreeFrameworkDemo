package com.bar3.hibernateDemo3;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.sql.Blob;
import java.io.*;

public class BusinessService{
  public static SessionFactory sessionFactory;
  static{
     try{
       Configuration config = new Configuration();
       config.configure();
       sessionFactory = config.buildSessionFactory();
    }catch(RuntimeException e){e.printStackTrace();throw e;}
  }

  public Long saveCustomer()throws Exception{
    //读取photo.gif文件的二进制数据
    InputStream in=this.getClass().getResourceAsStream("photo.gif");
    byte[] buffer = new byte[in.available()];
    in.read(buffer);
    in.close();
 
    Session session = sessionFactory.openSession();
    Transaction  tx = session.beginTransaction();

    Customer customer=new Customer();
    customer.setName("Tom");
    customer.setImage(Hibernate.getLobCreator(session).createBlob(buffer));
    session.save(customer);
 
    tx.commit();
    session.close();
    return customer.getId();
  }

  public Long saveCustomer1()throws Exception{

    //读取photo.gif文件的二进制数据
    InputStream in=this.getClass().getResourceAsStream("photo.gif");
    byte[] buffer = new byte[in.available()];
    in.read(buffer);
    in.close();

    Session session = sessionFactory.openSession();
    Transaction  tx = session.beginTransaction();

    Customer customer=new Customer();
    customer.setName("Tom");
    //创建一个空的Blob对象 
    customer.setImage(Hibernate.getLobCreator(session).createBlob(buffer));
    session.save(customer);
    
    session.flush();
    //锁定这条记录
    session.refresh(customer, LockOptions.UPGRADE);
    java.sql.Blob image = customer.getImage();
    OutputStream out=image.setBinaryStream(1);
    out.write(buffer); 
    out.close();

    tx.commit();
    session.close();

    return customer.getId();
  }
  public void loadCustomer(Long id) throws Exception{
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    Customer customer=(Customer)session.get(Customer.class,id);
    getBlob(customer);
    tx.commit();
    session.close();
  }

  public void getBlob(Customer customer)throws Exception{
    Blob image=customer.getImage();  
    InputStream in=image.getBinaryStream();
    FileOutputStream fout = new FileOutputStream("11.3\\photo_bak.gif");  
    int b=-1;
    while((b=in.read())!=-1)           
    fout.write(b);
    fout.close();
    in.close();
  }

  public void test() throws Exception{
      Long id=saveCustomer();
      loadCustomer(id);
  }

  public static void main(String args[]) throws Exception {
    new BusinessService().test();
    sessionFactory.close();
  }
}

