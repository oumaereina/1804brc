package com.oumae.controller;

import com.oumae.model.Invite;
import com.oumae.service.InviteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by oumaereina on 2018/10/24.
 */
@Controller
@RequestMapping("/invite")
public class InviteController {
    @Resource
    private InviteService inviteService;
    /*发送面试邀请*/
    @RequestMapping("/addInvite")
    public ModelAndView addInvite(Integer vid, HttpSession session, Model model) throws Exception{
        List<Invite> invites = inviteService.selectInviteByVid(vid);
        if(invites!=null&&invites.size()!=0){
            model.addAttribute("msg", "添加失败,不能重复发送面试邀请");
        }else {
            Invite invite = new Invite();
            invite.setI_VID(vid);
            invite.setI_STATE(0);
            if(inviteService.insertInvite(invite)){
                model.addAttribute("msg", "添加成功");
            }else {
                model.addAttribute("msg", "添加失败");
            }
        }
        return new ModelAndView("redirect:selectReadResumeAdmin");
    }

}
