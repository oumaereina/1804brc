package com.oumae.controller;

import com.oumae.model.Invite;
import com.oumae.model.Resume;
import com.oumae.model.Visitor;
import com.oumae.service.EmploymentService;
import com.oumae.service.InviteService;
import com.oumae.service.ResumeService;
import com.oumae.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/19.
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Resource
    private VisitorService visitorService;
    @Resource
    private EmploymentService employmentService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private InviteService inviteService;
    private  final  int PAGESIZE = 5;
    @RequestMapping("/visitorLogin")
    public String login(@ModelAttribute("visitor") Visitor visitor, Model model, HttpSession session) throws Exception {
        if(visitor.getV_name().equals("admin")&&visitor.getV_pass().equals("admin")){
            List<Resume> resumes = resumeService.selectResumeByState(0);
            model.addAttribute("noReadResumes",resumes.size());
            return "admin";
        }
        Visitor visitor1 = visitorService.getVisitor(visitor);
        if (null != visitor1) {
            List<Invite> invites = inviteService.selectInviteByVid(visitor1.getV_id());
            if(invites!=null&&invites.size()!=0){
                model.addAttribute("inviteMsg",invites.get(0));
            }
            //model.addAttribute("msg", "登录成功");
            session.setAttribute("visitor", visitor1);
            return "main";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "index";
    }

    @RequestMapping("/visitorRegister")
    public String register(@ModelAttribute("visitor") Visitor visitor, Model model) throws Exception {
        if (visitorService.insertVisitor(visitor)) {
            model.addAttribute("msg", "注册成功");

        } else {
            model.addAttribute("msg", "注册失败");
        }
        return "main";
    }

    @RequestMapping("/checkName")
    public void checkName(String v_name, HttpSession session, Model model, HttpServletResponse response) throws Exception {
        Visitor visitor = visitorService.getVisitorByName(v_name);
       if(visitor!=null){
           response.getWriter().print("false");
       }else {
           response.getWriter().print("true");
       }
    }
    @RequestMapping("/checkInvite")
    public String checkInvite(Integer inviteId,HttpSession session, Model model) throws Exception{
        Invite invites = inviteService.selectById(inviteId);
        if(invites!=null){
            invites.setI_STATE(1);
            inviteService.updateInvite(invites);
        }
        return "main";
    }
}
