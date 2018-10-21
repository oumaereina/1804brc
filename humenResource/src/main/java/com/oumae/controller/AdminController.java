package com.oumae.controller;

import com.oumae.model.Invite;
import com.oumae.model.Resume;
import com.oumae.model.Visitor;
import com.oumae.service.InviteService;
import com.oumae.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping("/selectAllResumeAdmin")
    public String selectResume(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(null);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    @RequestMapping("/selectNoReadResumeAdmin")
    public String selectNoReadResumeAdmin(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(0);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    @RequestMapping("/selectReadResumeAdmin")
    public String selectReadResumeAdmin(HttpSession session, Model model) throws Exception{
        List<Resume> resumes = resumeService.selectResumeByState(1);
        model.addAttribute("resumes",resumes);
        return "adminResumes";
    }
    @RequestMapping("/addInvite")
    public ModelAndView addInvite(Integer vid,HttpSession session, Model model) throws Exception{
        Invite invite = new Invite();
        invite.setI_VID(vid);
        invite.setI_STATE(0);
        if(inviteService.insertInvite(invite)){
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg", "添加失败");
        }
        return new ModelAndView("redirect:selectReadResumeAdmin");
    }
}
