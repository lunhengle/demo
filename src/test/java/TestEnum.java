import enums.Enum;
import enums.Enum1;
import enums.Enum2;
import org.junit.Test;

/**
 * Created by lunhengle on 2016/9/27.
 */
public class TestEnum {
    @Test
    public void testEnum() {
        System.out.println(Enum.ONE.toString());
        System.out.println(Enum.TWO.toString());
        System.out.println(Enum.THREE.toString());
    }

    @Test
    public void testEnum1() {
        System.out.println(Enum1.ONE);
        System.out.println(Enum1.TWO);
        System.out.println(Enum1.THREE);
        System.out.println(Enum1.ONE.getValue());
        System.out.println(Enum1.TWO.getValue());
        System.out.println(Enum1.THREE.getValue());
    }

    @Test
    public void testEnum2() {
        Enum2[] enum2 = Enum2.values();
        for (Enum2 enum21 : enum2) {
            System.out.println(enum21.getKey() + " " + enum21.getValue());
        }
    }
}
