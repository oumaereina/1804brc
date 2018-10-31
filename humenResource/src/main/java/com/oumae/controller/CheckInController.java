package com.oumae.controller;

import com.oumae.model.CheckIn;
import com.oumae.model.Emp;
import com.oumae.model.Reward;
import com.oumae.model.Visitor;
import com.oumae.service.CheckInService;
import com.oumae.service.RewardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/30.
 */
@Controller
@RequestMapping("/checkIn")
public class CheckInController {
    @Resource
    private CheckInService checkInService;
    @Resource
    private RewardService rewardService;

    /*上班打卡*/
    @RequestMapping("/empCheckInOn")
    public String empCheckInOn(HttpSession session, Model model) throws Exception {
        //比较当前时间和早上9：00
        Emp emp = (Emp) session.getAttribute("emp");
        Date currDate = Calendar.getInstance().getTime();
        List<CheckIn> checkIns = checkInService.selectToday(currDate,0,emp.getE_id());
        if(checkIns.size()!=0){
            model.addAttribute("msgCheck","不能重复打卡");
            return "emp";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(currDate);
        String nowTime = new SimpleDateFormat("HH:mm:ss").format(currDate);
        int i = DateCompare(nowTime, "09:00:00", "HH:mm:ss");
        CheckIn checkIn = new CheckIn(emp.getE_id(), emp.getE_d_id(), emp.getE_p_id(), currDate, 0);//上班
        checkInService.insertCheckIn(checkIn);//录入打卡信息
        switch (i) {
            case 0:
                System.out.println("时间相等");
                model.addAttribute("msgCheck", "打卡成功");
                break;
            case 1:
                System.out.println("当前时间晚于09:00");
                int j = DateCompare(nowTime, "12:00:00", "HH:mm:ss");
                if (j == 1) {
                    System.out.println("当前时间晚于12:00");
                    Reward reward = new Reward((int) (-emp.getE_salary() / 22), currDate, "旷工", emp.getE_id(), 3);
                    rewardService.insertReward(reward);
                    model.addAttribute("msgCheck", "旷工,今天没有钱哦");
                } else {
                    Reward reward = new Reward(-10, currDate, "迟到", emp.getE_id(), 0);
                    rewardService.insertReward(reward);
                    model.addAttribute("msgCheck", "迟到打卡成功");
                }
                break;
            case -1:
                System.out.println("当前时间早于09:00");
                model.addAttribute("msgCheck", "打卡成功");
                break;
            default:
                break;
        }

        return "emp";
    }
    @RequestMapping("/empCheckInOut")
    public String empCheckInOut(HttpSession session, Model model) throws Exception {
        //比较当前时间和早上9：00
        Emp emp = (Emp) session.getAttribute("emp");
        Date currDate = Calendar.getInstance().getTime();
        List<CheckIn> checkInss = checkInService.selectToday(currDate,0,emp.getE_id());//找出今日打卡上班数据，否则不能打卡下班
        if(checkInss.size()==0){
            model.addAttribute("msgCheck","请先打卡上班");
            return "emp";
        }
        List<CheckIn> checkIns = checkInService.selectToday(currDate,1,emp.getE_id());//找出今日打卡下班数据，若没有可打卡下班
        if(checkIns.size()!=0){
            model.addAttribute("msgCheck","不能重复打卡");
            return "emp";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(currDate);
        String nowTime = new SimpleDateFormat("HH:mm:ss").format(currDate);
        int i = DateCompare(nowTime, "17:00:00", "HH:mm:ss");
        CheckIn checkIn = new CheckIn(emp.getE_id(), emp.getE_d_id(), emp.getE_p_id(), currDate, 1);//下班
        checkInService.insertCheckIn(checkIn);//录入打卡信息
        List<Reward> rewards = rewardService.selectToday(3,emp.getE_id());
        if(rewards.size()!=0){
            model.addAttribute("msgCheck", "您今日已旷工,打卡下班成功,不过今天没有钱哦");
            return "emp";
        }
        switch (i) {
            case 0:
                System.out.println("时间相等");
                model.addAttribute("msgCheck", "打卡成功");
                break;
            case 1:
                System.out.println("当前时间晚于17:00");
                model.addAttribute("msgCheck", "打卡成功");
                break;
            case -1:
                System.out.println("当前时间早于17:00");
                int j = DateCompare(nowTime, "14:00:00", "HH:mm:ss");
                if (j == -1) {
                    System.out.println("当前时间早于14:00");
                    Reward reward = new Reward((int) (-emp.getE_salary() / 22), currDate, "旷工", emp.getE_id(), 3);
                    rewardService.insertReward(reward);
                    model.addAttribute("msgCheck", "旷工");
                } else {
                    Reward reward = new Reward(-10, currDate, "早退", emp.getE_id(), 1);
                    rewardService.insertReward(reward);
                    model.addAttribute("msgCheck", "早退打卡成功");
                }
                break;
            default:
                break;
        }

        return "emp";
    }
    private int DateCompare(String source, String traget, String type) throws ParseException {
        int ret = 2;
        SimpleDateFormat format = new SimpleDateFormat(type);
        Date sourcedate = format.parse(source);
        Date tragetdate = format.parse(traget);
        ret = sourcedate.compareTo(tragetdate);
        return ret;
    }
}
