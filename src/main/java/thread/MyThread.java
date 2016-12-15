package thread;

/**
 * Created by lunhengle on 2016/12/7.
 */
public class MyThread implements Runnable {
  
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行");
    }
}
