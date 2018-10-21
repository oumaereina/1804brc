package com.oumae.controller;

import com.oumae.model.Employment;
import com.oumae.service.EmploymentService;
import com.oumae.utils.DoPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/21.
 */
@Controller
@RequestMapping("/employment")
public class EmploymentController {
    @Resource
    private EmploymentService employmentService;
    private  final  int PAGESIZE = 5;
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
        return "index";
    }
}
