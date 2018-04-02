package com.hu.tbk.service;

import com.hu.tbk.domain.UrlRecord;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UrlRecordService.java 2017/02/13 17:49
 */
public interface UrlRecordService {

    UrlRecord find(String url);
}