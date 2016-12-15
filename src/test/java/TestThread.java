import org.junit.Before;
import org.junit.Test;
import thread.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lunhengle on 2016/12/7.
 */
public class TestThread {
    private List<User> userList;

    @Before
    public void setUp() {
        userList = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("123456");
        user.setNum(100);

        User user1 = new User();
        user1.setId(2);
        user1.setUsername("李四");
        user1.setPassword("123456");
        user1.setNum(10);

        User user2 = new User();
        user2.setId(3);
        user2.setUsername("王五");
        user2.setPassword("123465");
        user2.setNum(10);
    }

    @Test
    public void testLottery() {

    }
    private void doThread(){
        ExecutorService cachThread= Executors.newCachedThreadPool();
    }
}
