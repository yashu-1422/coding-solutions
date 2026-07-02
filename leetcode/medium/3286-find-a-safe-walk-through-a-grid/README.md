# Find a Safe Walk Through a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` binary matrix `grid` and an integer `health`.

You start on the upper-left corner `(0, 0)` and would like to get to the lower-right corner `(m - 1, n - 1)`.

You can move up, down, left, or right from one cell to another adjacent cell as long as your health  *remains*   **positive**.

Cells `(i, j)` with `grid[i][j] = 1` are considered  **unsafe**  and reduce your health by 1.

Return `true` if you can reach the final cell with a health value of 1 or more, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

 **Output:**  true

 **Explanation:** 

The final cell can be reached safely by walking along the gray cells below.

 **Example 2:** 

 **Input:**  grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3

 **Output:**  false

 **Explanation:** 

A minimum of 4 health points is needed to reach the final cell safely.

 **Example 3:** 

 **Input:**  grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5

 **Output:**  true

 **Explanation:** 

The final cell can be reached safely by walking along the gray cells below.

Any path that does not go through the cell `(1, 1)` is unsafe since your health will drop to 0 when reaching the final cell.

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 50
- 2 <= m * n
- 1 <= health <= m + n
- grid[i][j] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 13 ms (beats 77.87%)  
**Memory:** 47.1 MB (beats 42.62%)  
**Submitted:** 2026-07-02T16:14:36.710Z  

```java
import java.util.PriorityQueue;

class Solution {

    class State {
        int row;
        int col;
        int health;

        State(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int rows = grid.size();
        int cols = grid.get(0).size();

        // bestHealth[i][j] stores the maximum health
        // with which we have reached cell (i,j).
        int[][] bestHealth = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(bestHealth[i], -1);
        }

        // Starting health after entering (0,0)
        int startHealth = health;

        if (grid.get(0).get(0) == 1) {
            startHealth--;
        }

        if (startHealth <= 0) {
            return false;
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> b.health - a.health
        );

        pq.offer(new State(0, 0, startHealth));
        bestHealth[0][0] = startHealth;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            State current = pq.poll();

            int row = current.row;
            int col = current.col;
            int currentHealth = current.health;

            if (row == rows - 1 && col == cols - 1) {
                return true;
            }

            // Ignore an outdated state
            if (currentHealth < bestHealth[row][col]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                int newHealth = currentHealth;

                if (grid.get(newRow).get(newCol) == 1) {
                    newHealth--;
                }

                if (newHealth <= 0) {
                    continue;
                }

                if (newHealth > bestHealth[newRow][newCol]) {

                    bestHealth[newRow][newCol] = newHealth;

                    pq.offer(new State(newRow, newCol, newHealth));
                }
            }
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-a-safe-walk-through-a-grid/)