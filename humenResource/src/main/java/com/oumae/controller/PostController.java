package com.oumae.controller;

import com.oumae.model.Post;
import com.oumae.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/24.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;
    @RequestMapping("/showPostByDid")
    public String showMsg(Integer did,HttpSession session, Model model) throws Exception{
        List<Post> posts = postService.selectByDid(did);
        if(posts!=null){
            session.setAttribute("posts",posts);
        }
        return "adminDepartment";
    }
}
