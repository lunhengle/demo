package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程数的线程池.
 * Created by lunhengle on 2017/3/19.
 */
public class TestFixedThreadExecutor {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        Thread thread4 = new MyThread();
        Thread thread5 = new MyThread();
        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);
        pool.execute(thread5);
        pool.shutdown();
    }
}
