package com.hu.tbk.domain;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) Product.java 2016/12/11 19:25
 */
public class Product {

    private int id;
    private String productId;//商品id
    private String name;//商品名称
    private String image;//主图url
    private String detail;//详情页url
    private String category;//分类id
    private double price;//商品价格
    private double newPrice;//券后价
    private int sales;//销量
    private double scale;//佣金比例
    private double money;//佣金
    private String salerId;//卖家id
    private String salerName;//卖家名称
    private String salerCategory;//卖家平台 淘宝|天猫
    private String couponId;//优惠券ID
    private int couponCount;//优惠券总数量
    private int couponSurplus;//优惠券剩余数量
    private String couponDetail;//优惠券面额
    private long startTime;//开始时间
    private long endTime;//结束时间
    private String endTimeString;//结束时间描述符
    private String tuiguangUrl;//推广链接

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getSalerId() {
        return salerId;
    }

    public void setSalerId(String salerId) {
        this.salerId = salerId;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getSalerCategory() {
        return salerCategory;
    }

    public void setSalerCategory(String salerCategory) {
        this.salerCategory = salerCategory;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    public int getCouponSurplus() {
        return couponSurplus;
    }

    public void setCouponSurplus(int couponSurplus) {
        this.couponSurplus = couponSurplus;
    }

    public String getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTuiguangUrl() {
        return tuiguangUrl;
    }

    public void setTuiguangUrl(String tuiguangUrl) {
        this.tuiguangUrl = tuiguangUrl;
    }
}