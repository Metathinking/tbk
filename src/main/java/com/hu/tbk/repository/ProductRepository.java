package com.hu.tbk.repository;

import com.hu.tbk.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ProductRepository.java 2016/12/11 19:24
 */
@Repository
public interface ProductRepository {

    void create(List<Product> products);

    void delete(List<Integer> ids);

    List<Product> list(Map<String, Object> params);

    int getCount(Map<String,Object> params);

    int getMaxId();

    void deleteOverDue(long now);

    List<String> listDuplicate();

    List<Product> listProductById(String productId);

    void deleteById(String id);

    void deleteAll();
}