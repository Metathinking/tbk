package com.hu.tbk.service;

import com.hu.tbk.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ProductService.java 2017/01/22 09:50
 */
public interface ProductService {

    void save(List<Product> products, HttpServletRequest request);

    void deleteAll();

    void delete(List<Integer> ids);

    List<Product> list(Map<String, Object> params);

    int getCount(Map<String,Object> params);

    void deleteOverDue();

    void deleteDuplicate();

    void deleteById(String id);

}