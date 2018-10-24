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
    Post selectByNAME(String P_NAME);
    List<Post> selectAll();
    List<Post> selectByDid(Integer P_D_ID);
}
