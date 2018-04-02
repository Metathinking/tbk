package test;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) test.Obj.java 2017/01/26 09:06
 */
public class Obj {

    private String str="default value";
    public void setStr(String str){
        this.str=str;
    }
    public String toString(){
        return str;
    }

    public static void main(String[] args) {
        TestRef oRef = new TestRef();
        System.out.println("***********引用类型************");
        System.out.println("调用changeObj()前:"+oRef.getaObj());
        oRef.changeObj(oRef.getaObj());
        System.out.println("调用changeObj()后："+oRef.getaObj());

        System.out.println("************基本数据类型*******************");
        System.out.println("调用changeInt()前："+oRef.getAInt());
        oRef.changeInt(oRef.getAInt());
        System.out.println("调用changeInt()后："+oRef.getAInt());
    }
}
class TestRef{
    private Obj aObj = new Obj();
    private int aInt=0;

    public Obj getaObj(){
        return aObj;
    }

    public int getAInt(){
        return aInt;
    }

    public void changeObj(Obj inObj){
        inObj.setStr("changed value");
    }

    public void changeInt(int inInt){
        inInt=1;
    }
}