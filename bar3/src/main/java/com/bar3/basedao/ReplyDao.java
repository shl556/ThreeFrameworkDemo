package com.bar3.basedao;

import com.bar3.domain.Reply;

public interface ReplyDao {
   /**
* @Description: 发表回复
* @param reply
* @return 返回新增回复的id
*/
public Long addReply(Reply reply);
/**
* @Description: 根据id删除回复
* @param id
* @return     
*/
public boolean deleteReplyById(Long id);
/**
* @Description: 修改回复
* @param reply
* @return     
*/
public boolean updateReply(Reply reply);
/**
* @Description: 根据id查找回复
* @param id
* @return     
*/
public Reply getReplyById(Long id);
}
