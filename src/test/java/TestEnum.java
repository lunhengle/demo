import enums.BaInfo;
import enums.Enum;
import enums.Enum1;
import enums.Enum2;
import org.junit.Test;

import java.util.Map;

/**
 * Created by lunhengle on 2016/9/27.
 */
public class TestEnum {
    @Test
    public void testEnum() {
        System.out.println(Enum.ONE.ordinal());
        System.out.println(Enum.TWO.ordinal());
        System.out.println(Enum.THREE.ordinal());
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

    @Test
    public void testBaInfo() {
        Map<Integer, String> map = BaInfo.getTypes();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
        System.out.println(BaInfo.BA_INFO_ROLE_CODE_CLERK.getValue());
    }
}
