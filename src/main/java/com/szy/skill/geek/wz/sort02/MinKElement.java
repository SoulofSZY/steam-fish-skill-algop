package com.szy.skill.geek.wz.sort02;

/**
 * 〈一句话功能简述〉<br>
 * 〈求第K小数据  时间复杂度O（n）〉
 *
 * @author sunzhengyu
 * @create 2019/8/20
 * @since 1.0.0
 */
public class MinKElement {


    public static int findK(int[] a, int k, int n) {
        if (k > n || k < 1) {
            throw new IllegalArgumentException("不合法的参数");
        }
        return findK(a, k, 0, n - 1);
    }

    private static int findK(int[] a, int k, int start, int end) {

        int pivot = QuickSort.partition(a, start, end);
        if (k == (pivot + 1)) {
            return a[pivot];
        }

        if (k < pivot + 1) {
            return findK(a, k, start, pivot - 1);
        } else {
            return findK(a, k, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 5, 6};

        int val = findK(a, 1, a.length);

        System.out.println(val);
    }

}