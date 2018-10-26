package com.oumae.controller;

import com.oumae.model.Train;
import com.oumae.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by oumaereina on 2018/10/27.
 */
@Controller
@RequestMapping("/train")
public class TrainController {
    @Resource
    private TrainService trainService;
    @RequestMapping("/addTrain")
    public String addTrain(Train train, HttpSession session, Model model) throws Exception{
        if(trainService.insertTrain(train)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "adminTrain";
    }

    @RequestMapping("/showTrain")
    public String showTrain(Integer tid, HttpSession session, Model model) throws Exception{
        Train train =trainService.selectById(tid);
        if(train!=null){
            model.addAttribute("emps",train.getEmps());
        }
        return "adminTrain";
    }
}
