package com.oumae.controller;

import com.oumae.model.*;
import com.oumae.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * Created by oumaereina on 2018/10/21.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private ResumeService resumeService;
    @Resource
    private InviteService inviteService;
    @Resource
    private EmpService empService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService postService;
    /*查看全部简历*/
    @RequestMapping("/selectAllResumeAdmin")
    public String selectResume(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(null);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    /*查看未读简历*/
    @RequestMapping("/selectNoReadResumeAdmin")
    public String selectNoReadResumeAdmin(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(0);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    /*查看已读简历*/
    @RequestMapping("/selectReadResumeAdmin")
    public String selectReadResumeAdmin(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(1);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    /*发送面试邀请*/
    @RequestMapping("/addInvite")
    public ModelAndView addInvite(Integer vid,HttpSession session, Model model) throws Exception{
        List<Invite> invites = inviteService.selectInviteByVid(vid);
        if(invites!=null&&invites.size()!=0){
            model.addAttribute("msg", "添加失败,不能重复发送面试邀请");
        }else {
            Invite invite = new Invite();
            invite.setI_VID(vid);
            invite.setI_STATE(0);
            if(inviteService.insertInvite(invite)){
                model.addAttribute("msg", "添加成功");
            }else {
                model.addAttribute("msg", "添加失败");
            }
        }
        return new ModelAndView("redirect:selectReadResumeAdmin");
    }
    /*录取为员工1*/
    @RequestMapping("/addEmp")
    public String addEmp(Integer vid,HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByVid(vid);
        if(resumes!=null&&resumes.size()!=0){
            Random random = new Random();
            String result="";
            for (int i=0;i<6;i++)
            {
                result+=random.nextInt(10);
            }
            List<Department> departments = departmentService.selectAll();
            List<Post> posts = postService.selectAll();
            model.addAttribute("departments",departments);
            model.addAttribute("posts",posts);
            model.addAttribute("empPass",result);
            model.addAttribute("resume",resumes.get(0));
        }
         return "adminAddEmp";
    }
    /*录取为员工2*/
    @RequestMapping("/addEmp2")
    public String addEmp2(Emp emp,HttpSession session, Model model) throws Exception{
        if(empService.insertEmp(emp)){
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg", "添加失败");
        }
        return "";
    }
}
