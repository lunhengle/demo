import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lunhengle on 2016/11/9.
 */
public class TestRandom {
    @Test
    public void testRandom() {
        System.out.println(RandomUtils.nextInt(100));
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal.add(bigDecimal1));
    }

    @Test
    public void testRandom1() {
        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(0);
        BigDecimal b3 = new BigDecimal(0);
        BigDecimal b4 = new BigDecimal(0);
        String[] arr = new String[]{"0.5", "9.5", "10", "80"};
        for (int i = 0; i < 8000; i++) {
            BigDecimal b = new BigDecimal(1);
            Map<String, Double> map = new HashMap<String, Double>();
            for (String str : arr) {
                map.put(str, RandomUtils.nextInt(100) * Double.valueOf(str));
            }
            Double weight = 0d;
            String key = null;
            for (String str : map.keySet()) {
                Double hit_count = map.get(str);
                if (hit_count > weight) {
                    weight = hit_count;
                    key = str;
                }
            }
            if ("0.5".equals(key)) {
                b1 = b1.add(b);
            } else if ("9.5".equals(key)) {
                b2 = b2.add(b);
            } else if ("10".equals(key)) {
                b3 = b3.add(b);
            } else if ("80".equals(key)) {
                b4 = b4.add(b);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(0);
        bigDecimal = bigDecimal.add(b1).add(b2).add(b3).add(b4);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);
        System.out.println("bigDecimal = " + bigDecimal);
        System.out.println("b1 % = " + b1.divide(bigDecimal, 6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println("b2 % = " + b2.divide(bigDecimal, 6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println("b3 % = " + b3.divide(bigDecimal, 6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println("b4 % = " + b4.divide(bigDecimal, 6, BigDecimal.ROUND_HALF_EVEN));
    }
}
