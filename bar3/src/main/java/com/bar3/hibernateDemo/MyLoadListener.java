package com.bar3.hibernateDemo;


import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class MyLoadListener extends DefaultLoadEventListener {
  public void onLoad(LoadEvent event, 
    LoadEventListener.LoadType loadType) 
    throws HibernateException {
    
    System.out.println("正在加载OID为"+event.getEntityId()+"的"
      +event.getEntityClassName()+"对象");

    super.onLoad(event,loadType);  //调用父类的onLoad()方法
  }
}



