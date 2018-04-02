package test;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BreakTest.java 2017/01/26 18:16
 */
public class BreakTest {
    public static void main(String[] args) {
        out:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j>=2){
                    break out;
                }
                System.out.println(j);
            }
            System.out.println("in out");
        }
        System.out.println("break");
    }
}