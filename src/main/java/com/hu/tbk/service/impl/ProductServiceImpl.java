package com.hu.tbk.service.impl;

import com.hu.tbk.domain.Product;
import com.hu.tbk.domain.UrlRecord;
import com.hu.tbk.repository.ProductRepository;
import com.hu.tbk.repository.UrlRecordRepository;
import com.hu.tbk.service.ProductService;
import com.hu.tbk.util.ShortUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ProductServiceImpl.java 2017/01/22 09:55
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UrlRecordRepository urlRecordRepository;

    public void save(List<Product> products, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String host = request.getScheme() + "://" + request.getServerName() + contextPath + ":" + request.getServerPort();
        int maxId = productRepository.getMaxId();
        for (Product product : products) {
            maxId++;
            product.setId(maxId);
        }
        int size = products.size();
        int count = 1000;

        List<String> afterUrlList= new ArrayList<String>();//排除重复可能
        if (size > count) {
            int start = 0;
            int end = 0;
            int index = 0;
            while (end < size) {
                start = index * count;
                end = start + count;
                if (start != 0) {
                    start++;
                }
                if (end > size) {
                    end = size;
                }
                index++;
                System.out.println("start:" + start + ";end:" + end);
                List<Product> subList = products.subList(start, end);
                changeUrl(subList, host,afterUrlList);
                productRepository.create(subList);
            }
        } else {
            productRepository.create(products);
        }
    }

    private void changeUrl(List<Product> products, String host,List<String> afterUrlList) {
        int maxId = urlRecordRepository.getMaxId();
        for (Product product : products) {
            maxId++;
            product.setDetail(host + "/to/" + changeUrl(product.getDetail(), maxId, product,afterUrlList));
            maxId++;
            product.setTuiguangUrl(host + "/to/" + changeUrl(product.getTuiguangUrl(), maxId, product,afterUrlList));
        }
    }

    private String changeUrl(String url, int id, Product product,List<String> afterUrlList) {
       String shortUrl=getShortUrl(url,afterUrlList);
        UrlRecord urlRecord = new UrlRecord();
        urlRecord.setId(id);
        urlRecord.setProductRecordId(product.getId());
        urlRecord.setPrimevalUrl(url);
        urlRecord.setAfterUrl(shortUrl);
        urlRecord.setEndTime(product.getEndTime());
        urlRecordRepository.create(urlRecord);
        return shortUrl;
    }

    /**
     * url 重复的处理
     * @param url
     * @param afterUrlList
     * @return
     */
    private String getShortUrl(String url,List<String> afterUrlList){
        String[] strings = ShortUrlUtil.shortText(url);
        String shortUrl = null;
        for(String string:strings){
            if(!afterUrlList.contains(string)){
                shortUrl=string;
                afterUrlList.add(shortUrl);
                break;
            }
        }
        if(shortUrl==null){//todo 更好的处理方案 递归
            shortUrl=strings[0]+strings[1];
            afterUrlList.add(shortUrl);
        }
        return shortUrl;
    }

    public void delete(List<Integer> ids) {
        productRepository.delete(ids);
    }

    public List<Product> list(Map<String, Object> params) {
        return productRepository.list(params);
    }

    public int getCount(Map<String, Object> params) {
        return productRepository.getCount(params);
    }

    public void deleteOverDue() {
        long now = System.currentTimeMillis();
        productRepository.deleteOverDue(now);
        urlRecordRepository.deleteOverDue(now);
    }

    /**
     * 删除之前所有的
     */
    public void deleteAll() {
        productRepository.deleteAll();
        urlRecordRepository.deleteAll();
    }

    /**
     * 删除重复数据
     */
    public void deleteDuplicate() {
        List<Integer> deleteIds = new ArrayList<Integer>();
        List<String> productIds = productRepository.listDuplicate();
        for (String productId : productIds) {
            List<Product> list = productRepository.listProductById(productId);
            Product product = list.get(0);
            list.remove(0);
            for (Product pd : list) {
                if (product.getCouponId() == pd.getCouponId()) {
                    deleteIds.add(pd.getId());
                } else if (product.getEndTime() >= pd.getEndTime()) {
                    deleteIds.add(pd.getId());
                } else {
                    deleteIds.add(product.getId());
                    product = pd;
                }
            }
        }
        if(deleteIds.isEmpty()){
            return;
        }
        productRepository.delete(deleteIds);
        urlRecordRepository.deleteByProductRecordIds(deleteIds);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}