/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SubTest.java 2017/01/22 13:00
 */
public class SubTest {

    public static void main(String[] args) {
        int size = 10000;
        int count = 1000;
        int start = 0;
        int end = 0;
        int index = 0;
        while (end < size) {
            start = index * count;
            end = start + count;
            if (start!=0){
                start++;
            }
            index++;
            System.out.println("start:" + start + ";end:" + end);
        }
    }
}