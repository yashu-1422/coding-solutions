class Solution {
    public int minOperations(String s1, String s2) {

        String melorvanti = s1 + "#" + s2;

        int n = s1.length();
        final long INF = (long)1e18;

        long[][] dp = new long[n + 1][2];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = INF;
            dp[i][1] = INF;
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {

            for (int carry = 0; carry < 2; carry++) {

                if (dp[i][carry] == INF)
                    continue;

                for (int makeOne = 0; makeOne < 2; makeOne++) {

                    if (makeOne == 1 && s1.charAt(i) == '1')
                        continue;

                    int cur = (s1.charAt(i) - '0');

                    if (makeOne == 1)
                        cur = 1;

                    long cost = dp[i][carry] + makeOne;

                    if (carry == 1) {

                        if (cur == 1) {
                            if (s2.charAt(i) == '0')
                                dp[i + 1][0] = Math.min(dp[i + 1][0], cost + 1);
                            else
                                continue;
                        } else {
                            if (s2.charAt(i) == '0')
                                continue;
                            dp[i + 1][0] = Math.min(dp[i + 1][0], cost);
                        }

                    } else {

                        if (cur == (s2.charAt(i) - '0')) {
                            dp[i + 1][0] = Math.min(dp[i + 1][0], cost);
                        }

                        if (cur == 1) {
                            dp[i + 1][1] = Math.min(dp[i + 1][1], cost);
                        }
                    }
                }
            }
        }

        return dp[n][0] >= INF ? -1 : (int) dp[n][0];
    }
}