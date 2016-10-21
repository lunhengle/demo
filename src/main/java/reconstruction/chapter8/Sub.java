package reconstruction.chapter8;

/**
 * Created by lunhengle on 2016/10/19.
 */
public class Sub {
    private int _low;
    private int _hight;
    public Sub(){}

    public Sub(int low, int hight) {
        this.init(low, hight);
    }

    private void init(int low, int hight) {
        _low = low;
        _hight = hight;
    }
}
