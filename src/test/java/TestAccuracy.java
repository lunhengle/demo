import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 测试百分比.
 * Created by lunhengle on 2017/4/20.
 */
public class TestAccuracy {
    /**
     * 测试百分比.
     */
    @Test
    public void testAccuracy() {
        System.out.println(accuracy(1, 0, 2));
    }

    /**
     * 求取百分比.
     *
     * @param num   除数
     * @param total 被除数
     * @param scale 精确小数
     * @return 百分比
     */
    public double accuracy(final double num, final double total, final int scale) {
        if (total == 0) {
            return 0;
        } else {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
            decimalFormat.setMaximumFractionDigits(scale);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            double accuracyNum = num / total * 100;
            return Double.parseDouble(decimalFormat.format(accuracyNum));
        }
    }
}
