# Longest Palindromic Substring

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, return  *the longest*   *palindromic*   *substring*  in `s`.

 

 **Example 1:** 

```
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

```

 **Example 2:** 

```
Input: s = "cbbd"
Output: "bb"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consist of only digits and English letters.

## Solution

**Language:** Java  
**Runtime:** 14 ms (beats 90.19%)  
**Memory:** 43.4 MB (beats 89.58%)  
**Submitted:** 2026-07-20T02:01:59.341Z  

```java
class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2)
            return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);       // odd
            int len2 = expand(s, i, i + 1);   // even

            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)