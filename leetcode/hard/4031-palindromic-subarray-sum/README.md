# Q4. Palindromic Subarray Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums`.

Return the maximum possible sum of a subarray of `nums` that is a palindrome.

 

 **Example 1:** 

 **Input:**  nums = [10,10]

 **Output:**  20

 **Explanation:** 

The whole array `[10,10]` is a palindrome. Therefore, the maximum sum is `10 + 10 = 20`.

 **Example 2:** 

 **Input:**  nums = [1,2,3,2,1,5,6]

 **Output:**  9

 **Explanation:** 

The contiguous subarray `[1,2,3,2,1]` is a palindrome. Its sum is `1 + 2 + 3 + 2 + 1 = 9` and it is the maximum sum.

 **Example 3:** 

 **Input:**  nums = [7,1,2,1,7,3,4,3,4]

 **Output:**  18

 **Explanation:** 

The contiguous subarray `[7,1,2,1,7]` is a palindrome. Its sum is `7 + 1 + 2 + 1 + 7 = 18` and it is the maximum sum.

 **Example 4:** 

 **Input:**  nums = [1,2,3,4,5]

 **Output:**  5

 **Explanation:** 

No subarray with length greater than 1 is a palindrome. The largest element in the array is 5. Therefore, the answer is 5.

 **Example 5:** 

 **Input:**  nums = [1000]

 **Output:**  1000

 **Explanation:** 

The subarray with only one element is a palindrome. Therefore, the answer is 1000.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 10​​​​​​​9

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 61.66%)  
**Memory:** 142.5 MB (beats 44.91%)  
**Submitted:** 2026-07-05T17:34:19.555Z  

```java

class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;

        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        long ans = 0;
        for (int x : nums) ans = Math.max(ans, x);

        // odd palindromes
        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && nums[i - k] == nums[i + k]) {
                k++;
            }
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }

            int left = i - d1[i] + 1;
            int right = i + d1[i] - 1;
            ans = Math.max(ans, pre[right + 1] - pre[left]);
        }

        // even palindromes
        int[] d2 = new int[n];
        l = 0;
        r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k]) {
                k++;
            }
            d2[i] = k;
            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }

            if (d2[i] > 0) {
                int left = i - d2[i];
                int right = i + d2[i] - 1;
                ans = Math.max(ans, pre[right + 1] - pre[left]);
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-subarray-sum/)