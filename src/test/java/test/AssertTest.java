package test;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AssertTest.java 2017/01/26 18:22
 */
public class AssertTest {
    public static void main(String[] args) {
        assert 1+1==2;
        System.out.println("assert1 ok");
        assert 1+1==3:"assert faild,exit";
        System.out.println("assert2 ok");
    }
}