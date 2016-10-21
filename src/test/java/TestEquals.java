import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lunhengle on 2016/10/19.
 */
public class TestEquals {
    @Test
    public void testEquals() {
        Equals equals = new Equals();
        Object equals1 = new Equals();
        Assert.assertTrue(equals.equals(equals1));
    }
}
