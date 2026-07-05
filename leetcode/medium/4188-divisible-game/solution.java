import java.util.*;

class Solution {
    public int divisibleGame(int[] nums) {
        final long MOD = 1_000_000_007L;

        HashSet<Integer> candidates = new HashSet<>();
        candidates.add(2);

        for (int x : nums) {
            for (int d = 2; (long) d * d <= x; d++) {
                if (x % d == 0) {
                    candidates.add(d);
                    candidates.add(x / d);
                }
            }
            if (x > 1) candidates.add(x);
        }

        long bestDiff = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : candidates) {
            long cur = Long.MIN_VALUE;
            long best = Long.MIN_VALUE;

            for (int x : nums) {
                long val = (x % k == 0) ? x : -x;

                if (cur < 0) cur = val;
                else cur += val;

                best = Math.max(best, cur);
            }

            if (best > bestDiff || (best == bestDiff && k < bestK)) {
                bestDiff = best;
                bestK = k;
            }
        }

        long ans = ((bestDiff % MOD + MOD) % MOD);
        ans = (ans * bestK) % MOD;

        return (int) ans;
    }
}