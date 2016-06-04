package com.bar3.domain.annonation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
* @ClassName: User
* @Description: 表示用户的实体类
* @author shl
* @date 2016年2月12日 下午8:30:57
*/
@Entity
public class User implements java.io.Serializable {

	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = -24735437975304987L;
	/**
	* @Fields Id :用户id 
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	/**
	* @Fields version :版本控制 
	*/
	@Version
	private Integer version;
	/**
	* @Fields lgName : 登陆名
	*/
	private String lgName;
	/**
	* @Fields lgPass : 登陆密码
	*/
	private String lgPass;
	/**
	* @Fields sex : 男
	*/
	private Integer sex;
	/**
	* @Fields nickName :昵称 
	*/
	private String nickName;
	/**
	* @Fields headName : 头像文件名
	*/
	private String headName;
	/**
	* @Fields registerTime :注册时间 
	*/
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerTime;

	public User() {
	}

	public User(String lgName, String lgPass, Integer sex, String nickName, String headName) {
		this.lgName = lgName;
		this.lgPass = lgPass;
		this.sex = sex;
		this.nickName = nickName;
		this.headName = headName;
	}

	public User(String lgName, String lgPass, Integer sex, String nickName, String headName, Date registerTime) {
		this.lgName = lgName;
		this.lgPass = lgPass;
		this.sex = sex;
		this.nickName = nickName;
		this.headName = headName;
		this.registerTime = registerTime;
	}

	public long getId() {
		return this.Id;
	}

	private void setId(long Id) {
		this.Id = Id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getLgName() {
		return this.lgName;
	}

	public void setLgName(String lgName) {
		this.lgName = lgName;
	}

	public String getLgPass() {
		return this.lgPass;
	}

	public void setLgPass(String lgPass) {
		this.lgPass = lgPass;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadName() {
		return this.headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("Id").append("='").append(getId()).append("' ");
		buffer.append("lgName").append("='").append(getLgName()).append("' ");
		buffer.append("sex").append("='").append(getSex()).append("' ");
		buffer.append("nickName").append("='").append(getNickName()).append("' ");
		buffer.append("headName").append("='").append(getHeadName()).append("' ");
		buffer.append("registerTime").append("='").append(getRegisterTime()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
