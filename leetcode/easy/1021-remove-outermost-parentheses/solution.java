class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                level++;
                if (level > 1) {
                    ans.append(ch);
                }
            } else {
                level--;
                if (level > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}