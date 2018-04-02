package test;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) test.Base.java 2017/01/25 15:49
 */
public class Base {

    static{
        System.out.println("test.Base static block");
    }

    {
        System.out.println("test.Base block");
    }

    public Base() {
        System.out.println("test.Base constructor");
    }
}

class Derived extends Base{
    static {
        System.out.println("test.Derived static block");
    }

    {
        System.out.println("test.Derived block");
    }

    public Derived() {
        System.out.println("test.Derived constructor");
    }


}
class B extends Object{
    static {
        System.out.println("Load B1");
    }

    public B(){
        System.out.println("Create test.B");
    }

    {
        System.out.println("Load B2");
    }
}

class A extends B{
    static {
        System.out.println("Load test.A");
    }

    public A(){
        System.out.println("Create test.A");
    }

    public static void main(String[] args) {
        new A();
    }
}