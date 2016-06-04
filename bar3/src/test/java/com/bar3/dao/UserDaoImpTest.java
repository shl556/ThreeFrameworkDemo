package com.bar3.dao;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bar3.basedao.UserDao;
import com.bar3.domain.User;

public class UserDaoImpTest {
    private static UserDao userDao =null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	   userDao=UserDaoImp.getInstance();
	}

	@Test
	public void testAddUser() {
	   User test=new User();
	   test.setLgName("admin");
	   test.setLgPass("admin");
	   test.setNickName("孙大圣");
	   test.setSex(1);
	   test.setHeadName("1.gif");
	   Long id=userDao.addUser(test);
	   System.out.println(id);
	}

	@Test
	public void testGetUserById() {
		User user=userDao.getUserById(new Long(2));
		System.out.println(user);
	}

	@Test
	public void testDoLogin() {
		User user=userDao.doLogin("sun", "admin1");
		System.out.println(user);
	}

}
