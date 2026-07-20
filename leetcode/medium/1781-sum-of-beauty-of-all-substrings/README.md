# Sum of Beauty of All Substrings

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The  **beauty**  of a string is the difference in frequencies between the most frequent and least frequent characters.

- For example, the beauty of "abaacc" is 3 - 1 = 2.

Given a string `s`, return  *the sum of  **beauty**  of all of its substrings.* 

 

 **Example 1:** 

```
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
```

 **Example 2:** 

```
Input: s = "aabcbaa"
Output: 17

```

 

 **Constraints:** 

- 1 <= s.length <= 500
- s consists of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 59 ms (beats 91.88%)  
**Memory:** 44 MB (beats 72.43%)  
**Submitted:** 2026-07-20T02:05:32.214Z  

```java
class Solution {

    public int beautySum(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                ans += (max - min);
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-beauty-of-all-substrings/)