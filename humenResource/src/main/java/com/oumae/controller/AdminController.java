package com.oumae.controller;

import com.oumae.model.*;
import com.oumae.service.*;
import com.oumae.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by oumaereina on 2018/10/21.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private VisitorService visitorService;
    @Resource
    private EmploymentService employmentService;
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
    private  final  int PAGESIZE = 5;

    /*二级联动找岗位*/
    @RequestMapping("/findPosts")
    public @ResponseBody List<Post> findPosts(Integer P_D_ID) throws IOException {
        if(P_D_ID==null){
            return null;
        }
        List<Post> postList=postService.selectByDid(P_D_ID);
        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("Post", Post);*/
        //response.getWriter().print(Post);
        return postList;
    }

    /*消息*/
    @RequestMapping("/showMsg")
    public String showMsg(Emp emp,HttpSession session, Model model) throws Exception{
        List<Invite> invites = inviteService.selectInviteByState(1);/*找出已确认面试的游客*/
        List<Visitor> visitors = new ArrayList<Visitor>();
        List<Resume> resumes = new ArrayList<Resume>();
        if(invites!=null&&invites.size()!=0){
            for (Invite invite : invites) {
                Visitor visitor = visitorService.getVisitorByVid(invite.getI_VID());
                List<Resume> resumeList = resumeService.selectResumeByVid(invite.getI_VID());
                resumes.add(resumeList.get(0));
                visitors.add(visitor);
            }
            model.addAttribute("resumes",resumes);
            model.addAttribute("visitors",visitors);
            model.addAttribute("invites",invites);
        }
        return "admin";
    }
}
