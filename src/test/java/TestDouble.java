import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 测试double.
 * Created by lunhengle on 2017/4/12.
 */
public class TestDouble {
    @Test
    public void testDouble() {
        double d = 1.2345566;
        DecimalFormat decimalFormat = new DecimalFormat("#######.00");
        String s = decimalFormat.format(d);
        System.out.println(d);
        System.out.println(s);
    }
    @Test
    public void testDouble1(){
        String d="1.234566";
        BigDecimal bg=new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        System.out.println(bg.doubleValue());
    }
}
