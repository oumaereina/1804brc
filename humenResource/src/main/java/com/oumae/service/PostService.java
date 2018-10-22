package com.oumae.service;

import com.oumae.model.Post;

import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
public interface PostService {
    boolean insertPost(Post post);
    boolean deletePostById(Integer P_ID);
    boolean updatePostById(Post post);
    Post selectById(Integer P_ID);
    List<Post> selectAll();
}
