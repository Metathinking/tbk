package com.hu.tbk.repository;

import com.hu.tbk.domain.UrlRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UrlRecordRepository.java 2017/02/13 15:45
 */
@Repository
public interface UrlRecordRepository {

    void create(UrlRecord urlRecords);

    void deleteByProductRecordIds(List<Integer> ids);

    List<UrlRecord> list(Map<String, Object> params);

    int getCount(Map<String,Object> params);

    int getMaxId();

    void deleteOverDue(long now);

    UrlRecord find(String url);

    void deleteAll();

    List<String> listDuplicateIds();
}