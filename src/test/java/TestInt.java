import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lunhengle on 2016/10/18.
 */
public class TestInt {
    @Test
    public void testInt() {
        IntObject intObject = new IntObject();
        Assert.assertEquals(0, intObject.getI());
        Assert.assertEquals(1, intObject.getI() + 1);
    }

    class IntObject {
        private int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
