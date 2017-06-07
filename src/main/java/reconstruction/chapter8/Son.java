package reconstruction.chapter8;

/**
 * Created by lunhengle on 2016/10/19.
 */
public class Son extends Sub {
    private int _cap;
    public Son(){}

    public Son(int low, int hight, int cap) {
        super(low, hight);
        _cap = cap;
    }

    public static Son create() {
        return new Son();
    }
}
