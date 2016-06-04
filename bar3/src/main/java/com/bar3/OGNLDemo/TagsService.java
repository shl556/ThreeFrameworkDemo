package com.bar3.OGNLDemo;

import java.util.ArrayList;
import java.util.List;


public class TagsService {
	
	/**
	 * Function  : 获取城市的集合
	 * @author   : bless<505629625@qq.com>
	 */
	public List<CityBean> getCitys(){
		List<CityBean> lstCity = new ArrayList<CityBean>();
		lstCity.add(new CityBean(1, "北京"));
		lstCity.add(new CityBean(2, "上海"));
		lstCity.add(new CityBean(3, "广州"));
		lstCity.add(new CityBean(4, "成都"));
		lstCity.add(new CityBean(5, "深圳"));
		return lstCity;
	}
	
	/**
	 * Function  : 获取兴趣的集合
	 * @author   : bless<505629625@qq.com>
	 */
	public List<HobbyBean> getHobbis(){
		List<HobbyBean> lstHobby = new ArrayList<HobbyBean>();
		lstHobby.add(new HobbyBean(1, "唱歌"));
		lstHobby.add(new HobbyBean(2, "跳舞"));
		lstHobby.add(new HobbyBean(3, "运动"));
		lstHobby.add(new HobbyBean(4, "旅游"));
		lstHobby.add(new HobbyBean(5, "宅神"));
		return lstHobby;
	}
	
	/**
	 * Function  : 获取性别的集合
	 * @author   : bless<505629625@qq.com>
	 */
	public List<SexBean> getSexs(){
		List<SexBean> lstSex = new ArrayList<SexBean>();
		lstSex.add(new SexBean(0, "男"));
		lstSex.add(new SexBean(1, "女"));
		return lstSex;
	}
	
	/**
	 * 
	 * Function  : 获取被选中的兴趣爱好集合
	 * @author   : bless<505629625@qq.com>
	 */
	public List<HobbyBean> getCheckedHobbies(int hobbies[]){
		if(hobbies==null ||hobbies.length<1){
			return null;
		}
		
		List<HobbyBean> lstHobby = new ArrayList<HobbyBean>();
		for (int i : hobbies) {
			for (HobbyBean hobbyBean : getHobbis()) {
				if(i == hobbyBean.getHobbyId()){
					lstHobby.add(hobbyBean);
					break;
				}
			}
		}
		return lstHobby;
	}
	
	/**
	 * Function  : 获取被选择的城市集合
	 * @author   : bless<505629625@qq.com>
	 */
	public CityBean getSelectedCity(int cityId){
		for (CityBean cb : getCitys()) {
			if(cityId == cb.getCityId()){
				return cb;
			}
		}
		return null;
	}
}
