package com.hu.tbk.util;

import com.hu.tbk.domain.Product;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ExcelReader.java 2017/01/21 11:48
 */
public class ExcelReader {

    public static List<Product> readXls(InputStream inputStream) {
        List<Product> list = new ArrayList<Product>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            if (sheet != null) {
                int lastRowNum = sheet.getLastRowNum();
                for (int x = 1; x <= lastRowNum; x++) {
                    HSSFRow row = sheet.getRow(x);
                    if (row != null) {
                        list.add(rowToProduct(row));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Product rowToProduct(HSSFRow row) {
        Product product = new Product();
        String productId = row.getCell(0).getStringCellValue();
        String name = row.getCell(1).getStringCellValue();
        String image = row.getCell(2).getStringCellValue();
        String detail = row.getCell(5).getStringCellValue();
        String category = row.getCell(4).getStringCellValue();//todo
        String price = row.getCell(6).getStringCellValue();
        String sales = row.getCell(7).getStringCellValue();
        String scale = row.getCell(8).getStringCellValue();
        String money = row.getCell(9).getStringCellValue();
        String salerId = row.getCell(11).getStringCellValue();
        String salerName = row.getCell(12).getStringCellValue();
        String salerCategory = row.getCell(13).getStringCellValue();
        String couponId = row.getCell(14).getStringCellValue();
        String couponCount = row.getCell(15).getStringCellValue();
        String couponSurplus = row.getCell(16).getStringCellValue();
        String couponDetail = row.getCell(17).getStringCellValue();
        String startTime = row.getCell(18).getStringCellValue();
        String endTime = row.getCell(19).getStringCellValue();
        String tuiguangUrl = row.getCell(21).getStringCellValue();
        product.setProductId(productId);
        product.setName(name);
        product.setImage(image);
        product.setDetail(detail);
        product.setCategory(category);
        product.setPrice(Double.valueOf(price));
        product.setSales(Integer.valueOf(sales));
        product.setScale(Double.valueOf(scale));
        product.setMoney(Double.valueOf(money));
        product.setSalerId(salerId);
        product.setSalerName(salerName);
        product.setSalerCategory(salerCategory);
        product.setCouponId(couponId);
        product.setCouponCount(Integer.valueOf(couponCount));
        product.setCouponSurplus(Integer.valueOf(couponSurplus));
//        product.setCouponDetail(couponDetail);
        setCouponDetail(product,couponDetail);
        try {
            product.setStartTime(DateUtil.getTime(startTime));
            long oneDayTime = 24 * 60 * 60 * 1000;
            product.setEndTime(DateUtil.getTime(endTime) + oneDayTime - 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        product.setEndTimeString(endTime);
        product.setTuiguangUrl(tuiguangUrl);
        return product;
    }

    private static void setCouponDetail(Product product,String couponDetail){
        String regx="\\d+";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(couponDetail);
        matcher.groupCount();
        List<Double> numList=new ArrayList<Double>();
        while (matcher.find()) {
            double num = Double.parseDouble(matcher.group(0));
            numList.add(num);
        }
        if(numList.size()==1){
            double couponPrice = numList.get(0);
            product.setCouponDetail(String.valueOf(couponPrice));
            product.setNewPrice(product.getPrice()-couponPrice);
        }else if (numList.size()==2){
            double couponPrice = numList.get(1);
            double conditionPrice=numList.get(0);
            product.setCouponDetail(String.valueOf(couponPrice));
            if(product.getPrice()>=conditionPrice){
                product.setNewPrice(product.getPrice()-couponPrice);
            }else{
                product.setNewPrice(product.getPrice());
            }
        }
    }
}