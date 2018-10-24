package com.oumae.controller;

import com.oumae.model.Resume;
import com.oumae.model.Visitor;
import com.oumae.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/20.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Resource
    private ResumeService resumeService;
    @RequestMapping("/addResume")
    public String addResume(HttpServletRequest request, Model model) throws Exception{
        Resume resume = new Resume();
        Integer integer = Integer.valueOf(request.getParameter("r_vid"));
        resume.setR_vid(Integer.valueOf(request.getParameter("r_vid")));
        resume.setR_name((String) request.getParameter("r_name"));
        resume.setR_sex((String) request.getParameter("r_sex"));
        resume.setR_nation((String) request.getParameter("r_nation"));
        resume.setR_bir((String) request.getParameter("r_bir"));
        resume.setR_native_place((String) request.getParameter("r_native_place"));
        resume.setR_pol_sta((String) request.getParameter("r_pol_sta"));
        resume.setR_height(Integer.valueOf(request.getParameter("r_height")));
        resume.setR_weight(Integer.valueOf(request.getParameter("r_weight")));
        resume.setR_health((String) request.getParameter("r_health"));
        resume.setR_english((String) request.getParameter("r_english"));
        resume.setR_edu((String) request.getParameter("r_edu"));
        resume.setR_major(request.getParameter("r_major"));
        resume.setR_idc(BigInteger.valueOf(Long.parseLong(request.getParameter("r_idc"))));
        resume.setR_phone(BigInteger.valueOf(Long.parseLong(request.getParameter("r_phone"))));
        resume.setR_add(request.getParameter("r_add"));
        resume.setR_school((String) request.getParameter("r_school"));
        resume.setR_hobby((String) request.getParameter("r_hobby"));
        resume.setR_self((String) request.getParameter("r_self"));
        resume.setR_state(1);
        if(resumeService.insertResume(resume)){
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg", "添加失败");
        }
        return "visitorMain";
    }
    @RequestMapping("/selectResume")
    public String selectResume(HttpSession session, Model model) throws Exception{
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        List<Resume> resumes = resumeService.selectResumeByVid(visitor.getV_id());
        session.setAttribute("resumes",resumes);
        return "visitorResume";
    }
    @RequestMapping("/updateResume")
    public ModelAndView updateResume(HttpServletRequest request,HttpSession session, Model model) throws Exception{
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Resume resume = new Resume();
        resume.setR_id(Integer.valueOf(request.getParameter("r_id")));
        resume.setR_vid(Integer.valueOf(visitor.getV_id()));
        resume.setR_name((String) request.getParameter("r_name"));
        resume.setR_sex((String) request.getParameter("r_sex"));
        resume.setR_nation((String) request.getParameter("r_nation"));
        resume.setR_bir((String) request.getParameter("r_bir"));
        resume.setR_native_place((String) request.getParameter("r_native_place"));
        resume.setR_pol_sta((String) request.getParameter("r_pol_sta"));
        resume.setR_height(Integer.valueOf(request.getParameter("r_height")));
        resume.setR_weight(Integer.valueOf(request.getParameter("r_weight")));
        resume.setR_health((String) request.getParameter("r_health"));
        resume.setR_english((String) request.getParameter("r_english"));
        resume.setR_edu((String) request.getParameter("r_edu"));
        resume.setR_major(request.getParameter("r_major"));
        resume.setR_idc(BigInteger.valueOf(Long.parseLong(request.getParameter("r_idc"))));
        resume.setR_phone(BigInteger.valueOf(Long.parseLong(request.getParameter("r_phone"))));
        resume.setR_add(request.getParameter("r_add"));
        resume.setR_school((String) request.getParameter("r_school"));
        resume.setR_hobby((String) request.getParameter("r_hobby"));
        resume.setR_self((String) request.getParameter("r_self"));
        resume.setR_state(1);
        resumeService.updateResumeById(resume);
        return new ModelAndView("redirect:selectResume");
    }
    /*查看全部简历*/
    @RequestMapping("/selectAllResumeAdmin")
    public String selectAllResumeAdmin(HttpSession session, Model model) throws Exception{
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
}
