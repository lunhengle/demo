package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 固定时间执行线程.
 * Created by lunhengle on 2017/3/19.
 */
public class TestScheduledThreadExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("========================================");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + System.nanoTime());
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
