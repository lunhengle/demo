/**
 * Created by lunhengle on 2016/8/26.
 */
public class Hello {
    static {
        System.out.println("hello 静态代码块");
    }

    {
        System.out.println("hello 构造函数代码块");
    }

    public Hello() {
        System.out.println("hello 构造函数");
    }
}
