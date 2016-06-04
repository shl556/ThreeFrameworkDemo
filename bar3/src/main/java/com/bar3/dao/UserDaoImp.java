package com.bar3.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import com.bar3.basedao.UserDao;
import com.bar3.domain.User;
import com.bar3.util.HibernateUtil;
import com.bar3.util.LogInit;
import com.bar3.util.ParameterList;

public class UserDaoImp implements UserDao{
    private Logger log=LogInit.getlog(getClass());
//    private UserTransaction userTransaction=HibernateUtil.getUserTransaction();
//	@Override
//	public Long addUser(User user) {
//		Session session=HibernateUtil.getSession();
//		Long id=null;
//		try {
////            userTransaction.begin();
//            id=(Long)session.save(user);
////            userTransaction.commit();
//			}catch(Exception e){
//				log.error("新增用户失败",user.toString(),e);
//				try {
//					userTransaction.rollback();
//				} catch (Exception e1) {
//					log.error("回滚失败",e1);
//					throw new RuntimeException(e1);
//				} 
//				throw new RuntimeException(e);
//			}
//		if(id!=null){
//			log.info("新增用户成功！返回id：[{}]",id);
//		}
//	    return id;
//	}
	@Override
	public Long addUser(User user) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		Long id=null;
		try {
			transaction.begin();
            id=(Long)session.save(user);
            transaction.commit();
		}catch(RuntimeException e){
				log.error("新增用户失败",user.toString(),e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
		if(id!=null){
			log.info("新增用户成功！返回id：[{}]",id);
		}
	    return id;
	}

	/*@Override
	public User getUserById(Long id) {
		User user=null;
		Session session=HibernateUtil.getSession();
		try {
			userTransaction.begin();
			user=(User) session.get(User.class, id);
		    userTransaction.commit();
			}catch (NotSupportedException | SystemException e) {
				log.info("开启事务失败");
				throw new RuntimeException(e);
			}catch (RuntimeException e) {
				log.info("根据id查找用户失败，id：[{}]",id,e);
				try {
					userTransaction.rollback();
				} catch (IllegalStateException | SecurityException | SystemException e1) {
					log.info("回滚失败",e);
					throw new RuntimeException(e);
				}
				throw new RuntimeException(e);
			}catch (RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				log.info("提交事务失败",e);
				throw new RuntimeException(e);
			}
		if(user!=null){
			log.info("根据id查找用户成功，用户信息：[{}]",user.toString());
		}
		return user;
	}*/
	@Override
	public User getUserById(Long id) {
		User user=null;
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			user=(User) session.get(User.class, id);
		    transaction.commit();
			}catch (RuntimeException e) {
				log.error("根据id查找用户失败，id：[{}]",id,e);
			    transaction.rollback();
				throw new RuntimeException(e);
			}
		if(user!=null){
			log.info("根据id查找用户成功，用户信息：[{}]",user.toString());
		}
		return user;
	}
	/*@Override
	public User doLogin(String lgName, String lgPass) {
		User user=null;
		Session session=HibernateUtil.getSession();
		ParameterList parameterList=new ParameterList(lgName,lgPass);
		try {
			userTransaction.begin();
			String hql="from User user where user.lgName=? and user.lgPass=?";
			Query query=session.createQuery(hql);
			query=HibernateUtil.setParameters(query, parameterList.toAarry());
		    user=(User) query.uniqueResult();
			userTransaction.commit();
			}catch (NotSupportedException | SystemException e) {
				log.info("开启事务失败");
				throw new RuntimeException(e);
			}catch (RuntimeException e) {
				log.info("验证用户名用户密码失败，参数：[{}]",parameterList,e);
				try {
					userTransaction.rollback();
				} catch (IllegalStateException | SecurityException | SystemException e1) {
					log.info("回滚失败",e);
					throw new RuntimeException(e);
				}
				throw new RuntimeException(e);
			}catch (RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				log.info("提交事务失败",e);
				throw new RuntimeException(e);
			}
		if(user!=null){
			log.info("根据id查找用户成功，用户信息：[{}]",user.toString());
		}
		return user;
	}*/
	
	@Override
	public User doLogin(String lgName, String lgPass) {
		User user=null;
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		ParameterList parameterList=new ParameterList(lgName,lgPass);
		try {
			transaction.begin();
			String hql="from User user where user.lgName=? and user.lgPass=?";
			Query query=session.createQuery(hql);
			query=HibernateUtil.setParameters(query, parameterList.toAarry());
		    query.setComment("验证用户名和密码");
			user=(User) query.uniqueResult();
			transaction.commit();
			}catch (RuntimeException e) {
				log.info("验证用户名用户密码失败，参数：[{}]",parameterList,e);
			    transaction.rollback();
				throw new RuntimeException(e);
			}
		if(user!=null){
			log.info("验证用户名与密码成功，用户信息：[{}]",user.toString());
		}
		return user;
	}
    public static UserDao getInstance(){
    	return new UserDaoImp();
    }
}
