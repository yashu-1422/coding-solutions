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