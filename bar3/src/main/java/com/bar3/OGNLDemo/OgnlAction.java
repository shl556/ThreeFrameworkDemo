package com.bar3.OGNLDemo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OgnlAction extends ActionSupport {
	private List<Person> persons;
	private static String test="ognlDemo";
	@Override
    public String execute() throws Exception {  
       /* // 获得ActionContext实例，以便访问Servlet API  
        ActionContext ctx = ActionContext.getContext();  
        // 存入application  
        ctx.getApplication().put("msg", "application信息");  
        // 保存session  
        ctx.getSession().put("msg", "seesion信息");  
        // 保存request信息  
        HttpServletRequest request = ServletActionContext.getRequest();  
        request.setAttribute("msg", "request信息");  
        // 为persons赋值  
        persons = new LinkedList<Person>();  
        Person person1 = new Person();  
        person1.setName("pla1");  
        person1.setAge(26);  
        person1.setBirthday(new Date());  
        persons.add(person1);  
  
        Person person2 = new Person();  
        person2.setName("pla2");  
        person2.setAge(36);  
        person2.setBirthday(new Date());  
        persons.add(person2);  
  
        Person person3 = new Person();  
        person3.setName("pla3");  
        person3.setAge(16);  
        person3.setBirthday(new Date());  
        persons.add(person3);  */
        ValueStack valueStack=ActionContext.getContext().getValueStack();
        Person person2 = new Person();  
        person2.setName("pla2");  
        person2.setAge(36);  
        person2.setBirthday(new Date()); 
        valueStack.push(person2);
        Dog dog=new Dog();
        dog.setName("dog");
        valueStack.push(dog);
        //如果栈顶不是一个map则新建一个map将名值对加入map并将map放进栈顶，如果栈顶是一个map则将名值对放进该map中
        valueStack.set("name", "shl");
        person2.setName("hong1");
        valueStack.push(person2);
        //对值栈中的bean赋值，会从栈顶开始依次往下查找调用setName方法,直到找到第一个为止。另外值栈中存放的是对象的引用，同一个对象
        //的多个引用被放入值栈中，修改其中任何一个对象的属性，其他对象的属性也会相应修改
        valueStack.setValue("name", "sunhongliang");
        return SUCCESS;  
  
    }  
    public String getName(){
    	return "sun";
    }
    public List<Person> getPersons() {  
        return persons;  
    }  
  
    public void setPersons(List<Person> persons) {  
        this.persons = persons;  
    }   
}
