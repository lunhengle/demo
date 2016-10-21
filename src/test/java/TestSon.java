import org.junit.Assert;
import org.junit.Test;
import reconstruction.chapter8.Son;

/**
 * Created by lunhengle on 2016/10/19.
 */
public class TestSon {
    @Test
    public void testSon() {
        Son son = Son.create();
        Son son1 = Son.create();
        Assert.assertEquals(son, son1);
    }
}
