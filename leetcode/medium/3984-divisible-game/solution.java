class Solution {
    public int divisibleGame(int[] nums) {
        final long MOD = 1_000_000_007L;

        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        long bestDiff = Long.MIN_VALUE;
        int bestK = 2;

        for (int k = 2; k <= maxVal; k++) {
            long cur = Long.MIN_VALUE;
            long best = Long.MIN_VALUE;

            for (int x : nums) {
                long val = (x % k == 0) ? x : -x;

                if (cur < 0) cur = val;
                else cur += val;

                if (cur > best) best = cur;
            }

            if (best > bestDiff || (best == bestDiff && k < bestK)) {
                bestDiff = best;
                bestK = k;
            }
        }

        long ans = (bestDiff % MOD) * bestK % MOD;
        ans = (ans + MOD) % MOD;

        return (int) ans;
    }
}