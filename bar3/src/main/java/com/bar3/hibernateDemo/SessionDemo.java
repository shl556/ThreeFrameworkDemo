package com.bar3.hibernateDemo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bar3.util.HibernateUtil;
/*
 * save()方法是用来持久化一个临时对象的，在应用程序中不应该把持久化对象传给或者游离对象传给save()方法，前者是多余的操作，因为
 * hibernate在清理缓存时会进行脏检查并自动执行相关的更新操作。后者则是导致数据库有两条OID相同但业务数据相同的记录不符合业务逻辑。
 * persist()方法不保证立即为持久化对象的OID赋值，而是有可能在Session清理缓存时才为OID赋值。save()方法因为要返回被保存对象
 * 的OID所以会立即为持久化对象的OID赋值，具体过程是先查找数据记录中ID的最大值然后标识符生成器根据该最大值生成被持久化对象的OID.
 * 此外如果在事务边界以外调用persist()方法，那么该方法不会计划执行SQL insert语句，这可以提高负责长时间运行事务的程序的健壮性
 *
 */
/*
 * load()方法和get()方法都能根据给定的OID从数据库中加载一个持久化对象，其区别是：一、当数据库中不存在与OID对应的记录时，load()方法
 * 会抛出异常而get()方法返回null。二、load()方法会根据class元素的lazy属性值决定所采用的检索策略，lazy的属性值默认为false即默认采用
 * 延迟检索策略，即当应用程序实际需要访问对象的属性时才到数据库中查找相关属性信息，否则其所加载的对象只有OID属性，其他属性为空。如果lazy的属性
 * 为false则采用立即检索策略，即会立即到数据库中查找相关的属性并加载到持久化对象中。get()方法会忽略lazy的属性值，总是采用立即检索策略。
 * 如果加载一个对象是为了访问它的各个属性值，可以用get()方法，如果加载一个对象是为了删除它或者建立与别的对象的关联关系时可以用load()方法。
 *
 */
/*
 * update()方法使一个游离对象转变为持久化对象，并且会计划执行一条update语句，无论该对象的属性是否改变。如果希望session仅当修改了对象属性
 * 时才执行update语句可以将class元素的select-before-update属性的值设为true，默认为false。设为true时，会先从数据库中查询该对象
 * 将数据库中查询到的对象的属性与缓存中的对象的属性比较，如果不一致才执行update语句。需要注意的是session只有在清理缓存的时候才会执行insert语句，
 * 并且在执行时才会把被更新对象的当前属性值组装到update语句中。另外当update方法关联一个游离对象时，如果在session的缓存中已经存在相同的持久化
 * 对象则会抛出异常。
 */
/*
 * saveOrUpdate()方法同时包含了save()和update()方法的功能，如果传入的是一个临时对象则调用save()方法，如果传入的参数是游离对象则调用update()
 * 方法，如果传入的参数是持久化对象则直接返回。
 */
/*
 * merge()方法能够把一个游离对象或者临时对象的属性复制到一个持久化对象中，返回该持久化对象的引用。会根据merge方法传入的对象A的OID去缓存中查找是否有相同的
 * OID的持久化对象B，如果有则将A中的所有值类型的属性和集合类型的属性赋值到B中然后返回B的引用。如果没有找到相同OID的持久化对象，根据OID到数据库中加载这个对象C，
 * 如果C存在，就把A中的值类型属性和集合类型属性复制到C中并计划执行一条update语句，返回C的引用。如果数据库中没有相同OID的记录则创建一个新的对象D将A的属性复制
 * 到D中，执行save()方法，返回D的引用。
 */
/*
 * delete()方法用于从数据库中删除一个对象，既可以删除游离对象也可以删除临时对象，如果是游离对象则先将游离对象被当前session关联转变成持久化对象，即加入到session
 * 缓存中。执行delete()方法后对象有持久化状态转变成删除状态，处于删除状态的对象时无用对象，程序不应该再使用这些对象。如果希望被删除的对象可以继续使用，可以
 * 在配置文件中设置hibernate——use——identifier——rollback的属性设为true，默认为false。设为true后执行delete()方法时会从持久化对象转变成临时对象，
 * OID属性为null。
 */
/*
 * replicate()方法能够把一个数据库中的对象复制到另一个数据库中。具体而言就是把数据库A中的游离对象B持久化到数据库C中。replicate()的第二个参数决定了
 * 复制的模式，通常采用LATET_VERSION模式。
 */
/*
 * flush()方法会强制hibernate清理缓存执行相应的SQL语句，refresh()方法会根据传入对象的OID到数据库中重新加载该对象。
 */
/*
 * 
 */
/*
 * 
 */
