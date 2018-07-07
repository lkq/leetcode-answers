package com.github.lkq;



/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int idx1 = 0;
            int idx2 = 0;
            int len1 = nums1.length;
            int len2 = nums2.length;
            int totalLen = len1 + len2;
            int midLen = totalLen / 2 + 1;

            int min = Integer.MIN_VALUE;
            int prevMin = min;

            int num1, num2;
            while (idx1 + idx2 < midLen) {

                num1 = idx1 < len1 ? nums1[idx1] : Integer.MAX_VALUE;
                num2 = idx2 < len2 ? nums2[idx2] : Integer.MAX_VALUE;
                if (idx1 < len1 && num1 < num2) {
                    prevMin = min;
                    min = nums1[idx1++];
                } else if (idx2 < len2){
                    prevMin = min;
                    min = nums2[idx2++];
                }
            }

            if (totalLen % 2 == 1 || prevMin == Integer.MIN_VALUE) {
                return min;
            } else {
                return (prevMin + min) / 2.0;
            }
        }
    }
}
