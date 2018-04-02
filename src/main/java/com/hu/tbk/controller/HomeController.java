package com.hu.tbk.controller;

import com.hu.tbk.domain.Product;
import com.hu.tbk.query.PageQuery;
import com.hu.tbk.query.ProductPageQuery;
import com.hu.tbk.service.ProductService;
import com.hu.tbk.util.ExceptionTipHandler;
import com.hu.tbk.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) HomeController.java 2017/01/16 20:00
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String gotoHome(@RequestParam(value = "index",required = false) Integer index,
                           @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "searchType",required = false) String searchType, Model model) {
        System.out.println("==================name:"+name);
        ProductPageQuery query = new ProductPageQuery();
        if(index==null){
            index=0;
        }
        query.setIndex(index);
        query.setName(name);
        query.setSearchType(searchType);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", query.getStart());
        map.put("size", query.getSize());
//        map.put("platform", query.getPlatform());
        if (!StringUtils.isEmpty(query.getName()) && !StringUtils.isEmpty(query.getName().trim())) {
            map.put("name", query.getName());
            map.put("searchType", query.getSearchType());
        }
        if (query.getOrders() != null && query.getOrders().length != 0) {
            map.put("orders", query.getOrders());
        }
        List<Product> list = productService.list(map);
        int count = productService.getCount(map);
        query.setCount(count);
        query.setPageInfo();
        model.addAttribute("list", list);
        model.addAttribute("pageQuery", query);
        return "home";
    }

    @RequestMapping(value = "home", method = RequestMethod.POST)
    @ResponseBody
    public Tip home(@RequestBody String url) {
        return new Tip(true, 100, "成功", "返回：" + url);
    }
}