package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lunhengle on 2016/12/7.
 * 测试单一线程池
 */
public class TestSingleThread {
    public static void main(String[] args){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        //关闭线程池
        pool.shutdown();
    }
}
