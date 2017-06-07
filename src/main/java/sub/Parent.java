package sub;

/**
 * Created by lunhengle on 2016/11/4.
 */
public abstract class Parent {
    public Parent() {
        System.out.println("this is parent");
    }

    public abstract void back();

    public void before() {
        System.out.println("Parent before()");
    }

    public void refresh() {
        System.out.println("Parent refresh()");
        back();
        before();
    }
}
