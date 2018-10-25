package com.oumae.controller;

import com.oumae.model.Post;
import com.oumae.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/addPost")
    public String addPost(Post post,HttpSession session, Model model) throws Exception{
        if(postService.insertPost(post)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败,有重名岗位");
        }
        return "adminDepartment";
    }
    @RequestMapping("/delPost")
    public String delPost(Integer pid,HttpSession session, Model model) throws Exception{
        if(postService.deletePostById(pid)){
            model.addAttribute("msg","删除成功");
            session.setAttribute("posts",null);
        }else {
            model.addAttribute("msg","删除失败，该部门还有员工");
        }
        return "adminDepartment";
    }
    @RequestMapping("/updatePost1")
    public String updatePost1(Integer pid,HttpSession session, Model model) throws Exception{
        Post post = postService.selectById(pid);
        model.addAttribute("post",post);
        return "adminUpdateEmployment";
    }

    @RequestMapping("/updatePost2")
    public String updatePost2(Post post, HttpSession session, Model model) throws Exception{
        if(postService.updatePostById(post)){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");
        }
        return "adminDepartment";
    }
}
