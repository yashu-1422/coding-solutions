# Number of Paths with Max Score

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a square `board` of characters. You can move on the board starting at the bottom right square marked with the character `'S'`.

You need to reach the top left square marked with the character `'E'`. The rest of the squares are labeled either with a numeric character `1, 2,..., 9` or with an obstacle `'X'`. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths that you can take to get that maximum sum,  **taken modulo `10^9 + 7`**.

In case there is no path, return `[0, 0]`.

 

 **Example 1:** 

```
Input: board = ["E23","2X2","12S"]
Output: [7,1]

```

 **Example 2:** 

```
Input: board = ["E12","1X1","21S"]
Output: [4,2]

```

 **Example 3:** 

```
Input: board = ["E11","XXX","11S"]
Output: [0,0]

```

 

 **Constraints:** 

- 2 <= board.length == board[i].length <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 43.2 MB  
**Submitted:** 2026-07-05T17:20:48.646Z  

```java
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char ch = board.get(i).charAt(j);

                if (ch == 'X' || (i == n - 1 && j == n - 1)) {
                    continue;
                }

                int best = -1;
                int count = 0;

                int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= n || nj >= n || score[ni][nj] == -1) {
                        continue;
                    }

                    if (score[ni][nj] > best) {
                        best = score[ni][nj];
                        count = ways[ni][nj];
                    } else if (score[ni][nj] == best) {
                        count = (count + ways[ni][nj]) % MOD;
                    }
                }

                if (best == -1) {
                    continue;
                }

                int val = (ch == 'E') ? 0 : ch - '0';
                score[i][j] = best + val;
                ways[i][j] = count;
            }
        }

        if (ways[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{score[0][0], ways[0][0]};
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-paths-with-max-score/)