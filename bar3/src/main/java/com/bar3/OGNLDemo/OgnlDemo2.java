package com.bar3.OGNLDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ognl.Ognl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

public class OgnlDemo2 {
	@Test
	public void testOgnl01() throws Exception {
		User user = new User();
		user.setUsername("张三");
		// 利用OGNL表达式访问user对象的username属性
		String value = (String) Ognl.getValue("username", user);
		log(value);
	}
	@Test
	public void testOgnl02() throws Exception {
		User user = new User();
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);
		// 用JAVA来导航访问
		System.out.println(StringUtils.center("Java导航", 50, "=="));
		log(user.getGroup().getOrg().getOrgId());
		// 利用OGNL表达式访问
		System.out.println(StringUtils.center("OGNL导航", 50, "=="));
		// String value = (String)Ognl.getValue("group.org.orgId", user);
		// 也可以在表达式中使用#root来代表root对象
		String value = (String) Ognl.getValue("#root.group.org.orgId", user);
		log(value);
	}
	@Test
	public void testOgnl04() throws Exception {
		User user = new User();
		user.setUsername("张三");
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);
		User user2 = new User();
		user2.setUsername("李四");
		/**
		 * 所谓context其实就是一个Map类型的对象。主要是因为在OGNL中，不支持多个root对象，那么
		 * 如果需要在表达式中访问更多毫不相干的对象时，只能通过一个Map来把这些对象统一传递给OGNL。
		 */
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put("u1", user);
		context.put("u2", user2);
		// 在表达式中需通过“#+对象的名称”来访问context中的对象
		// 如果表达式中没有用到root对象，那么可以用任意一个对象代表root对象！
		System.out.println(StringUtils.center("OGNLContext应用", 50, "=="));
		String value = (String) Ognl.getValue("#u1.username + ',' + #u2.username", context, new Object());
		log(value);
	}
	@Test
	public void testOgnl05() throws Exception {
		User user = new User();
		user.setUsername("张三");
		Group g = new Group();
		Organization o = new Organization();
		o.setOrgId("ORGID");
		g.setOrg(o);
		user.setGroup(g);
		User user2 = new User();
		user2.setUsername("李四");
		User user3 = new User();
		user3.setUsername("王五");
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put("u1", user);
		context.put("u2", user2);
		// 给OGNL传递root对象及context对象，以便解释对应的表达式
		String value = (String) Ognl.getValue("#u1.username + ',' + #u2.username + ',' + username", context, user3);
		log(value);
	}
	@Test
	public void testOgnl06() throws Exception {
		User user = new User();
		// 调用setValue()方法来进行赋值
		// 第一个参数：OGNL表达式
		// 第二个参数：root对象
		// 第三个参数：要赋的值
		System.out.println(StringUtils.center("OGNL赋值", 50, "=="));
		Ognl.setValue("username", user, "张三");
		log(user.getUsername());
	}
	@Test
	public void testOgnl08() throws Exception {
		User user = new User();
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put("u", user);
		// 利用赋值符号"="来进行赋值
		Ognl.getValue("#u.username = '李四'", context, new Object());
		log(user.getUsername());
	}
	@Test
	public void testOgnl09() throws Exception {
		User user1 = new User();
		User user2 = new User();
		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put("u1", user1);
		context.put("u2", user2);
		// 在一个表达式中可以用逗号分隔，同时执行多个表达式
		Ognl.getValue("#u1.username = '李四',#u2.username='王五'", context, new Object());
		log(user1.getUsername());
		log(user2.getUsername());
	}
	@Ignore
	@Test
	public void testOgnl10() throws Exception {
		User user = new User();
		// 如果是调用root对象的方法，可以直接使用方法的名称来调用方法,指定方法不存在返回空
		System.out.println(StringUtils.center("OGNL调用方法", 50, "=="));
		Integer value = (Integer) Ognl.getValue("addSomething(1,1)", user);
		log(value);
	}
	@Test
	public void testOgnl11() throws Exception {
		User user = new User();
		user.setUsername("李四");
		// 如果是调用root对象的方法，可以直接使用方法的名称来调用方法
		String value = (String) Ognl.getValue("getUsername()", user);
		log(value);
	}
	@Test
	public void testOgnl12() throws Exception {
		User user = new User();
		Ognl.getValue("setUsername('王五')", user);
		String value = (String) Ognl.getValue("getUsername()", user);
		log("12:" + value);
	}
	@Test
	public void testOgnl13() throws Exception {
		User user = new User();
		user.setUsername("王五");
		// 调用静态变量
		// 注意：out是System中的静态变量，out是PrintStream类型的一个对象
		// 而println()则是out这个对象中的实例方法（不是静态方法）
		// 调用静态方法，需要在类名和变量名前面加上@来调用，对于实例方法，用"."来调用
		System.out.println(StringUtils.center("OGNL调用静态方法和静态变量", 50, "=="));
		String value = (String) Ognl.getValue("@System@out.println(username)", user);
		// log("13:"+value);
	}
	@Test
	public void testOgnl14() throws Exception {
		User user = new User();
		user.setUsername("wangwu");
		// 调用静态方法,注意使用全路径类名
		Ognl.getValue("@System@out.println(@org.apache.commons.lang3.StringUtils@upperCase(username))", user);
	}
	@Test
	public void testOgnl15() throws Exception {
		Object root = new Object();
		Map<Object, Object> context = new HashMap<Object, Object>();
		// 利用OGNL创建java.util.List对象
		List list = (List) Ognl.getValue("{123,'xxx','kdjfk'}", context, root);
		context.put("list", list);
		// 利用OGNL创建数组
		int[] intarray = (int[]) Ognl.getValue("new int[]{23,45,67}", context, root);
		context.put("intarray", intarray);
		// 利用OGNL表达式创建java.util.Map对象
		Map mapvalue = (Map) Ognl.getValue("#{'listvalue':#list,'intvalue':#intarray}", context, root);
		context.put("mapvalue", mapvalue);
		// 利用OGNL表达式访问这些数组和集合对象
		System.out.println(StringUtils.center("OGNL创建并操纵集合", 50, "=="));
		Ognl.getValue("@System@out.println(#list[1])", context, root);
		Ognl.getValue("@System@out.println(#intarray[2])", context, root);
		Ognl.getValue("@System@out.println(#mapvalue.listvalue[0])", context, root);
		Ognl.getValue("@System@out.println(#mapvalue['intvalue'][0])", context, root);
	}
	@Test
	public void testOgnl16() throws Exception {
		List root = new ArrayList();
		User user1 = new User();
		user1.setUsername("张三");
		User user2 = new User();
		user2.setUsername("李四");
		root.add(user1);
		root.add(user2);
		// 如果root对象是List类型
		log(Ognl.getValue("#root[0].username", root));
		log(Ognl.getValue("#root[1].username", root));
	}
	private void log(Object obj) {
		System.out.println(obj);
	}
}
