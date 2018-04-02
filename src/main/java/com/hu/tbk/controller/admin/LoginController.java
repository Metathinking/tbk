package com.hu.tbk.controller.admin;

import com.hu.tbk.domain.Admin;
import com.hu.tbk.service.AdminService;
import com.hu.tbk.util.ExceptionTipHandler;
import com.hu.tbk.util.Md5Factory;
import com.hu.tbk.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) LoginController.java 2017/01/16 20:19
 */
@Controller
@RequestMapping("adminLogin")
public class LoginController {


    @Autowired
    private AdminService adminService;

    private final String ADMIN="ADMIN";

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Tip login(@RequestBody Admin admin, HttpServletRequest request, HttpSession session) {
        try {
            if(StringUtils.isEmpty(admin.getId())){
                return new Tip(false,101,"请输入账号",null);
            }
            if(StringUtils.isEmpty(admin.getPassword())||admin.getPassword().equals(Md5Factory.encoding(""))){
                return new Tip(false,102,"请输入密码",null);
            }
            Object codeObject = session.getAttribute("CODE");
            if(codeObject==null){
                return new Tip(false,104,"验证码失效，请刷新验证码",null);
            }
            if(StringUtils.isEmpty(admin.getCode())){
                return new Tip(false,103,"请输入验证码",null);
            }
            String code = (String) codeObject;
            if(!admin.getCode().equalsIgnoreCase(code)){
                return new Tip(false,105,"验证码错误",null);
            }
            Admin loginAdmin = adminService.login(admin, request.getRemoteAddr());
            session.setAttribute(ADMIN,loginAdmin);
            return new Tip(true,100,"登录成功",null);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value="logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.setAttribute(ADMIN,null);
        return "redirect:/";
    }
}