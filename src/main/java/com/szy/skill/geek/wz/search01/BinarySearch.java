package com.szy.skill.geek.wz.search01;

/**
 * 〈一句话功能简述〉<br>
 * 〈二分查找〉
 *
 * @author sunzhengyu
 * @create 2019/8/27
 * @since 1.0.0
 */
public class BinarySearch {


    /**
     * 简单二分查找 基于循环  有序数组中不存在重复元素
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int bSearch(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int bSearchRecursion(int[] a, int n, int key) {
        return bSearchRecursion(a, 0, n - 1, key);
    }

    private static int bSearchRecursion(int[] a, int low, int high, int key) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return bSearchRecursion(a, low, mid - 1, key);
        } else {
            return bSearchRecursion(a, mid + 1, high, key);
        }
    }

    /**
     * 有相同元素有序序列 返回第一个
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int bSearchFirst(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= key) {
                // 当a[mid]>=key 则high=mid-1    -->最终 a[high] < a[mid] 或者 high = -1
                high = mid - 1;
            } else {
                // 当a[mid] < key 则 low = mid+1 -->最终 a[low] == a[mid] 或者 low=n
                low = mid + 1;
            }
        }

        if (low < n && a[low] == key) {
            return low;
        } else {
            return -1;
        }
    }

    public static int bSearchFirst2(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != key)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 有相同元素有序序列 返回最后一个
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int bSearchLast(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid + 1] != key)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 第一个大于等于给定值
     *
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int bSearchFirstBigger(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= key) {
                if ((mid == 0) || (a[mid - 1] < key)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int bSearchLastLower(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > key) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > key)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        //int[] a = {1, 2, 3, 4, 5, 6, 7};

        //System.out.println(bSearch(a, 7, 3) + "");
        //System.out.println(bSearchRecursion(a, 7, 3) + "");


        int[] b = {1, 2, 3, 3, 4, 5, 6, 7};
        //System.out.println(bSearchFirst(b, b.length, 3));
        //System.out.println(bSearchFirst2(b, b.length, 3));

        //System.out.println(bSearchLast(b, b.length, 3));

        //System.out.println(bSearchFirstBigger(b, b.length, 3));

        System.out.println(bSearchLastLower(b, b.length, 3));

    }
}