# Find a Peak Element II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A  **peak**  element in a 2D grid is an element that is  **strictly greater**  than all of its  **adjacent** neighbors to the left, right, top, and bottom.

Given a  **0-indexed**  `m x n` matrix `mat` where  **no two adjacent cells are equal**, find  **any**  peak element `mat[i][j]` and return  *the length 2 array* `[i,j]`.

You may assume that the entire matrix is surrounded by an  **outer perimeter**  with the value `-1` in each cell.

You must write an algorithm that runs in `O(m log(n))` or `O(n log(m))` time.

 

 **Example 1:** 

```
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

```

 **Example 2:** 

```
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.

```

 

 **Constraints:** 

- m == mat.length
- n == mat[i].length
- 1 <= m, n <= 500
- 1 <= mat[i][j] <= 105
- No two adjacent cells are equal.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 119.1 MB (beats 30.31%)  
**Submitted:** 2026-07-02T20:13:53.090Z  

```java
class Solution {

    private int maxRow(int[][] mat, int col) {

        int row = 0;

        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[row][col]) {
                row = i;
            }
        }

        return row;
    }

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = maxRow(mat, mid);

            int left = (mid > 0) ? mat[row][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            }

            if (left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-a-peak-element-ii/)