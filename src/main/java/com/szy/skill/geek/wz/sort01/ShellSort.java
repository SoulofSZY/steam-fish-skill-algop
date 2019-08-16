package com.szy.skill.geek.wz.sort01;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈希尔排序（插入排序的优化）〉
 *  相对于
 * @author sunzhengyu
 * @create 2019/8/16
 * @since 1.0.0
 */
public class ShellSort {

    public static void sort(int[] a, int n) {
        if (n <= 1) return;

        //1. 获取h值
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i += h) {
                int val = a[i];
                int j = i - h;
                for (; j >= 0; j -= h) {
                    if (a[j] > val) {
                        a[j + h] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + h] = val;
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 6, 9, 7, 8};
        ShellSort.sort(a, a.length);

        System.out.println(Arrays.toString(a));
    }
}