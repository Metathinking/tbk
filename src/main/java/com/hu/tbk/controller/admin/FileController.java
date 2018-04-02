package com.hu.tbk.controller.admin;

import com.hu.tbk.domain.Product;
import com.hu.tbk.query.PageQuery;
import com.hu.tbk.service.ProductService;
import com.hu.tbk.util.DateUtil;
import com.hu.tbk.util.ExcelReader;
import com.hu.tbk.util.ExceptionTipHandler;
import com.hu.tbk.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FileController.java 2017/01/19 17:41
 */
@Controller
public class FileController {



    @RequestMapping(value = "uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public Tip uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if(file!=null &&!file.isEmpty()){
            try{
                String name = file.getOriginalFilename();
                String suffix= name.substring(name.lastIndexOf("."));
                String fileName=DateUtil.getyMdHmsateDate()+suffix;
                String filePath = "resources\\upload\\"+ fileName;

                file.transferTo(new File(rootDirectory+filePath));

//                String contextPath = request.getContextPath();
//                String serverUrl = request.getScheme()+"://"+request.getServerName()+contextPath;
                return new Tip(true,100,"保存成功","/resources/upload/"+fileName);
            }catch (Exception e){
                e.printStackTrace();
                return new Tip(false,101,"上传失败："+e.getMessage());
            }
        }
        return new Tip(false,102,"文件不存在");
    }
}