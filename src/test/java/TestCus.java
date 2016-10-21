import org.junit.Test;

/**
 * Created by lunhengle on 2016/9/7.
 */
public class TestCus {
    @Test
    public void testCus() {
        Lun lun = new Lun() {
            public void s(String s) {
                System.out.println("heee");
            }
        };
        lun.s("222");
    }
}
