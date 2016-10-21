/**
 * Created by lunhengle on 2016/8/26.
 */
public class World extends Hello {
    static {
        System.out.println("world 静态代码块");
    }

    {
        System.out.println("world 构造函数 代码块");
    }

    public World() {
        System.out.println("world 构造函数");
    }
}
