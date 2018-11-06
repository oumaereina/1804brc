package com.oumae.controller;

import com.oumae.model.CheckIn;
import com.oumae.model.Emp;
import com.oumae.model.Reward;
import com.oumae.model.Salary;
import com.oumae.service.CheckInService;
import com.oumae.service.EmpService;
import com.oumae.service.RewardService;
import com.oumae.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
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
    @Resource
    private CheckInService checkInService;
    @Resource
    private RewardService rewardService;
    /*工资结算*/
    @RequestMapping("/insertSalary")
    public String showEmpReward(HttpSession session, Model model) throws Exception {
        Date currDate = Calendar.getInstance().getTime();
        Calendar cale = null;
        cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH);
        List<Salary> salaries = salaryService.selectByMonth(month+1);
        if(salaries.size()!=0){
            model.addAttribute("msg","当月已结算，无法再次结算");
            return "admin";
        }
        List<Emp> emps = empService.selectAllEmp();//单人工资=当月下班打卡记录数*（基本工资/22）+奖惩-1%基本工资社保
        for (Emp emp : emps) {
            Double salary = 0.0;
            List<CheckIn> checkIns = checkInService.selectMonth(month,emp.getE_id(),1);
            List<Reward> rewards = rewardService.selectByMonthEid(emp.getE_id(),month);
            salary=checkIns.size()*(emp.getE_salary()/22)-emp.getE_salary()*0.01;
            for (Reward reward : rewards) {
                salary=salary+reward.getRm_money();
            }
            salary=salary-salary%1;
            if(salary<0){
                salary=0.0;
            }
            Salary salary1 = new Salary(emp.getE_id(),salary,currDate);
            salaryService.insertSalary(salary1);
        }
        return "admin";
    }
 /*   @RequestMapping("/showSalaryByAdmin")
    public  @ResponseBody
    List<Salary> showSalaryByAdmin(Model model) throws Exception {
        Calendar cale = null;
        cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH)+1;

        return salaries;
    }*/
}
