package com.hu.tbk.controller;

import com.hu.tbk.domain.UrlRecord;
import com.hu.tbk.service.UrlRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UrlChangeController.java 2017/02/13 16:52
 */
@Controller
public class UrlChangeController {

    @Autowired
    private UrlRecordService urlRecordService;

    @RequestMapping(value = "/to/{url}",method = RequestMethod.GET)
    public String to(@PathVariable(value = "url")String url){
        UrlRecord urlRecord = urlRecordService.find(url);
        if(urlRecord==null){
            return "redirect:/";
        }
        return "redirect:"+urlRecord.getPrimevalUrl();
    }
}