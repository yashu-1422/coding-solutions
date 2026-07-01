# Number of Substrings Containing All Three Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` consisting only of characters  *a*,  *b*  and  *c*.

Return the number of substrings containing  **at least**  one occurrence of all these characters  *a*,  *b*  and  *c*.

 

 **Example 1:** 

```
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

```

 **Example 2:** 

```
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

```

 **Example 3:** 

```
Input: s = "abc"
Output: 1

```

 

 **Constraints:** 

- 3 <= s.length <= 5 x 10^4
- s only consists of a, b or c characters.

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 91.55%)  
**Memory:** 46.3 MB (beats 62.31%)  
**Submitted:** 2026-07-01T18:29:30.301Z  

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] p = {-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            p[(s.charAt(i) & 31) - 1] = i;
            res += Math.min(p[0], Math.min(p[1], p[2])) + 1;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)