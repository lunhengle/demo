package enums;

/**
 * Created by lunhengle on 2016/9/27.
 * 构造函数枚举
 */
public enum Enum1 {
    //利用构造函数传参
    ONE(1), TWO(2), THREE(3);
    //定义私有变量
    private int code;

    //定义私有变量构造函数
    private Enum1(int _code) {
        this.code = _code;
    }

    //返回当前值
    public int getValue() {
        return code;
    }
}
