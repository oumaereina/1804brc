package com.oumae.controller;

import com.oumae.model.Invite;
import com.oumae.service.InviteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/24.
 */
@Controller
@RequestMapping("/invite")
public class InviteController {
    @Resource
    private InviteService inviteService;
    @RequestMapping("/addInvite1")
    public String addInvite1(Integer vid, HttpSession session, Model model) throws Exception{
        model.addAttribute("vid",vid);
        return "adminInvite";
    }
    /*发送面试邀请*/
    @RequestMapping("/addInvite2")
    public ModelAndView addInvite2(Invite invite,HttpSession session, Model model) throws Exception{
        Date currDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(invite.getI_DATE());
        if(date.getTime()-currDate.getTime()<86400000){
            session.setAttribute("msg","面试时间须在当前时间24小时之后");
            return new ModelAndView("redirect:/pages/adminInvite.jsp");
        }
        List<Invite> invites = inviteService.selectInviteByVid(invite.getI_VID());
        if(invites!=null&&invites.size()!=0){
            model.addAttribute("msg", "添加失败,不能重复发送面试邀请");
        }else {
            if(inviteService.insertInvite(invite)){
                model.addAttribute("msg", "添加成功");
            }else {
                model.addAttribute("msg", "添加失败");
            }
        }
        return new ModelAndView("redirect:/resume/selectReadResumeAdmin");
    }

}
