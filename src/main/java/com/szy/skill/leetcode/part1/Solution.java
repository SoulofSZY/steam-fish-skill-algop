/**
 * Copyright (C), 2014-2019, 深圳兔展智能科技有限公司
 * FileName: Solution
 * Author:   EDZ
 * Date:     2019/6/10 21:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szy.skill.leetcode.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈〉
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author EDZ
 * @create 2019/6/10
 * @since 1.0.0
 */
public class Solution {

    /**
     * 思路： 理解错误 1.题设只有一对满足的结果  2.返回结果的数组索引  重排序会导致索引改变
     * 1.排序
     * 2.从中间开始求和 找到第一个两相邻节点和大于等于target的节点 然后将该节点之后的节点与中间节点前的节点遍历相加
     * 3.汇总所有符合条件的结果
     *
     * @param nums
     * @param target
     * @return
     */
    public static Integer[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length < 2) {
            return null;
        }
        // 这里可以自己手撕一个排序算法
        Arrays.sort(nums);

        int low = nums.length / 2;
        // 从中间节点开始找第一个 >= target节点的位置
        if ((nums[low] + nums[low + 1]) > target) {
            low--;
            while ((nums[low] + nums[low + 1]) > target) {
                if (low == 0) {
                    return null;
                }
                low--;
            }
        } else if ((nums[low] + nums[low + 1]) < target) {
            low++;
            while ((nums[low] + nums[low + 1]) < target) {
                low++;
                if (low == nums.length) {
                    return null;
                }
            }
        }
        if ((nums[low] + nums[low + 1]) == target) {
            low++;
        }

        Integer[] result = new Integer[nums.length * 2];
        int idx = 0;
        for (int i = 0; i < low; i++) {
            for (int j = low; j < nums.length; j++) {
                if (nums[i] + nums[j] > target) {
                    break;
                }

                if (nums[i] + nums[j] == target) {
                    result[idx] = i;
                    result[++idx] = j;
                }
            }
        }
        return result;
    }


    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 4);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] result = twoSum2(new int[]{2, 7, 11, 15}, 9);
       System.out.println(Arrays.toString(result));
    }

}