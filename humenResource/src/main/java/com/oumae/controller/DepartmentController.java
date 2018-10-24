package com.oumae.controller;

import com.oumae.model.Department;
import com.oumae.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public String showMsg(HttpSession session, Model model) throws Exception{
        List<Department> departments = departmentService.selectAll();
        if(departments!=null){
            session.setAttribute("departments",departments);
        }
        return "adminDepartment";
    }
}
