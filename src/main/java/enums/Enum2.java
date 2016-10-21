package enums;

/**
 * Created by lunhengle on 2016/9/27.
 */
public enum Enum2 {
    RED(1, "红色"), GREEN(2, "绿色"), YELLOW(3, "黄色");
    private int key;
    private String value;

    private Enum2() {

    }

    private Enum2(int _value) {

    }

    private Enum2(int _key, String _value) {
        this.key = _key;
        this.value = _value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
