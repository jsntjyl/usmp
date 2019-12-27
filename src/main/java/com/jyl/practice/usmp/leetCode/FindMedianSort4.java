package com.jyl.practice.usmp.leetCode;


/**
 * @program: usmp
 * @description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @author: 19042501
 * @create: 2019-12-17 19:35
 */
public class FindMedianSort4 {

    /**
     * 中位数：前、后的数据长度是一样的。
     * 总长度是奇数，则中位数就是中间数，总长度是偶数，则中位数是中间两个数之后
     * 数的下标：totalLen/2 + (totalLen -1)/2
     *
     * 由于取的是中位数，故该数不可能出现后置位 > mid+1 个数的情况
     * 入参是两个数组，则每次取数组下标 mid/2 进行比较,确定mid/2 个数是否存在中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int value1_index = (totalLen +1)/2;
        int value2_index = (totalLen +2)/2;

        return (getNum(nums1, nums2, 0, 0, value1_index) + getNum(nums1, nums2, 0, 0, value2_index)) /2.0;
    }

    // 只考虑都是从小到大排序的
    public static int getNum(int[] nums1, int[] nums2, int begin1, int begin2, int index)
    {
        int mid_index1 = index / 2;
        int mid_index2 = mid_index1;
        // 1、如果其中一个数组为空，则直接返回另一数组中对应下标的数
        if (nums1.length - begin1 <= 0)
        {
            return nums2[begin2 + index - 1];
        }

        if (nums2.length - begin2 <= 0)
        {
            return nums1[begin1 + index - 1];
        }

        // 2、如果数组长度不足，取数组最后一个数进行比较
        if (index <= 1)
        {
            return Math.min(nums1[begin1], nums2[begin2]);
        }

        // 如果数组中位数不够，则以当前剩余位数为准
        int compare_value1;
        if (nums1.length - begin1 + 1 <= mid_index1)
        {
            mid_index1 = nums1.length - begin1;
            compare_value1 = nums1[nums1.length - begin1 -1];
        }
        else
        {
            compare_value1 = nums1[begin1 + mid_index1 - 1];
        }

        int compare_value2;
        if (nums2.length - begin2 + 1 <= mid_index2)
        {
            mid_index2 = nums2.length - begin2;
            compare_value2 = nums2[nums2.length - begin2 -1];
        }
        else
        {
            compare_value2 = nums2[begin2 + mid_index2 - 1];
        }

        if (compare_value1 <= compare_value2)
        {
            // nums1位置后移
            begin1 = begin1 + mid_index1;
            return getNum(nums1, nums2, begin1, begin2,index - mid_index1);
        }
        else
        {
            // nums2位置后移
            begin2 = begin2 + mid_index2;
            return getNum(nums1, nums2, begin1, begin2, index - mid_index2);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6}));
    }
}
