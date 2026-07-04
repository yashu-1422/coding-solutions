# Q1. Unique Middle Element

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `nums` of odd length `n`.

Return `true` if the middle element of `nums` appears  **exactly**  once in the array. Otherwise return `false`.

 

 **Example 1:** 

 **Input:**  nums = [1,2,3]

 **Output:**  true

 **Explanation:** 

The middle element of `nums` is 2, which appears exactly once.

Thus, the answer is `true`.

 **Example 2:** 

 **Input:**  nums = [1,2,2]

 **Output:**  false

 **Explanation:** 

The middle element of `nums` is 2, which appears twice.

Thus, the answer is `false`.

 

 **Constraints:** 

- 1 <= n == nums.length <= 100
- n is odd.
- 1 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 94.58%)  
**Memory:** 46.2 MB (beats 98.63%)  
**Submitted:** 2026-07-04T18:07:49.453Z  

```java
class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums[nums.length/2];
        int count =0;
        for(int x:nums){
            if(x==mid){
                count++;
            }
        }
        return count ==1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/unique-middle-element/)