package com.hu.tbk.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminHomeController.java 2017/01/18 14:01
 */
@Controller
public class AdminHomeController {


    @RequestMapping(value ="admin/home" ,method = RequestMethod.GET)
    public String gotoHome(){
        return "admin/file_upload";
    }

}