package com.bar3.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class AuditLog{

     public static void logEvent(String message,Auditable entity,Session session) {
      Session tempSession=null;
      try{
      	SessionFactory sessionFactory=session.getSessionFactory();
      	tempSession=sessionFactory.getCurrentSession();
        AuditLogRecord record=new AuditLogRecord(message,entity.getId(),entity.getClass(),null);
	tempSession.save(record);
	tempSession.flush();

      }catch(Exception e){e.printStackTrace();}
      finally{
        try{tempSession.close();}catch(Exception e){e.printStackTrace();}
      }
    }
}


