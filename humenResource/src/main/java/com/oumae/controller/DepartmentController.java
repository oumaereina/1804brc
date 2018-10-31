package com.oumae.controller;

import com.oumae.model.Department;
import com.oumae.model.Post;
import com.oumae.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/24.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    /*查询所有部门*/
    @RequestMapping("/showDep")
    public String showDep(HttpSession session, Model model) throws Exception{
        List<Department> departments = departmentService.selectAll();
        if(departments!=null){
            session.setAttribute("departments",departments);
        }
        return "adminDepartment";
    }
    @RequestMapping("/showDepReward")
    public String showDepReward(HttpSession session, Model model) throws Exception{
        List<Department> departments = departmentService.selectAll();
        if(departments!=null){
            session.setAttribute("departments",departments);
        }
        return "adminReward";
    }
    @RequestMapping("/delDep")
    public String delDep(Integer did,HttpSession session, Model model) throws Exception{
        Department department = departmentService.selectById(did);
        if(department.getD_NUM()!=0){
            model.addAttribute("msg","删除失败，该部门还有员工");
        }else {
           if( departmentService.deleteDepartmentById(department.getD_id())){
               List<Department> departments = departmentService.selectAll();
               if(departments!=null){
                   session.setAttribute("departments",departments);
               }
               model.addAttribute("msg","删除成功");
           }else {
               model.addAttribute("msg","删除失败");
           }
        }
        return "adminDepartment";
    }
    @RequestMapping("/addDep")
    public String addDep(Department department,HttpSession session, Model model) throws Exception{
        Date currDate = Calendar.getInstance().getTime();
        department.setD_DATE(currDate);
        if(departmentService.insertDepartment(department)){
            List<Department> departments = departmentService.selectAll();
            if(departments!=null){
                session.setAttribute("departments",departments);
            }
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败,部门名重复");
        }
        return "adminDepartment";
    }

    @RequestMapping("/updateDep")
    public ModelAndView updateDep(Department department, HttpSession session, Model model) throws Exception{
        if(departmentService.updateDepartmentById(department)){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");
        }
        return new ModelAndView("redirect:showDep");
    }

    @RequestMapping("/updateDep1")
    public String updateDep1(Integer did,HttpSession session, Model model) throws Exception{
        Department department = departmentService.selectById(did);
        model.addAttribute("department",department);
        return "adminUpdateEmployment";
    }
    @RequestMapping("/findDeps")
    public @ResponseBody
    List<Department> findDeps() throws IOException {
        List<Department> departments=departmentService.selectAll();
        return departments;
    }


}
