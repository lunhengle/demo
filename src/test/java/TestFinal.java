import org.junit.Test;

/**
 * 测试final.
 * Created by lunhengle on 2017/3/25.
 */
public class TestFinal {
    @Test
    public void testFinal() {
        Hx hx = new Hx();
        hx.setX("10");
        hx.setH("10");
        hx = this.setHx(hx);
        System.out.println("x: " + hx.getX() + " h: " + hx.getH());
    }

    private Hx setHx(final Hx hx) {
        hx.setX("20");
        hx.setH("20");
        return hx;
    }
}
