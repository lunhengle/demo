package annotation;

/**
 * Created by lunhengle on 2016/10/20.
 */
@PluginService
public class Service793 {
    @PluginService(filter = "793", version = "lorealcs")
    public void test() {
        System.out.println("这个调用的是 793 接口");
    }
}
