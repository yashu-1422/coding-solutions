# Base 7

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `num`, return  *a string of its  **base 7**  representation*.

 

 **Example 1:** 

```
Input: num = 100
Output: "202"

```

 **Example 2:** 

```
Input: num = -7
Output: "-10"

```

 

 **Constraints:** 

- -107 <= num <= 107

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.3 MB  
**Submitted:** 2026-06-29T18:03:42.172Z  

```java
class Solution {
    public String convertToBase7(int num) {

        if (num == 0)
            return "0";

        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (negative)
            sb.append('-');

        return sb.reverse().toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/base-7/)