import junit.framework.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by lunhengle on 2016/8/22.
 */
public class TestString {
    @Test
    public void testSplit() {
        String str = "hello" + "," + "world" + "," + "";
        String[] arr = str.split(",");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }

    @Test
    public void testSplitArray() {
        String str = "hello";
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void testString() {
        String str = "hello:";
        String[] arr = str.split(":");
        Assert.assertEquals(2, arr.length);
    }

    @Test
    public void testUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }

    @Test
    public void testSplit1() {
        String str = "cb4daf619b3e446085a4026b85e33ad3.png";
        String[] arr = str.split("\\.");
        str = arr[0] + "_640x280" + "." + arr[1];
        System.out.println(str);
    }

    @Test
    public void testSplit2() {
        String str = "aa";
        String[] arr = str.split("\\|");
        System.out.println(arr[0] + "######" );
    }
}
