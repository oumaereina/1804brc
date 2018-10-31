package com.oumae.controller;

import com.oumae.model.Emp;
import com.oumae.service.EmpService;
import com.oumae.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/31.
 */
@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Resource
    private SalaryService salaryService;
    @Resource
    private EmpService empService;
    @RequestMapping("/insertSalary")
    public String showEmpReward(HttpSession session, Model model) throws Exception {
        List<Emp> emps = empService.selectAllEmp();

        return "empReward";
    }
}
