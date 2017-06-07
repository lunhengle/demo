import org.junit.Test;
import reconstruction.chapter8.Son;
import reconstruction.chapter8.Sub;

/**
 * Created by lunhengle on 2017/5/24.
 */
public class TestParent {
    @Test
    public void test(){
        Son sub =new Son();
        this.aa(sub);
    }
    private void aa(Sub son){}
}
