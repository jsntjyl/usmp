package com.jyl.practice.usmp.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: usmp
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @author: 19042501
 * @create: 2019-12-17 14:37
 */
public class LenOfLongestSubStr3 {

    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        // 当前字串起启下标
        int nowStart = 0;
        // 字符下标集
        int[] indexMap = new int[128];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            int hitIndex = indexMap[chars[i]];
            if (hitIndex > nowStart)
            {
                nowStart = hitIndex;
            }

            int len = i - nowStart + 1;
            if (len > maxLen)
            {
                maxLen = len;
            }

            indexMap[chars[i]] = i+1;
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


    /*public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        StringBuilder nowStr = new StringBuilder();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++)
        {
            int index = nowStr.toString().indexOf(chars[i]);

            if (index != -1)
            {
                if (nowStr.length() > maxLen)
                {
                    maxLen = nowStr.length();
                }

                nowStr = new StringBuilder(nowStr.substring(index + 1));
            }

            nowStr.append(chars[i]);
        }

        return nowStr.length() > maxLen ? nowStr.length() : maxLen;
    }*/
}
