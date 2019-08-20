package com.szy.skill.geek.wz.sort02;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈归并排序〉
 *
 * @author sunzhengyu
 * @create 2019/8/20
 * @since 1.0.0
 */
public class MergeSort {

    public static void sort(int[] a, int n) {
        sort(a, 0, n - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (end + start) / 2;

        sort(a, start, mid);
        sort(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, idx = 0;

        while (i <= mid && j <= end) {
            // 保证 稳定性
            if (a[i] <= a[j]) {
                temp[idx++] = a[i++];
            } else {
                temp[idx++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[idx++] = a[i++];
        }

        while (j <= end) {
            temp[idx++] = a[j++];
        }

        for (int k = 0; k < idx; k++) {
            a[start + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 6};

        sort(a, a.length);

        System.out.println(Arrays.toString(a));
    }
}