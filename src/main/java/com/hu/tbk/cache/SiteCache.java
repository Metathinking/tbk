package com.hu.tbk.cache;


import com.hu.tbk.domain.SiteInfo;
import com.hu.tbk.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteCache.java 2016/07/05 10:47
 */
@Component
public class SiteCache {

    private static Map<String,Object> map = new HashMap<String, Object>();

    @Autowired
    private SiteInfoService siteInfoService;

    private static SiteInfoService staticSiteInfoService;


    @PostConstruct
    public void init(){
        staticSiteInfoService = this.siteInfoService;
    }

    public static void put(String key,Object value){
        map.put(key,value);
    }

    public static final String SITE_INFO="siteInfo";
    public static final String SITE_SETTING="siteSetting";
    public static final String COLUMN_LIST = "columnList";

    public static SiteInfo getSiteInfo(){
        Object object = map.get(SITE_INFO);
        if(object==null){
            SiteInfo siteInfo = staticSiteInfoService.find();
            map.put(SITE_INFO,siteInfo);
            return siteInfo;
        }
        return (SiteInfo) object;
    }


}