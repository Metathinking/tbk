package com.hu.tbk.controller.admin;

import com.hu.tbk.domain.Product;
import com.hu.tbk.query.PageQuery;
import com.hu.tbk.query.ProductPageQuery;
import com.hu.tbk.service.ProductService;
import com.hu.tbk.util.ExcelReader;
import com.hu.tbk.util.ExceptionTipHandler;
import com.hu.tbk.util.Tip;
import javafx.geometry.Pos;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ProductController.java 2017/01/22 14:11
 */
@Controller
@RequestMapping("admin/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String gotoList() {
        return "admin/product-list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Tip list(@RequestBody ProductPageQuery query) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", query.getStart());
            map.put("size", query.getSize());
            map.put("platform", query.getPlatform());
            if (!StringUtils.isEmpty(query.getName()) && !StringUtils.isEmpty(query.getName().trim())) {
                map.put("name", query.getName());
                map.put("searchType", query.getSearchType());
            }
            if (query.getOrders()!=null&&query.getOrders().length!=0){
                map.put("orders",query.getOrders());
            }
            List<Product> list = productService.list(map);
            int count = productService.getCount(map);
            query.setCount(count);
            Map<String, Object> backMap = new HashMap<String, Object>();
            backMap.put("list", list);
            backMap.put("pageQuery", query);
            return new Tip(true, 100, "查询成功", backMap);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "deleteOverDue", method = RequestMethod.POST)
    @ResponseBody
    public Tip deleteOverDue() {
        try {
            productService.deleteOverDue();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(false, 101, e.getMessage());
        }
        return new Tip(true, 100, "成功");
    }

    @RequestMapping(value = "deleteDuplicate", method = RequestMethod.POST)
    @ResponseBody
    public Tip deleteDuplicate() {
        try {
            productService.deleteDuplicate();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(false, 101, e.getMessage());
        }
        return new Tip(true, 100, "成功");
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.POST)
    @ResponseBody
    public Tip deleteById(@RequestParam String id){
        try{
            productService.deleteById(id);
            return new Tip(true,100,"成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return ExceptionTipHandler.handler(ex);
        }
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String gotoUpload() {
        return "admin/file_upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
        if (file != null && !file.isEmpty()) {
            try {
                List<Product> productList = ExcelReader.readXls(file.getInputStream());
                productService.deleteAll();
                productService.save(productList, request);
                productService.deleteOverDue();
                productService.deleteDuplicate();
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("error",e.getMessage());
                return "admin/file_upload";
//                return new Tip(false, 101, "保存失败");
            }
        }
        return "redirect:/admin/product/list";
    }
}