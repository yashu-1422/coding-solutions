# Q3. Divisible Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` of length `n`.

Alice and Bob are playing a game. Alice chooses:

- An integer k such that k > 1.
- Two integers l and r such that 0 <= l <= r < n.

Initially, both Alice's and Bob's scores are 0.

For each index `i` in the range `[l, r]` (inclusive):

- If nums[i] is divisible by k, Alice's score increases by nums[i].
- Otherwise, Bob's score increases by nums[i].

The  **score difference**  is Alice's score  **minus**  Bob's score.

Alice wants to  **maximize**  the score difference. If there are multiple values of `k` that achieve the  **maximum**  score difference, she chooses the  **smallest**  such `k`.

Return the  **product**  of the  **maximum**  score difference and the chosen value of `k`. Since the result can be large, return it  **modulo**  `109 + 7`.

 

 **Example 1:** 

 **Input:**  nums = [1,4,6,8]

 **Output:**  36

 **Explanation:** 

- Alice can choose k = 2, l = 1, and r = 3.
- All values in nums[1..3] are divisible by 2, so Alice's score is 4 + 6 + 8 = 18, while Bob's score is 0.
- The score difference is 18, which is the maximum possible. Among all values of k that achieve this score difference, the smallest is 2.
- Therefore, the answer is 18 * 2 = 36.

 **Example 2:** 

 **Input:**  nums = [2,1,2]

 **Output:**  6

 **Explanation:** 

- Alice can choose k = 2, l = 0, and r = 2.
- The values nums[0] and nums[2] are divisible by 2, so Alice's score is 2 + 2 = 4. The value nums[1] is not divisible by 2, so Bob's score is 1.
- The score difference is 4 - 1 = 3, which is the maximum possible. Among all values of k that achieve this score difference, the smallest is 2.
- Therefore, the answer is 3 * 2 = 6.

 **Example 3:** 

 **Input:**  nums = [1]

 **Output:**  1000000005

 **Explanation:** 

- Alice must choose some k > 1. The smallest possible choice is k = 2.
- Since nums[0] is not divisible by 2, Alice's score is 0, while Bob's score is 1.
- The score difference is -1, which is the maximum possible.
- Therefore, the answer is -1 * 2 = -2. Modulo 109 + 7, this equals 1000000005.

 

 **Constraints:** 

- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 133 ms (beats 63.52%)  
**Memory:** 47.1 MB (beats 62.31%)  
**Submitted:** 2026-07-05T17:32:22.658Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/divisible-game/)