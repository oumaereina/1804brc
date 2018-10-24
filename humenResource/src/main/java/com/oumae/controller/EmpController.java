package com.oumae.controller;

import com.oumae.model.Department;
import com.oumae.model.Emp;
import com.oumae.model.Post;
import com.oumae.model.Resume;
import com.oumae.service.DepartmentService;
import com.oumae.service.EmpService;
import com.oumae.service.PostService;
import com.oumae.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by oumaereina on 2018/10/24.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpService empService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService postService;
    @Resource
    private ResumeService resumeService;
    /*录取为员工1*/
    @RequestMapping("/addEmp")
    public String addEmp1(Integer vid, HttpSession session, Model model) throws Exception{
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
            Date currDate = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = sdf.format(currDate);
            model.addAttribute("date",currDate);
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
    @RequestMapping("/addeee")
    public String addEmp3(Emp emp, HttpSession session, Model model) throws Exception{
        if(empService.insertEmp(emp)){
            Department department = departmentService.selectById(emp.getE_d_id());
            department.setD_NUM(department.getD_NUM()+1);
            departmentService.updateDepartmentById(department);
            Post post = postService.selectById(emp.getE_p_id());
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg", "添加失败");
        }
        return "adminAddEmp";
    }
    @RequestMapping("/empLogin")
    public String showEmp(Emp emp, HttpSession session, Model model) throws Exception{
        System.out.println(emp);
        Emp emp1 = empService.selectByNamePass(emp);
        if(emp1!=null){
            Department department = departmentService.selectById(emp1.getE_d_id());
            Post post = postService.selectById(emp1.getE_p_id());
            session.setAttribute("depart",department);
            session.setAttribute("post",post);
            session.setAttribute("emp",emp1);
            return "emp";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "empLogin";
    }
}
