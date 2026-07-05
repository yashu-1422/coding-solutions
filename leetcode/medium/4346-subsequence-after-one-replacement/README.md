# Q2. Subsequence After One Replacement

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `s` and `t` consisting of lowercase English letters.

You may choose  **at most**  one index in `s` and replace the character at that index with any lowercase English letter.

Return `true` if it is possible to make `s` a subsequence of `t`; otherwise, return `false`.

 

 **Example 1:** 

 **Input:**  s = "cat", t = "chat"

 **Output:**  true

 **Explanation:** 

- Replace s[1] from 'a' to 'h'. The resulting string is "cht".
- "cht" is a subsequence of "chat" because we can match 'c', 'h', and 't' in order.

 **Example 2:** 

 **Input:**  s = "plane", t = "apple"

 **Output:**  false

 **Explanation:** 

- The characters 'p', 'l', and 'e' can be matched in t, but the remaining characters cannot be matched while preserving the required order.
- Even after replacing any one character in s, it is impossible to make s a subsequence of t.

 

 **Constraints:** 

- 1 <= s.length, t.length <= 105
- s and t consist only of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 43.28%)  
**Memory:** 48.4 MB (beats 20.71%)  
**Submitted:** 2026-07-05T17:29:13.369Z  

```java
class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[] pre = new int[n + 1];
        int j = 0;
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            while (j < m && t.charAt(j) != s.charAt(i)) j++;
            if (j == m) {
                for (int k = i + 1; k <= n; k++) pre[k] = m;
                break;
            }
            pre[i + 1] = j;
            j++;
        }

        int[] suf = new int[n + 1];
        j = m - 1;
        suf[n] = m;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && t.charAt(j) != s.charAt(i)) j--;
            if (j < 0) {
                for (int k = i; k >= 0; k--) suf[k] = -1;
                break;
            }
            suf[i] = j;
            j--;
        }

        if (pre[n] != m) return true;

        for (int i = 0; i < n; i++) {
            int left = pre[i];
            int right = suf[i + 1];

            if (left == m || right == -1) continue;

            if (right - left >= 2) return true;
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subsequence-after-one-replacement/)