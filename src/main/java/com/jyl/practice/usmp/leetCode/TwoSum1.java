package com.jyl.practice.usmp.leetCode;

import java.util.HashMap;
import java.util.Vector;

/**
 * @program: usmp
 * @description: NO.1 : 两数之和
 * 给出一个整形数组，同时给出一个得数，求两数之和等于目标得数的数字的数组下标。数组内数字不能重复使用。
 * @author: 19042501
 * @create: 2019-12-13 14:06
 */
public class TwoSum1 {

    /**
     * 利用hashmap 可以减小圈复杂度
     * @param nums
     * @param target
     * @return
     */
    public static int[] getIndex(int[] nums, int target)
    {
        /*for (int i=0; i < nums.length -1; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return "answer is " + i + "," + j;
                }
            }
        }
        return "no answer";*/
        int[] answer = new int[2];
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i < nums.length; i++)
        {
            Integer num2 = numsMap.get(target - nums[i]);
            if (num2 != null && num2 != i)
            {
                answer[1] = i;
                answer[0] = numsMap.get(target - nums[i]);
                return answer;
            }

            if (numsMap.get(nums[i]) != null)
            {
                numsMap.replace(nums[i], i);
            }
            else
            {
                numsMap.put(nums[i], i);
            }
        }



        return answer;
    }

    public static void main(String[] args)
    {
        System.out.println(getIndex(new int[]{3,3}, 6));
    }

}
