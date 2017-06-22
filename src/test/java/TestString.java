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
        System.out.println(arr[0] + "######");
    }

    @Test
    public void testUpperCase() {
        String str = "";
        System.out.println(str.toUpperCase());
    }

    @Test
    public void testSplit3() {
        String str = ",a,b,c";
        if (null != str && str.startsWith(",")) {
            str = str.substring(1, str.length());
        }
        System.out.println(str);
    }

    @Test
    public void testSplit4() {
        String str = "1,2,3,";
        str = str.substring(0, str.length() - 1);
        System.out.println(str);
    }

    @Test
    public void testReplace() {
        String str = "你好世界，\n你好hello\n";
        str = str.replaceAll("\n", "<br/>");
        System.out.println(str);
    }

    @Test
    public void testReplace1() {
        String str = "你好世界，/n你好hello/n";
        str = str.replaceAll("/n", "<br/>");
        System.out.println(str);
    }

    @Test
    public void testReplace2() {
        String str = "你好,我是你的小秘书$$";
        str = str.replace("$$", "丫丫");
        System.out.println(str);
    }

    @Test
    public void testDouble() {
        Double d = 0.0;
        int i = d.intValue();
        System.out.println(i);
    }

    @Test
    public void testString1() {
        String str = "abc";
        String str1 = "abc";
        Assert.assertEquals(true, str == str1);
        Assert.assertEquals(true, str.equals(str1));
    }

    @Test
    public void testString2() {
        String str = new String("abc");
        String str1 = new String("abc");
        Assert.assertEquals(true, str.equals(str1));
        Assert.assertEquals(true, str == str1);
    }

    @Test
    public void testString3() {
        String str = "abc";
        String str1 = new String("abc");
        Assert.assertEquals(true, str.equals(str1));
        Assert.assertEquals(true, str == str1);
    }

    @Test
    public void testString4() {
        String str = "a";
        String str1 = "bc";
        String str2 = "abc";
        String str3 = str + str1;
        //Assert.assertEquals(true, str2 == str3);
        str3 = (str + str1).intern();
        Assert.assertEquals(true, str2 == str3);
    }

    @Test
    public void testString5() {
        String str = "MAC|ELC";
        str = str.replace("|ELC", "");
        System.out.println(str);
    }

    @Test
    public void testString6() {
        String str = "MAC";
        String[] strs = str.split("\\|");
        System.out.println(strs[0]);
    }
}
