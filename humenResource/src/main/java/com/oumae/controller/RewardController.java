package com.oumae.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oumae.model.Reward;
import com.oumae.service.RewardService;
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
 * Created by oumaereina on 2018/10/30.
 */
@Controller
@RequestMapping("/reward")
public class RewardController {
    @Resource
    private RewardService rewardService;
    @RequestMapping("/showEmpReward")
    public String showEmpReward(Integer eid,HttpSession session, Model model) throws Exception {
        List<Reward> rewards = rewardService.selectByEid(eid);
        model.addAttribute("reward",rewards);
        return "empReward";
    }
    @RequestMapping("/showEmpRewardAdmin")
    public @ResponseBody
    List<Reward> showEmpRewardAdmin(Integer eid, HttpSession session, Model model) throws Exception {
        List<Reward> rewards = rewardService.selectByEid(eid);
        model.addAttribute("reward",rewards);
        return rewards;
    }
    @RequestMapping("/updateEmpReward")
    public String updateEmpReward(Integer rmid,HttpSession session, Model model) throws Exception {
        Reward reward = rewardService.selectById(rmid);
        model.addAttribute("reward",reward);
        return "adminUpdateEmployment";
    }
    @RequestMapping("/updateEmpReward2")
    public String updateEmpReward2(Reward reward,HttpSession session, Model model) throws Exception {
        if(rewardService.updateReward(reward)){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");
        }
        return "adminUpdateEmployment";
    }
    @RequestMapping("/addReward")
    public String addReward(Reward reward,HttpSession session, Model model) throws Exception {
        Date currDate = Calendar.getInstance().getTime();
        reward.setRm_time(currDate);
        if(rewardService.insertReward(reward)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "adminReward";
    }
}
