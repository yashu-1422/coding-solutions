# Median of Two Sorted Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return  **the median**  of the two sorted arrays.

The overall run time complexity should be `O(log (m+n))`.

 

 **Example 1:** 

```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

```

 **Example 2:** 

```
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

```

 

 **Constraints:** 

- nums1.length == m
- nums2.length == n
- 0 <= m <= 1000
- 0 <= n <= 1000
- 1 <= m + n <= 2000
- -106 <= nums1[i], nums2[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 48.7 MB (beats 71.28%)  
**Submitted:** 2026-07-02T16:05:26.180Z  

```java
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition positions
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            // Values just left and right of cut1
            int left1;
            int right1;

            if (cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }

            if (cut1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }

            // Values just left and right of cut2
            int left2;
            int right2;

            if (cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }

            if (cut2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }

            // Check if the partition is correct.
            if (left1 <= right2 && left2 <= right1) {

                // Odd total elements
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total elements
                int maxLeft = Math.max(left1, left2);
                int minRight = Math.min(right1, right2);

                return (maxLeft + minRight) / 2.0;
            }

            // Too many elements taken from nums1
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // Too few elements taken from nums1
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays/)