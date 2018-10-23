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
import javax.servlet.http.HttpSession;
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
            String result2="";
            for (int i=0;i<6;i++)
            {
                result2+=random.nextInt(10);
            }
            List<Department> departments = departmentService.selectAll();
            List<Post> posts = postService.selectAll();
            model.addAttribute("departments",departments);
            model.addAttribute("posts",posts);
            model.addAttribute("empName",result2);
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
    @RequestMapping("/findPosts")
    @ResponseBody
    public List<Post> findReply(Integer P_D_ID){
        if(P_D_ID==null){
            return null;
        }
        List<Post> Post=postService.selectByDid(P_D_ID);
        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("Post", Post);*/
        return Post;
    }
    /*查看招聘信息*/
    @RequestMapping("/showEmp")
    public String addResume(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1") int currentPage) throws Exception{
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
        return "adminEmployment";
    }
/*删除招聘信息*/
    @RequestMapping("/deleteEmployment")
    public ModelAndView deleteEmployment(Integer EM_ID,HttpSession session, Model model) throws Exception{
        employmentService.deleteEmpById(EM_ID);
        return new ModelAndView("redirect:showEmp");
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
