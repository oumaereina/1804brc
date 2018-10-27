package com.oumae.controller;

import com.oumae.model.Department;
import com.oumae.model.TraToEmp;
import com.oumae.model.Train;
import com.oumae.service.DepartmentService;
import com.oumae.service.TraToEmpService;
import com.oumae.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/27.
 */
@Controller
@RequestMapping("/train")
public class TrainController {
    @Resource
    private TrainService trainService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private TraToEmpService traToEmpService;
    /*添加培训信息*/
    @RequestMapping("/addTrain")
    public String addTrain(Train train, HttpSession session, Model model) throws Exception{
        if(trainService.insertTrain(train)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "adminTrain";
    }
    /*找所有培训信息*/
    @RequestMapping("/showTrain")
    public @ResponseBody
    List<Train> showTrain() throws Exception{
        List<Train> trains =trainService.selectAll();
        return trains;
    }
    /*培训主页*/
    @RequestMapping("/showTrainMain")
    public String addTrain( HttpSession session, Model model) throws Exception{
        List<Department> departments = departmentService.selectAll();
        session.setAttribute("departments",departments);
        return "adminTrain";
    }
    /*添加员工去培训*/
    @RequestMapping("/addEmpToTrain")
    public String addEmpToTrain(Integer tid,Model model, HttpServletRequest request) throws Exception{
        if(tid==null){
            model.addAttribute("msg","未选中任何培训课程");
            return "adminTrain";
        }
        String[] log = request.getParameterValues("log");
        if(log==null&&log.length==0){
            model.addAttribute("msg","未选中任何学员");
            return "adminTrain";
        }
        String str = "";
        //String[] tid = request.getParameterValues("tid");
        if(log!=null){
            for (int i = 0; i <log.length ; i++) {
                TraToEmp traToEmp = new TraToEmp();
                traToEmp.setTm_eid(Integer.valueOf(log[i]));
                traToEmp.setTm_tid(tid);
                traToEmp.setTm_state(0);
                if(!traToEmpService.insertTE(traToEmp)){
                    str+="编号:"+log[i]+",";
                }
            }
            model.addAttribute("msg",str+"已被添加过，不能再次添加");
        }
        return "adminTrain";
    }
}
