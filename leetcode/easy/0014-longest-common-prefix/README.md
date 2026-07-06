# Longest Common Prefix

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

 

 **Example 1:** 

```
Input: strs = ["flower","flow","flight"]
Output: "fl"

```

 **Example 2:** 

```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

```

 

 **Constraints:** 

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lowercase English letters if it is non-empty.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 62.61%)  
**Memory:** 43.3 MB (beats 32.77%)  
**Submitted:** 2026-07-06T16:27:55.139Z  

```java
class Solution {
    public String longestCommonPrefix(String[] v) {

        if (v == null || v.length == 0)
            return "";

        Arrays.sort(v);

        String first = v[0];
        String last = v[v.length - 1];

        StringBuilder ans = new StringBuilder();

        int len = Math.min(first.length(), last.length());

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != last.charAt(i))
                break;

            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-common-prefix/)