package com.oumae.controller;

import com.oumae.model.Emp;
import com.oumae.model.Reconsider;
import com.oumae.model.Salary;
import com.oumae.service.EmpService;
import com.oumae.service.ReconsiderService;
import com.oumae.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/11/1.
 */
@Controller
@RequestMapping("/reconsider")
public class ReconsiderController {
    @Resource
    private ReconsiderService reconsiderService;
    @Resource
    private SalaryService salaryService;
    @Resource
    private EmpService empService;
    @RequestMapping("/showReconsider")
    public String showReconsider(HttpSession session, Model model) throws Exception {
        Calendar cale = null;
        cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH)+1;
        List<Reconsider> reconsiders = reconsiderService.selectByMonth(month,0);
        if(reconsiders.size()!=0){
            List<Emp> emps = new ArrayList<Emp>();
            List<Salary> salaries = new ArrayList<Salary>();
            model.addAttribute("reconsiders",reconsiders);
            for (Reconsider reconsider : reconsiders) {
                Emp emp = empService.selectById(reconsider.getRc_eid());
                Salary salary = salaryService.selectById(reconsider.getRc_salaryId());
                emps.add(emp);
                salaries.add(salary);
            }
            model.addAttribute("emps",emps);
            model.addAttribute("salaries",salaries);
        }else {
            model.addAttribute("msg","无消息");
        }
        return "adminReconsider";
    }

    @RequestMapping("/addReconsider")
    public String addReconsider(Integer rc_eid,Integer rc_salaryId, Model model) throws Exception {
        Date currDate = Calendar.getInstance().getTime();
        Calendar cale = null;
        cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH)+1;
        Reconsider reconsider = new Reconsider(rc_eid,rc_salaryId,0,currDate);
        List<Reconsider> reconsiders = reconsiderService.selectByMonthEid(month,rc_eid);
        if(reconsiders.size()!=0){
            model.addAttribute("msg","本月已申请复议，无法重复申请");
            return "emp";
        }
        if(reconsiderService.insertReconsider(reconsider)){
            model.addAttribute("msg","申请成功");
        }else {
            model.addAttribute("msg","申请失败");
        }
        return "emp";
    }
    @RequestMapping("/passReconsider")
    public String passReconsider(Integer rc_id,HttpSession session, Model model) throws Exception {
        Reconsider reconsider = reconsiderService.selectById(rc_id);
        reconsider.setRc_state(1);//1代表通过
        if(reconsiderService.updateReconsider(reconsider)){
            model.addAttribute("msg","操作成功");
        }else {
            model.addAttribute("msg","操作失败");
        }
        return "redirect:showReconsider";
    }

    @RequestMapping("/failReconsider")
    public String failReconsider(Integer rc_id,HttpSession session, Model model) throws Exception {
        Reconsider reconsider = reconsiderService.selectById(rc_id);
        reconsider.setRc_state(2);//1代表通过
        if(reconsiderService.updateReconsider(reconsider)){
            model.addAttribute("msg","操作成功");
        }else {
            model.addAttribute("msg","操作失败");
        }
        return "redirect:showReconsider";
    }
}