public class SessionDemo {
	private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	public void saveFoodCategory(){
	      Category  foodCategory=new Category("food",new HashSet<Category>(),null);
	      Category  fruitCategory=new Category("fruit",new HashSet<Category>(),null);
	      Category  appleCategory=new Category("apple",new HashSet<Category>(),null);
	      //建立食品类别和水果类别之间的关联关系
	      foodCategory.addChildCategory(fruitCategory);
	       //建立水果类别和苹果类别之间的关联关系
	      fruitCategory.addChildCategory(appleCategory);
	       saveOrUpdate(foodCategory);
	  }

	  public void navigateCategories(){
	      Category fruitCategory=findCategoryByName("fruit");
	      HashSet<Category> categories=new HashSet<Category>();
	      navigateCategories(fruitCategory,categories);
	      for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
	         System.out.println(((Category)it.next()).getName());
	      }
	  }
	  private void navigateCategories(Category category,Set<Category> categories){
	   if(categories.contains(category)|| category==null)return;
	   categories.add(category);
	   //遍历父类Category
	   navigateCategories(category.getParentCategory(),categories);
	   //遍历所有子类Category
	   Set<Category> childCategories=category.getChildCategories();
	   if(childCategories==null)return;
	   for (Iterator<Category> it = childCategories.iterator(); it.hasNext();) {
	         navigateCategories((Category)it.next(),categories);
	    }
	  }
	  public void saveVegetableCategory(){
	      Category foodCategory=findCategoryByName("food");
	      Category vegetableCategory=new Category("vegetable",new HashSet<Category>(),null);
	      foodCategory.addChildCategory(vegetableCategory);
	      saveOrUpdate(vegetableCategory);

	  }

	  public void updateVegetableCategory(){
	      Category vegetableCategory=findCategoryByName("vegetable");
	      vegetableCategory.setName("green vegetable");
	      Category tomatoCategory=new Category("tomato",new HashSet<Category>(),null);
	      vegetableCategory.addChildCategory(tomatoCategory);
	      saveOrUpdate(vegetableCategory);

	  }
	  public void saveOrangeCategory(){
	    Session session =sessionFactory.openSession();
	    Transaction tx = null;
	    try {
	      tx = session.beginTransaction();
	      Category fruitCategory=findCategoryByName(session,"fruit");
	      Category orangeCategory=new Category("orange",new HashSet<Category>(),null);
	      fruitCategory.addChildCategory(orangeCategory);
	      tx.commit();
	    }catch (RuntimeException e) {
	      if (tx != null) {
	        // Something went wrong; discard all partial changes
	        tx.rollback();
	      }
	      throw e;
	    } finally {
	      // No matter what, close the session
	      session.close();
	    }
	  }
	  public void saveOrUpdate(Object object){
	    Session session =sessionFactory.openSession();
	    Transaction tx = null;
	    try {
	      tx = session.beginTransaction();
	      //saveOrUpdate()方法没有返回值
//	     session.saveOrUpdate(object);
	      //save()方法返回插入的对象的id
	      Long id=(Long) session.save(object);
	      System.out.println("id="+id);
	      System.out.println(session.save(object).getClass().getSimpleName());
	      tx.commit();
	    }catch (RuntimeException e) {
	      if (tx != null) {
	        // Something went wrong; discard all partial changes
	        tx.rollback();
	      }
	      throw e;
	    } finally {
	      // No matter what, close the session
	      session.close();
	    }
	  }

	   private Category findCategoryByName(String name){
	    Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    Category category=null;
	    try {
	      tx = session.beginTransaction();
	      @SuppressWarnings("unchecked")
		List<Category> results=session.createQuery("from Category as c where c.name='"+name+"'").list();
	      category=(Category)results.iterator().next();

	      tx.commit();
	                  ;
	    }catch (RuntimeException e) {
	      if (tx != null) {
	        // Something went wrong; discard all partial changes
	        tx.rollback();
	      }
	      throw e;
	    } finally {
	      // No matter what, close the session
	      session.close();
	    }
	    return category;
	  }

	   private Category findCategoryByName(Session session, String name){
	      @SuppressWarnings("unchecked")
		List<Category> results=session.createQuery("from Category as c where c.name='"+name+"'").list();
	      return (Category)results.iterator().next();
	  }

	   public void test(){
//	      saveFoodCategory();
//	      saveOrangeCategory();
//	      saveVegetableCategory();
//	      updateVegetableCategory();
//	      navigateCategories();
		  Category category=new Category("apple", null, null);
		  saveOrUpdate(category);
	   }

	  public static void main(String args[]){
	    new SessionDemo().test();
	    sessionFactory.close();
	  }
}
