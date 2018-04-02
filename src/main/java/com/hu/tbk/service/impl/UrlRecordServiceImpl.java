package com.hu.tbk.service.impl;

import com.hu.tbk.domain.UrlRecord;
import com.hu.tbk.repository.UrlRecordRepository;
import com.hu.tbk.service.UrlRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UrlRecordServiceImpl.java 2017/02/13 17:49
 */
@Service
public class UrlRecordServiceImpl implements UrlRecordService {

    @Autowired
    private UrlRecordRepository urlRecordRepository;

    public UrlRecord find(String url) {
        return urlRecordRepository.find(url);
    }
}