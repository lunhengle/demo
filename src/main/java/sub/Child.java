package sub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lunhengle on 2016/11/4.
 */
public class Child extends Parent {
    public Child() {
        System.out.println("this is child");
    }

    public void back() {
        System.out.println("child back()");
    }

    public void before() {
        System.out.println("child before()");
    }
}
