package com.bar3.hibernateDemo4;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.sql.*;

public class BusinessService{
  public static SessionFactory sessionFactory;
  static{
     try{
       Configuration config = new Configuration().configure();
       sessionFactory = config.buildSessionFactory();
    }catch(RuntimeException e){e.printStackTrace();throw e;}

  }

  public void saveDO(DOClass f){
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      List results=new ArrayList();
      try {
       tx = session.beginTransaction();
       session.save(f);
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


   public void test() {
      ClassG g=new ClassG("a1","d1","g1");
      saveDO(g);
      
      ClassF f=new ClassF("b1","f1","f2","f3","f4","f5","f6");
      saveDO(f);
  }

  public static void main(String args[]) {
    new BusinessService().test();
    sessionFactory.close();
  }
}

