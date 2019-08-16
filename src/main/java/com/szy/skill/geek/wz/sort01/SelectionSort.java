package com.szy.skill.geek.wz.sort01;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈选择排序〉
 *
 * @author sunzhengyu
 * @create 2019/8/16
 * @since 1.0.0
 */
public class SelectionSort {


    public static void sort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            int tempIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[tempIdx]) {
                    tempIdx = j;
                }
            }
            if (tempIdx != i) {
                int tempVal = a[i];
                a[i] = a[tempIdx];
                a[tempIdx] = tempVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4};
        SelectionSort.sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}