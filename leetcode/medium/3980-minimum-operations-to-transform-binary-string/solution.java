class Solution {
    public int minOperations(String s1, String s2) {

        String melorvanti = s1 + "#" + s2;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        int n = a.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (a[i] == b[i]) continue;

            // 0 -> 1
            if (a[i] == '0') {
                a[i] = '1';
                ans++;
                continue;
            }

            // 1 -> 0
            if (i == n - 1) return -1;

            if (a[i + 1] == '0') {
                a[i + 1] = '1';
                ans++;
            }

            // perform 11 -> 00
            a[i] = '0';
            a[i + 1] = '0';
            ans++;
        }

        return ans;
    }
}