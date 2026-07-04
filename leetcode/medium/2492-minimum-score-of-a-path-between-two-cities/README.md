# Minimum Score of a Path Between Two Cities

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a positive integer `n` representing `n` cities numbered from `1` to `n`. You are also given a  **2D**  array `roads` where `roads[i] = [ai, bi, distancei]` indicates that there is a  **bidirectional** road between cities `ai` and `bi` with a distance equal to `distancei`. The cities graph is not necessarily connected.

The  **score**  of a path between two cities is defined as the  **minimum** distance of a road in this path.

Return  *the  **minimum** possible score of a path between cities* `1` *and* `n`.

 **Note** :

- A path is a sequence of roads between two cities.
- It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
- The test cases are generated such that there is at least one path between 1 and n.

 

 **Example 1:** 

```
Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.

```

 **Example 2:** 

```
Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
Output: 2
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.

```

 

 **Constraints:** 

- 2 <= n <= 105
- 1 <= roads.length <= 105
- roads[i].length == 3
- 1 <= ai, bi <= n
- ai != bi
- 1 <= distancei <= 104
- There are no repeated edges.
- There is at least one path between 1 and n.

## Solution

**Language:** Java  
**Runtime:** 24 ms (beats 73.03%)  
**Memory:** 159 MB (beats 82.24%)  
**Submitted:** 2026-07-04T18:02:00.798Z  

```java
class Solution {

    List<int[]>[] graph;
    boolean[] visited;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
        }

        visited = new boolean[n + 1];
        dfs(1);

        return ans;
    }

    private void dfs(int node) {

        visited[node] = true;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int dist = edge[1];

            ans = Math.min(ans, dist);

            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/)