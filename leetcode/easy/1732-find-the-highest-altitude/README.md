# Find the Highest Altitude

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

There is a biker going on a road trip. The road trip consists of `n + 1` points at various altitudes. The biker starts his trip on point `0` with altitude equal `0`.

You are given an integer array `gain` of length `n` where `gain[i]` is the  **net gain in altitude**  between points `i`​​​​​​ and `i + 1` for all (`0 <= i < n)`. Return  *the  **highest altitude**  of a point.* 

 

 **Example 1:** 

```
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

```

 **Example 2:** 

```
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.

```

 

 **Constraints:** 

- n == gain.length
- 1 <= n <= 100
- -100 <= gain[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.5 MB  
**Submitted:** 2026-06-30T18:06:14.205Z  

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int highest=0;int current = 0;
        for(int i =0;i<gain.length;i++){
           current +=gain[i];
            Math.max(current,highest);
        }
        return gain[highest];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-highest-altitude/)