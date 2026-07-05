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