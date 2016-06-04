package com.bar3.strustDemo;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 模型驱动模式下实现ModelDriven接口即可，由相应的拦截器调用getModel方法返回一个实例化的Model，
 * 拦截器通过beanUtils对该实例赋值。不需要为model提供对应的set或者get方法，当页面需要调用model中
 * 的属性时，如果action实例中没有，strust会自动到与之关联的model实例中查找。
 *  模型驱动模式下，model作为一个单独的实体放到了栈顶，可以直接访问其属性。因为没有提供对model的get和set方法
 *  不能通过model间接访问其属性。
 */
public class ModerDrivenDemo implements ModelDriven<User>,Action{
    private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public String execute() throws Exception
	{
		String userName=user.getUsername();
		if(StringUtils.isEmpty(userName)){
			return INPUT;
		}
		// 获取ActionContext实例，通过该实例访问Servlet API
		ActionContext ctx = ActionContext.getContext();
		// 获取ServletContext里的counter属性
		Integer counter = (Integer)ctx
			.getApplication().get("counter");
		// 如果counter属性为null，设置该counter属性为1
		if (counter == null)
		{
			counter = 1;
		}
		// 否则，将counter加1
		else
		{
			counter = counter + 1;
		}
		// 将增加1后的counter值设置成counter属性
		ctx.getApplication().put("counter" , counter);
		// 将登录用的username属性设置成一个HttpSession属性
		ctx.getSession().put("user" , userName);
		// 如果用户名为crazyit，密码为leegang
		if (userName.equals("crazyit")
			&& user.getPassword().equals("leegang") )
		{
			// 直接设置HttpServletRequest属性，
			// request.setAttribute("tip" , "服务器提示：您已经成功的登录");
			// 下面代码的作用类似于设置HttpServletRequest属性
			ctx.put("tip" , "服务器提示：您已经成功的登录");
//			addActionMessage("恭喜您成功登陆");
			return SUCCESS;
		}
		else
		{
			// 通过ActionContext设置HttpServletRequest属性
			ctx.put("tip" , "服务器提示：登录失败");
//			addActionError("登陆失败,请重新输入");
			return ERROR;
		}
	}
	
}
