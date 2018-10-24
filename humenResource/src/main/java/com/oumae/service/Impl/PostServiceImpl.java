package com.oumae.service.Impl;

import com.oumae.dao.PostDao;
import com.oumae.model.Post;
import com.oumae.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/22.
 */
@Service
public class PostServiceImpl implements PostService{
    @Resource
    private PostDao postDao;
    public boolean insertPost(Post post) {
        Post post1 = postDao.selectByNAME(post.getP_NAME());
        if(post1!=null){
            return false;
        }
        if(post!=null){
            Integer integer = postDao.insertPost(post);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public boolean deletePostById(Integer P_ID) {
        if(P_ID!=null){
            Integer integer = postDao.deletePostById(P_ID);
            if(integer==1){
                return true;
            }
        }return false;
    }

    public boolean updatePostById(Post post) {
        if(post!=null){
            Integer integer = postDao.updatePostById(post);
            if(integer==1){
                return true;
            }
        }
        return false;
    }

    public Post selectById(Integer P_ID) {
        Post post = postDao.selectById(P_ID);
        return post;
    }

    public List<Post> selectAll() {
        List<Post> posts = postDao.selectAll();
        return posts;
    }

    public List<Post> selectByDid(Integer P_D_ID) {
        List<Post> posts = postDao.selectByDid(P_D_ID);
        return posts;
    }
}
