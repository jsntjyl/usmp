package com.jyl.practice.usmp.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: usmp
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author: 19042501
 * @create: 2019-12-25 16:18
 */
public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        String maxLenStr = "";

        StringBuilder str = new StringBuilder();

        List<Integer> strIndexs = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            int lastIndex = -1;

            // 还未结束回文规则的子串继续匹配
            for (int j = strIndexs.size() -1; j >= 0; j--)
            {
                int fromIndex = strIndexs.get(j);

                lastIndex = str.lastIndexOf(String.valueOf(chars[i]), fromIndex -1);
                if (lastIndex != -1 && i - lastIndex == i - fromIndex + 1)
                {
                    strIndexs.set(j, lastIndex);
                }
                else
                {
                    // 回文规则已结束，计算长度
                    if (i - fromIndex + 1 > maxLenStr.length() )
                    {
                        maxLenStr = s.substring(fromIndex, i);
                    }
                    strIndexs.remove(j);
                }

            }

            // 校验是否有新的回文子串产生: 回文是偶数情况
            lastIndex = str.lastIndexOf(String.valueOf(chars[i]));
            if (lastIndex != -1 && i - lastIndex <= 2)
            {
                strIndexs.add(lastIndex);
            }

            strIndexs.add(i);
            str.append(chars[i]);

        }

        // 如果列表中还有未结束的回文计算，则统计一下长度
        for (Integer fromIndex : strIndexs)
        {
            if (chars.length - fromIndex > maxLenStr.length() )
            {
                maxLenStr = s.substring(fromIndex, chars.length);
            }
        }

        return maxLenStr;
    }
    
    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("ccc"));
    }

    //每迭代一个字符，假定该字符为中间数 或 该字符与后一位字符为中间数， 结果取最大长度
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
