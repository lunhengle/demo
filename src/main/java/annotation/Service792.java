package annotation;

/**
 * Created by lunhengle on 2016/9/29.
 */
@PluginService
public class Service792 {
    @PluginService(filter = "792", version = "lorealcs")
    public void test() {
        System.out.println("这个调用的是 792 接口");
    }
}
