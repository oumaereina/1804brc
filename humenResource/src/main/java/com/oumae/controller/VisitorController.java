package com.oumae.controller;

import com.oumae.model.*;
import com.oumae.service.*;
import com.oumae.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    EmpService empService;
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
    public String login(@ModelAttribute("visitor") Visitor visitor, Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage) throws Exception {
        if(visitor.getV_name().equals("admin")&&visitor.getV_pass().equals("admin")){
            List<Resume> resumes = resumeService.selectResumeByState(0);
            model.addAttribute("noReadResumes",resumes.size());
            return "admin";
        }

        Visitor visitor1 = visitorService.getVisitor(visitor);
        List<Employment> employments = employmentService.getEmploymentByLimit(currentPage,PAGESIZE);
        List<Employment> allEmployment = employmentService.selectAllEmployment();
        int totalRows = allEmployment.size();
        int totalPages = DoPage.getTotalPages(totalRows);
        if(employments==null){
            model.addAttribute("EmpMsg", "没有招聘信息");
        }else {
            model.addAttribute("totalPages",totalPages);
            model.addAttribute("employments",employments);
        }
        if (null != visitor1) {
            Emp emp = empService.selectByVid(visitor1.getV_id());
            if(emp!=null){
                session.setAttribute("emp",emp);
            }
            List<Invite> invites = inviteService.selectInviteByVid(visitor1.getV_id());
            if(invites!=null&&invites.size()!=0){
                model.addAttribute("inviteMsg",invites.get(0));
            }
            //model.addAttribute("msg", "登录成功");
            session.setAttribute("visitor", visitor1);
            return "visitorMain";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "index";
    }
    /*招聘信息分页*/
    @RequestMapping("/paging")
    public String showEmp(Model model, HttpSession session, @RequestParam(defaultValue = "1") int currentPage) throws Exception {
        List<Employment> employments = employmentService.getEmploymentByLimit(currentPage,PAGESIZE);
        List<Employment> allEmployment = employmentService.selectAllEmployment();
        int totalRows = allEmployment.size();
        int totalPages = DoPage.getTotalPages(totalRows);
        if(employments==null){
            model.addAttribute("EmpMsg", "没有招聘信息");
        }else {
            model.addAttribute("totalPages",totalPages);
            model.addAttribute("employments",employments);
        }
        return "visitorMain";
    }
    /*游客注册*/
    @RequestMapping("/visitorRegister")
    public String register(@ModelAttribute("visitor") Visitor visitor, Model model) throws Exception {
        if (visitorService.insertVisitor(visitor)) {
            model.addAttribute("msg", "注册成功");

        } else {
            model.addAttribute("msg", "注册失败");
        }
        return "visitorMain";
    }
    /*确认名字*/
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
    public ModelAndView checkInvite(Integer inviteId, HttpSession session, Model model) throws Exception{
        Invite invites = inviteService.selectById(inviteId);
        if(invites!=null){
            invites.setI_STATE(1);
            inviteService.updateInvite(invites);
        }
        return new ModelAndView("redirect:paging");
    }
}
