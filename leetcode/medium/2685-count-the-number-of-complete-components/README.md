# Count the Number of Complete Components

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer `n`. There is an  **undirected**  graph with `n` vertices, numbered from `0` to `n - 1`. You are given a 2D integer array `edges` where `edges[i] = [ai, bi]` denotes that there exists an  **undirected**  edge connecting vertices `ai` and `bi`.

Return  *the number of  **complete connected components**  of the graph*.

A  **connected component**  is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be  **complete**  if there exists an edge between every pair of its vertices.

 

 **Example 1:** 

```
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.

```

 **Example 2:** 

```
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.

```

 

 **Constraints:** 

- 1 <= n <= 50
- 0 <= edges.length <= n * (n - 1) / 2
- edges[i].length == 2
- 0 <= ai, bi <= n - 1
- ai != bi
- There are no repeated edges.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 82.85%)  
**Memory:** 47.6 MB (beats 58.78%)  
**Submitted:** 2026-07-11T13:38:39.180Z  

```java
class Solution {

    List<Integer>[] graph;
    boolean[] visited;
    int nodes;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                nodes = 0;
                degreeSum = 0;

                dfs(i);

                int edgeCount = degreeSum / 2;

                if (edgeCount == nodes * (nodes - 1) / 2)
                    answer++;
            }
        }

        return answer;
    }

    private void dfs(int node) {

        visited[node] = true;
        nodes++;

        degreeSum += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next])
                dfs(next);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-the-number-of-complete-components/)