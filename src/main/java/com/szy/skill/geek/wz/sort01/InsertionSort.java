package com.szy.skill.geek.wz.sort01;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈插入排序〉
 *
 * @author sunzhengyu
 * @create 2019/8/16
 * @since 1.0.0
 */
public class InsertionSort {

    public static void sort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        InsertionSort.sort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}