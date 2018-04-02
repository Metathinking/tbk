import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) StringTest.java 2017/03/06 17:09
 */
public class StringTest {

    public static void main(String[] args) {
        String string1="满130元减80元";
        String string2="3元无条件券";

        String regx="\\d+";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(string1);
        while (matcher.find()) {
            System.out.println("count:"+matcher.groupCount());
            System.out.println(matcher.group(0));
        }
    }
}