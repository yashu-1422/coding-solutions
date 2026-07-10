class Solution {
    public int maxDepth(String s) {
        int p = 0; 
        int ans = 0; 
        for (char ch : s.toCharArray()) {
            // Increase depth on open parenthesis
            if (ch == '(') p++;
            // Decrease depth on close parenthesis
            else if (ch == ')') p--;
            // Update maximum depth encountered
            ans = Math.max(ans, p);
        }
        return ans; 
    }
    }
