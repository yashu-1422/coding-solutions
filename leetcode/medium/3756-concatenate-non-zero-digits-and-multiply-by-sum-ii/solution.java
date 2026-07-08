

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100001;
    private static final long[] pow10 = new long[MAX];

    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] prefixSum = new int[n + 1];
        int[] prefixCount = new int[n + 1];
        long[] prefixNum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int digit = s.charAt(i - 1) - '0';

            prefixSum[i] = prefixSum[i - 1] + digit;
            prefixCount[i] = prefixCount[i - 1] + (digit == 0 ? 0 : 1);

            if (digit == 0) {
                prefixNum[i] = prefixNum[i - 1];
            } else {
                prefixNum[i] = (prefixNum[i - 1] * 10 + digit) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int nonZero = prefixCount[r + 1] - prefixCount[l];
            int digitSum = prefixSum[r + 1] - prefixSum[l];

            long number = (prefixNum[r + 1]
                    - prefixNum[l] * pow10[nonZero] % MOD
                    + MOD) % MOD;

            ans[i] = (int) (number * digitSum % MOD);
        }

        return ans;
    }
}