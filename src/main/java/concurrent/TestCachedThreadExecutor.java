package concurrent;

import sun.awt.PaintEventDispatcher;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个可重用固定线程数的线程池.
 * Created by lunhengle on 2017/3/19.
 */
public class TestCachedThreadExecutor {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
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
