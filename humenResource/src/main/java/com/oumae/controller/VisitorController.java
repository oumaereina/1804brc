package com.oumae.controller;

import com.oumae.model.Visitor;
import com.oumae.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by oumaereina on 2018/10/19.
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Resource
    private VisitorService visitorService;

    @RequestMapping("/visitorLogin")
    public String login(@ModelAttribute("visitor") Visitor visitor, Model model) throws Exception {
        Visitor visitor1 = visitorService.getVisitor(visitor);
        if (null != visitor1) {
            model.addAttribute("msg", "登录成功");
            model.addAttribute("visitor", visitor1);
            return "main";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "../../index";
    }

    @RequestMapping("/visitorRegister")
    public String register(@ModelAttribute("visitor") Visitor visitor, Model model) throws Exception {
        if (visitorService.insertVisitor(visitor)) {
            model.addAttribute("msg", "注册成功");

        } else {
            model.addAttribute("msg", "注册失败");
        }
        return "main";
    }

    @RequestMapping("/checkName")
    public void checkName(String v_name, HttpSession session, Model model, HttpServletResponse response) throws Exception {
        Visitor visitor = visitorService.getVisitorByName(v_name);
       if(visitor!=null){
           response.getWriter().print("false");
       }else {
           response.getWriter().print("true");
       }

    }
}
