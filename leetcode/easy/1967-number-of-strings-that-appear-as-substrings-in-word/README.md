# Number of Strings That Appear as Substrings in Word

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of strings `patterns` and a string `word`, return  *the  **number**  of strings in* `patterns` *that exist as a  **substring**  in* `word`.

A  **substring**  is a contiguous sequence of characters within a string.

 

 **Example 1:** 

```
Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
- "a" appears as a substring in "abc".
- "abc" appears as a substring in "abc".
- "bc" appears as a substring in "abc".
- "d" does not appear as a substring in "abc".
3 of the strings in patterns appear as a substring in word.

```

 **Example 2:** 

```
Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2
Explanation:
- "a" appears as a substring in "aaaaabbbbb".
- "b" appears as a substring in "aaaaabbbbb".
- "c" does not appear as a substring in "aaaaabbbbb".
2 of the strings in patterns appear as a substring in word.

```

 **Example 3:** 

```
Input: patterns = ["a","a","a"], word = "ab"
Output: 3
Explanation: Each of the patterns appears as a substring in word "ab".

```

 

 **Constraints:** 

- 1 <= patterns.length <= 100
- 1 <= patterns[i].length <= 100
- 1 <= word.length <= 100
- patterns[i] and word consist of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 6.67%)  
**Memory:** 47 MB (beats 5.61%)  
**Submitted:** 2026-07-01T18:28:44.229Z  

```java
class Solution {
    class Node {
        Node[] c = new Node[26];
        Node f;
        Node l;
        int n = 0;
    }

    public int numOfStrings(String[] patterns, String word) {
        Node root = new Node();
        
        for (int i = 0; i < patterns.length; i++) {
            Node curr = root;
            String p = patterns[i];
            
            for (int j = 0; j < p.length(); j++) {
                int x = p.charAt(j) - 97;
                
                if (curr.c[x] == null)
                    curr.c[x] = new Node();
                    
                curr = curr.c[x];
            }
            
            curr.n++;
        }
        
        Node[] q = new Node[10005];
        int hd = 0;
        int tl = 0;
        
        for (int i = 0; i < 26; i++) {
            if (root.c[i] == null) {
                root.c[i] = root;
                continue;
            }
            
            root.c[i].f = root;
            root.c[i].l = null;
            q[tl] = root.c[i];
            tl++;
        }
        
        while (hd < tl) {
            Node curr = q[hd];
            hd++;
            
            for (int i = 0; i < 26; i++) {
                if (curr.c[i] == null) {
                    curr.c[i] = curr.f.c[i];
                    continue;
                }
                
                curr.c[i].f = curr.f.c[i];
                
                if (curr.c[i].f.n == 0)
                    curr.c[i].l = curr.c[i].f.l;
                else
                    curr.c[i].l = curr.c[i].f;
                    
                q[tl] = curr.c[i];
                tl++;
            }
        }
        
        Node curr = root;
        int res = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 97;
            curr = curr.c[x];
            
            Node m = curr;
            
            while (m != null) {
                res += m.n;
                m.n = 0;
                
                Node tmp = m.l;
                m.l = null;
                m = tmp;
            }
        }
        
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/)