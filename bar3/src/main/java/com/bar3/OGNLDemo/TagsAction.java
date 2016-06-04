package com.bar3.OGNLDemo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TagsAction extends ActionSupport {
	private static final long serialVersionUID = 4361410156958515185L;
	private TagsService tagsService = new TagsService();
	
	//****formbean*****
	private List<CityBean> lstCityBean;
	private List<HobbyBean> lstHobbyBean;
	private UserBean userBean;

	//*******action method***********
	/**
	 * 进入表单填写页面
	 */
	public String goIndex(){
		userBean = new UserBean();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("lstSexBean", tagsService.getSexs());
		return SUCCESS;
	}
	/**
	 * Function  : 提交表单
	 */
	public String doSubmit(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);		
		request.setAttribute("lstHobby", tagsService.getCheckedHobbies(userBean.getHobby()));
		request.setAttribute("cityBean", tagsService.getSelectedCity(userBean.getCity()));
		return SUCCESS;
	}
	/**
	 * Function  : 验证表单数据
	 */
	public void validateDoSubmit(){
		if(userBean.getCity()<1){
			this.addFieldError("userBean.city", "请选择城市！");
			return;
		}
	}

	public List<CityBean> getLstCityBean() {
		return tagsService.getCitys();
	}

	public void setLstCityBean(List<CityBean> lstCityBean) {
		this.lstCityBean = lstCityBean;
	}

	public List<HobbyBean> getLstHobbyBean() {
		return tagsService.getHobbis();
	}

	public void setLstHobbyBean(List<HobbyBean> lstHobbyBean) {
		this.lstHobbyBean = lstHobbyBean;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}
