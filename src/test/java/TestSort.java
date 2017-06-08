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
        for (int i = 0; i < a.length; i++) {
            int position = i;
            int j = i + 1;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (temp > a[j]) {
                    position = j;
                    temp = a[j];
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
    }

    /**
     * 冒泡排序法.
     * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次比较和调整，让较大的数往下沉，较小的往上冒。
     * 即每当相邻的数比较后发现它们与要求的排序相反时，就将它们互换。
     */
    @Test
    public void testBubbleSort() {
        for (int i = 0; i < a.length - 1; i++) {
            int temp;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序法.
     * 基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，通过扫描将待排序序列分成两部分，一部分比基准小，一部分大于等于基准元素
     * 此时基准元素在其排好序后的正确位置，然后同样的方法递归地排序划分两部分。
     */
    @Test
    public void testQuickSort() {
        quick(a);
    }

    /**
     * 得到中间值.
     *
     * @param list 数组列表
     * @param low  低
     * @param high 高
     * @return 中间值
     */
    public int getMiddle(int[] list, int low, int high) {
        int temp = list[low];
        while (low < high) {
            while (low < high && list[high] >= temp) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= temp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = temp;
        return low;
    }

    /**
     * 快查.
     *
     * @param list 查询列表.
     * @param low  低
     * @param high 高
     */
    public void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            quickSort(list, low, middle - 1);
            quickSort(list, middle + 1, high);
        }
    }

    /**
     * 查询.
     *
     * @param a 数组
     */
    private void quick(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    /**
     * 排序后的数组.
     */
    @After
    public void after() {
        for (int i : a) {
            System.out.println(i);
        }
    }
}
