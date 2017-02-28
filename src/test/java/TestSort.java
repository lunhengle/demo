import org.junit.After;
import org.junit.Test;

/**
 * java 排序算法.
 * Created by lunhengle on 2017/2/28.
 */
public class TestSort {
    /**
     * 定义要排序的数组.
     */
    private static int[] a = {85, 12, 98, 57, 75, 63, 54, 52, 68, 4, 9, 41, 92, 58, 68};

    /**
     * 插入排序.
     * 基本思想：在要排序的一组数组中，假设前面(n-1)[n>=2]个数已经是排好的顺序，
     * 现在要把第n个数插入的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    @Test
    public void testInsertSort() {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
        }
    }

    /**
     * 简单选择排序.
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换
     * 然后在剩下的数中再找最小的与第二个位置的数交换，如此循环到倒数的第二个数和最后一个数为止。
     */
    @Test
    public void testSelectSort() {
        int position;
        for (int i = 0; i < a.length; i++) {
            position = i;
            int j = i + 1;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (a[j] < temp) {
                    position = j;
                    temp = a[j];
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
    }

    /**
     * 排序后的数组.
     */
    @After
    public void after() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
