package com.bar3.basedao;


import java.util.List;

import com.bar3.domain.Post;
import com.bar3.domain.Reply;

public interface PostDao {
   /**
* @Description: 新增主题
* @param post
* @return     
*/
public Long AddPost(Post post);
/**
* @Description: 修改主题
* @param post
* @return     
*/
public boolean UpdatePost(Post post);
/**
* @Description: 删除主题
* @param id
* @return     
*/
public boolean DeletePost(Long id );
/**
* @Description: 根据id查找post
* @param id
* @return     
*/
public Post getPostById(Long id);
/**
* @Description: 根据postid查找回复
* @param postId
* @return     
*/
public List<Reply> getReplysByPostId(Long postId);
}
