package com.szy.skill.geek.wz.heap;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.*;

/**
 * 〈堆实现〉
 *
 * @author sunzhengyu
 * @create 2019/9/20
 * @since 1.0.0
 */
public class HeapExp {

    /**
     * 数组 用于存储数据
     **/
    private int[] a;
    /**
     * 二叉堆大小
     **/
    private int n;
    /**
     * 二叉堆数据个数
     **/
    private int count;


    public HeapExp(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int element) {
        if (count >= n) {
            return;
        }
        count++;
        a[count] = element;
        int i = count;
        while (i >>> 1 > 0 && a[i >>> 1] < a[i]) {
            swap(a, i >>> 1, i);
            i = i >>> 1;
        }
    }

    public int removeMax() {
        if (count == 0) {
            throw new RuntimeException("empty heap");
        }
        swap(a, 1, count);
        count--;
        sink(a, count, 1);
        return a[count + 1];
    }

    private void sink(int[] a, int count, int idx) {
        while (true) {
            int maxIdx = idx;

            int subIdxLeft = idx << 1;
            if ((subIdxLeft <= count) && (a[subIdxLeft] > a[maxIdx])) {
                maxIdx = subIdxLeft;
            }
            int subIdxRight = (idx << 1) + 1;
            if ((subIdxRight <= count) && (a[subIdxRight] > a[maxIdx])) {
                maxIdx = subIdxRight;
            }
            if (maxIdx == idx) {
                break;
            }
            swap(a, idx, maxIdx);
            idx = maxIdx;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        HeapExp heapExp = new HeapExp(6);
        heapExp.insert(2);
        heapExp.insert(4);
        heapExp.insert(10);
        heapExp.insert(8);
        heapExp.insert(6);
        heapExp.insert(9);
        heapExp.insert(11);
        System.out.println("----------------------");
        heapExp.removeMax();
        heapExp.removeMax();
        heapExp.removeMax();
    }

}