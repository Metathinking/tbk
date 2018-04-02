package com.hu.tbk.domain;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UrlRecord.java 2016/12/15 13:51
 */
public class UrlRecord {

    private int id;
    private int productRecordId;//product 的id ;不是product 的 productId;
    private String primevalUrl;//原始url
    private String afterUrl;//转变后的地址
    private long endTime;//过期时间,过期后删除

    public int getProductRecordId() {
        return productRecordId;
    }

    public void setProductRecordId(int productRecordId) {
        this.productRecordId = productRecordId;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimevalUrl() {
        return primevalUrl;
    }

    public void setPrimevalUrl(String primevalUrl) {
        this.primevalUrl = primevalUrl;
    }

    public String getAfterUrl() {
        return afterUrl;
    }

    public void setAfterUrl(String afterUrl) {
        this.afterUrl = afterUrl;
    }
}