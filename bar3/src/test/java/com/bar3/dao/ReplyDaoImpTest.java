package com.bar3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bar3.basedao.ReplyDao;
import com.bar3.domain.Post;
import com.bar3.domain.Reply;
import com.bar3.domain.User;
import com.bar3.util.HibernateUtil;

public class ReplyDaoImpTest {
    private static ReplyDao replyDao =null;
    private static Session session=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		replyDao =ReplyDaoImp.getInstance();
		session=HibernateUtil.getSession();
	}

	@Test
	public void testAddReply() {
		Reply reply=new Reply();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        User user=(User) session.load(User.class, new Long(1));
	    Post post=(Post) session.load(Post.class, new Long(2));
	    transaction.commit();
	    reply.setPost(post);
	    reply.setUser(user);
	    reply.setReplyContent("jsp的foreach标签怎么用");
	    Long id=replyDao.addReply(reply);
	    System.out.println(id);
	}

	@Test
	public void testDeleteReplyById() {
		boolean success=replyDao.deleteReplyById(new Long(2));
		System.out.println(success);
	}

	@Test
	public void testUpdateReply() {
		Reply reply=replyDao.getReplyById(new Long(1));
		reply.setReplyContent("JSP的import标签怎么使用");
		boolean success=replyDao.updateReply(reply);
	    System.out.println(success);
	}
	

	@Test
	public void testGetReplyById() {
		Reply reply=replyDao.getReplyById(new Long(1));
		System.out.println(reply);
	}

}
