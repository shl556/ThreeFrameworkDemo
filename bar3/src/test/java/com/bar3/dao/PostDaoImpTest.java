package com.bar3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bar3.basedao.PostDao;
import com.bar3.domain.Kind;
import com.bar3.domain.Post;
import com.bar3.domain.Reply;
import com.bar3.domain.User;
import com.bar3.util.HibernateUtil;

public class PostDaoImpTest {
    private static PostDao postDao =null;
    private static Session session=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	   postDao=PostDaoImp.getInstance();
	   session=HibernateUtil.getSession();
	}

	@Test
	public void testAddPost() {
       Post post=new Post();
       post.setPostContent("JSP设计很有意思");
       Transaction transaction=session.getTransaction();
       transaction.begin();
       Kind kind=(Kind) session.load(Kind.class, new Long(1));
	   User user=(User) session.load(User.class, new Long(1));
	   transaction.commit();
	   post.setUser(user);
	   post.setKind(kind);
	   post.setTitle("Jsp设计问题");
	   Long id=postDao.AddPost(post);
	   System.out.println(id);
	   post.setPostContent("JSP设计很简单");
       id=postDao.AddPost(post);	   
	   System.out.println(id);
	   
	}

	@Test
	public void testUpdatePost() {
		Post post=postDao.getPostById(new Long(1));
		post.setTitle("Jsp设计");
	    boolean success=postDao.UpdatePost(post);
	    System.out.println(success);
	}

	@Test
	public void testDeletePost() {
	   boolean success=postDao.DeletePost(new Long(1));
	   System.out.println(success);
	}

	@Test
	public void testGetPostById() {
		Post post=postDao.getPostById(new Long(2));
		System.out.println(post);
	}

	@Test
	public void testGetReplysByPostId() {
		List<Reply> replies=postDao.getReplysByPostId(new Long(2));
		System.out.println(replies);
	}

}
