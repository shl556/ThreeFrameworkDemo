package com.bar3.basedao;

import com.bar3.domain.User;

public interface UserDao {
   /**
* @Description: 根据用户信息新增用户
* @param user
* @return Long 返回新增用户的id    
*/
public Long addUser(User user);
/**
* @Description: 根据id查找用户信息
* @param id 用户id
* @return User 用户信息
*/
public User getUserById(Long id);
/**
* @Description: 验证登陆名与登陆密码是否匹配
* @param lgName 用户名
* @param lgPass 用户密码
* @return 匹配返回用户信息
*/
public User doLogin(String lgName,String lgPass);
}
