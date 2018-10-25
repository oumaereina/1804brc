package com.oumae.controller;

import com.oumae.model.*;
import com.oumae.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource
    private DimissionService dimissionService;
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
            resumes.get(0).setR_state(2);//设置状态2代表已录用
            resumeService.updateResumeById(resumes.get(0));
            Date currDate = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = sdf.format(currDate);
            model.addAttribute("date",currDate);
            List<Department> departments = departmentService.selectAll();
            List<Post> posts = postService.selectAll();
            model.addAttribute("vid",vid);
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
    public String addEmp3(Integer vid,Emp emp, HttpSession session, Model model) throws Exception{
        if(empService.insertEmp(emp)){
            Department department = departmentService.selectById(emp.getE_d_id());
            department.setD_NUM(department.getD_NUM()+1);
            departmentService.updateDepartmentById(department);
            Post post = postService.selectById(emp.getE_p_id());
            post.setP_NUM(post.getP_NUM()+1);
            postService.updatePostById(post);
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg", "添加失败");
        }
        return "adminAddEmp";
    }
    @RequestMapping("/empLogin")
    public String showEmp(Emp emp, HttpSession session, Model model) throws Exception{
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
    /*通过部门查询员工*/
    @RequestMapping("/showDepNum")
    public String showDepNum(Integer did,HttpSession session, Model model) throws Exception{
        List<Emp>emps =  empService.selectEmpByDid(did);
        List<Dimission> dimissions = new ArrayList<Dimission>();
        if(emps!=null||emps.size()!=0){
            for (Emp emp : emps) {
                if(emp.getE_state()==3){
                    Dimission dimission = dimissionService.selectDimissionByEid(emp.getE_id());
                    dimissions.add(dimission);
                }
            }
            model.addAttribute("dis",dimissions);
            model.addAttribute("emps",emps);
        }else {
            model.addAttribute("msg","没有员工");
        }

        return "adminDepartment";
    }
    /*换岗1*/
    @RequestMapping("/updateDP")
    public String updateDP(Integer eid,HttpSession session, Model model) throws Exception{
        Emp emp = empService.selectById(eid);
        List<Department> departments = departmentService.selectAll();
        if(departments!=null){
            model.addAttribute("departments",departments);
        }
        model.addAttribute("emp",emp);
        return "adminUpdateEmployment";
    }
    /*二级联动找岗位*/
    @RequestMapping("/findPosts")
    public @ResponseBody
    List<Post> findPosts(Integer P_D_ID) throws IOException {
        if(P_D_ID==null){
            return null;
        }
        List<Post> postList=postService.selectByDid(P_D_ID);
        return postList;
    }
    @RequestMapping("/updateDP2")
    public String updateDP2(Integer did,Integer pid,Integer eid,Integer opid,Integer odid,HttpSession session, Model model) throws Exception{
        Emp emp = empService.selectById(eid);
        emp.setE_d_id(did);
        emp.setE_p_id(pid);
        if(empService.updateEmpById(emp)){
            Department department = departmentService.selectById(odid);
            department.setD_NUM(department.getD_NUM()-1);
            departmentService.updateDepartmentById(department);/*人数-1*/
            Post post = postService.selectById(opid);
            post.setP_NUM(post.getP_NUM()-1);
            postService.updatePostById(post);/*人数-1*/

            Department department1 = departmentService.selectById(did);
            department1.setD_NUM(department1.getD_NUM()+1);
            departmentService.updateDepartmentById(department1);/*人数+1*/
            Post post1 = postService.selectById(pid);
            post1.setP_NUM(post1.getP_NUM()+1);
            postService.updatePostById(post1);/*人数+1*/

            model.addAttribute("msg","修改成功");
            List<Department> departments = departmentService.selectAll();
            if(departments!=null){
                session.setAttribute("departments",departments);
            }
        }else {
            model.addAttribute("msg","修改失败");
        }
        return "adminDepartment";
    }
    /*转正*/
    @RequestMapping("/positive")
    public String positive(Integer eid,HttpSession session, Model model) throws Exception{
        Emp emp = empService.selectById(eid);
        Date currDate = Calendar.getInstance().getTime();
        Date date = emp.getE_date();
        if((currDate.getTime()-date.getTime())/1000>2419200){
            emp.setE_state(2);
            if(empService.updateEmpById(emp)){
                model.addAttribute("msg","转正成功,已成为正式员工");
            }else {
                model.addAttribute("msg","操作失败");
            }
        }else {
            model.addAttribute("msg","转正失败,时间未满一个月");
        }
        return "adminDepartment";
    }
    /*离职*/
    @RequestMapping("/dismission")
    public String dismission(Integer eid,HttpSession session, Model model) throws Exception{
        Emp emp = empService.selectById(eid);
        emp.setE_state(3);
        if(empService.updateEmpById(emp)){
            Department department = departmentService.selectById(emp.getE_d_id());
            department.setD_NUM(department.getD_NUM()-1);
            departmentService.updateDepartmentById(department);/*人数-1*/
            Post post = postService.selectById(emp.getE_p_id());
            post.setP_NUM(post.getP_NUM()-1);
            postService.updatePostById(post);/*人数-1*/

            List<Department> departments = departmentService.selectAll();
            if(departments!=null){
                session.setAttribute("departments",departments);
            }

            model.addAttribute("empDis",emp.getE_id());
            model.addAttribute("msg","操作成功，员工已离职,请填写离职原因");
        }else {
            model.addAttribute("msg","操作失败");
        }
        return "adminUpdateEmployment";
    }
    /*填写离职原因*/
    @RequestMapping("/doDismission")
    public String doDismission(Dimission dimission,HttpSession session, Model model) throws Exception{
        if(dimissionService.insertDimission(dimission)){
            model.addAttribute("msg","提交成功");
        }else {
            model.addAttribute("msg","提交失败");
        }
        return "adminDepartment";
    }
}
