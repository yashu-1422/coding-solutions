# Remove Outermost Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.

- For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.

Given a valid parentheses string `s`, consider its primitive decomposition: `s = P1 + P2 +... + Pk`, where `Pi` are primitive valid parentheses strings.

Return `s`  *after removing the outermost parentheses of every primitive string in the primitive decomposition of* `s`.

 

 **Example 1:** 

```
Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

```

 **Example 2:** 

```
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

```

 **Example 3:** 

```
Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is either '(' or ')'.
- s is a valid parentheses string.

## Solution

**Language:** Java  
**Runtime:** 1 ms  
**Memory:** 42.7 MB  
**Submitted:** 2026-07-03T15:39:25.910Z  

```java
class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int count = 0;

        for (char ch : s.toCharArray()) {
            if(ch == '(' ){
                count++;
                if(count>1){
                    ans+='(';
                }
            }
            else{
                count--;
                if(count>0){
                    ans+=')';
                }
            }
        }
        return ans ;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-outermost-parentheses/)