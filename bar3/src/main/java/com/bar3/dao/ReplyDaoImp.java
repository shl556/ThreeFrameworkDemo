package com.bar3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import com.bar3.basedao.ReplyDao;
import com.bar3.domain.Reply;
import com.bar3.util.HibernateUtil;
import com.bar3.util.LogInit;

public class ReplyDaoImp implements ReplyDao{
	private Logger log=LogInit.getlog(getClass());
	@Override
	public Long addReply(Reply reply) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		Long id=null;
		try {
			transaction.begin();
            id=(Long)session.save(reply);
            transaction.commit();
		}catch(RuntimeException e){
				log.error("新增回复失败",reply.toString(),e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
		if(id!=null){
			log.info("新增回复成功！返回id：[{}]",id);
		}
	    return id;
	}

	@Override
	public boolean deleteReplyById(Long id) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		boolean success=false;
		try {
			transaction.begin();
            Reply reply=(Reply)session.load(Reply.class, id);
            session.delete(reply);
            transaction.commit();
            log.info("删除回复成功！");
            success=true;
		}catch(RuntimeException e){
				log.error("删除回复失败，回复id：[{}]",id,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
	    return success;
	}

	@Override
	public boolean updateReply(Reply reply) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		boolean success=false;
		try {
			transaction.begin();
            session.update(reply);
            transaction.commit();
            log.info("修改回复成功！");
            success=true;
		}catch(RuntimeException e){
				log.error("修改回复失败，回复信息：[{}]",reply,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
	    return success;
	}

	@Override
	public Reply getReplyById(Long id) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
        Reply reply=null;
		try {
			transaction.begin();
            reply=(Reply) session.get(Reply.class, id);
            transaction.commit();
		}catch(RuntimeException e){
				log.error("查找回复信息失败，回复信息id：[{}]",id,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
		if(reply!=null){
			log.info("根据id查找回复成功，回复信息：[{}]",reply);
		}
		return reply;
	}
	public static ReplyDao getInstance(){
		return new ReplyDaoImp();
	}
}
