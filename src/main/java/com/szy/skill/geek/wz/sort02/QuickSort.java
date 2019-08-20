package com.szy.skill.geek.wz.sort02;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈快排〉
 *
 * @author sunzhengyu
 * @create 2019/8/20
 * @since 1.0.0
 */
public class QuickSort {

    public static void sort(int[] a, int n) {
        sort(a, 0, n - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(a, start, end);

        sort(a, start, pivot - 1);
        sort(a, pivot + 1, end);

    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start, j = start;
        while (j <= end - 1) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        //交换pivot与i
        a[end] = a[i];
        a[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 9, 2};

        sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}