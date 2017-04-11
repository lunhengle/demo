package concurrent;

/**
 * 多线程并发.
 * Created by lunhengle on 2017/3/19.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在运行！");
    }
}
