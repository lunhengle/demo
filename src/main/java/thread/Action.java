package thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lunhengle on 2016/12/7.
 * 行为表
 */
public class Action {
    /**
     * 得到用户信息.
     *
     * @return 用户信息
     */
    private User getUser() {
        return new User();
    }

    /**
     * 抽奖.
     */
    public void doLottery(List<User> userList) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            public void run() {
                System.out.println("2");
            }
        });
    }

    private void go(User user) {
        synchronized (user) {

        }
    }
}
