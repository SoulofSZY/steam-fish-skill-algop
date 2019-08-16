package com.szy.skill.geek.wz.sort01;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈冒泡排序〉
 *
 * @author sunzhengyu
 * @create 2019/8/16
 * @since 1.0.0
 */
public class BubbleSort {

    /**
     * @param a 待排序数组
     * @param n 数组元素个数
     */
    public static void sort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡的标记
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // 只对大于的情况交换 保证稳定性
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        BubbleSort.sort(arr, 5);

        System.out.println(Arrays.toString(arr));
    }
}