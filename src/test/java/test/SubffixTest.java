package test;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SubffixTest.java 2017/03/06 10:07
 */
public class SubffixTest {

    public static void main(String[] args) {
        String name="123123.jpg";
        String subffix= name.substring(name.lastIndexOf("."));
        System.out.println(subffix);
    }
}