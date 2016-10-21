import org.junit.Test;

/**
 * Created by lunhengle on 2016/9/9.
 */
public class TestHx {
    @Test
    public void testHx() {
        Hx hx = new Hx();
        hx.setH("world");
        this.setH(hx);
        this.setX(hx);
    }

    private void setH(Hx hx) {
        hx =new Hx();
        hx.setH("Hello");
    }

    private void setX(Hx hx) {
        System.out.println(hx.getH());
    }
}
