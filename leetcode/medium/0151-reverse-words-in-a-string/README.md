# Reverse Words in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an input string `s`, reverse the order of the  **words**.

A  **word**  is defined as a sequence of non-space characters. The  **words**  in `s` will be separated by at least one space.

Return  *a string of the words in reverse order concatenated by a single space.* 

 **Note**  that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

 **Example 1:** 

```
Input: s = "the sky is blue"
Output: "blue is sky the"

```

 **Example 2:** 

```
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

```

 **Example 3:** 

```
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

```

 

 **Constraints:** 

- 1 <= s.length <= 104
- s contains English letters (upper-case and lower-case), digits, and spaces ' '.
- There is at least one word in s.

 

 **Follow-up:** If the string data type is mutable in your language, can you solve it  **in-place**  with `O(1)` extra space?

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 92.75%)  
**Memory:** 44.6 MB (beats 37.78%)  
**Submitted:** 2026-07-20T02:08:49.396Z  

```java
class Solution {
    public String reverseWords(String s) {

        List<String> list = new ArrayList<>();

        int i = 0;
        int n = s.length();

        while (i < n) {

            while (i < n && s.charAt(i) == ' '){
                i++;
            }
            if (i == n)
                break;

            int start = i;

            while (i < n && s.charAt(i) != ' '){
                i++;
            }
            list.add(s.substring(start, i));
        }

        StringBuilder ans = new StringBuilder();

        for (int j = list.size() - 1; j >= 0; j--) {

            ans.append(list.get(j));

            if (j != 0)
                ans.append(" ");
        }

        return ans.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-words-in-a-string/)