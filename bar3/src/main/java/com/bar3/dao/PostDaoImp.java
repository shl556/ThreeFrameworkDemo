package com.bar3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import com.bar3.basedao.PostDao;
import com.bar3.domain.Post;
import com.bar3.domain.Reply;
import com.bar3.util.HibernateUtil;
import com.bar3.util.LogInit;

public class PostDaoImp implements PostDao{
	private Logger log=LogInit.getlog(getClass());
	@Override
	public Long AddPost(Post post) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		Long id=null;
		try {
			transaction.begin();
            id=(Long)session.save(post);
            transaction.commit();
		}catch(RuntimeException e){
				log.error("新增主题失败",post.toString(),e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
		if(id!=null){
			log.info("新增主题成功！返回id：[{}]",id);
		}
	    return id;
	}

	@Override
	public boolean UpdatePost(Post post) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		boolean success=false;
		try {
			transaction.begin();
            session.update(post);
            transaction.commit();
            log.info("修改主题成功！");
            success=true;
		}catch(RuntimeException e){
				log.error("修改主题失败，主题信息：[{}]",post,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
	    return success;
	}

	@Override
	public boolean DeletePost(Long id) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		boolean success=false;
		try {
			transaction.begin();
            Post post=(Post)session.load(Post.class, id);
            session.delete(post);
            transaction.commit();
            log.info("删除主题成功！");
            success=true;
		}catch(RuntimeException e){
				log.error("删除主题失败，主题id：[{}]",id,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
	    return success;
	}

	@Override
	public Post getPostById(Long id) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
        Post post=null;
		try {
			transaction.begin();
            post=(Post) session.get(Post.class, id);
            transaction.commit();
		}catch(RuntimeException e){
				log.error("查找主题信息失败，主题信息id：[{}]",id,e);
			    transaction.rollback();
				throw new RuntimeException(e);
		}
		if(post!=null){
			log.info("根据id查找主题成功，主题信息：[{}]",post);
		}
		return post;
	}

	@Override
	public List<Reply> getReplysByPostId(Long postId) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.getTransaction();
		String hql="from Reply where postId=?";
		List<Reply> replies=null;
		try{
			transaction.begin();
			Query query=session.createQuery(hql);
			query.setParameter(0, postId);
			query.setComment("查找主题下所有回复");
			replies=query.list();
			transaction.commit();
		}catch(RuntimeException e){
			log.error("查找主题下的所有回复失败，主题id：[{}]",postId,e);
			transaction.rollback();
			throw new RuntimeException(e);
		}
		if(replies!=null){
			log.info("查找主题下的所有回复成功，共找到回复[{}]个",replies.size());
		}
		return replies;
	}
	public static PostDao getInstance(){
		return new PostDaoImp();
	}
}
