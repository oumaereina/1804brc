package com.oumae.dao;

import com.oumae.model.Post;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface PostDao {
    Integer insertPost(Post post);
    Integer deletePostById(Integer P_ID);
    Integer updatePostById(Post post);
    Post selectById(Integer P_ID);
    List<Post> selectAll();
}
