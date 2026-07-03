# Network Recovery Pathways

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a directed acyclic graph of `n` nodes numbered from 0 to `n − 1`. This is represented by a 2D array `edges` of length `m`, where `edges[i] = [ui, vi, costi]` indicates a one‑way communication from node `ui` to node `vi` with a recovery cost of `costi`.

Some nodes may be offline. You are given a boolean array `online` where `online[i] = true` means node `i` is online. Nodes 0 and `n − 1` are always online.

A path from 0 to `n − 1` is  **valid**  if:

- All intermediate nodes on the path are online.
- The total recovery cost of all edges on the path does not exceed k.

For each valid path, define its  **score**  as the minimum edge‑cost along that path.

Return the  **maximum**  path score (i.e., the largest  **minimum** -edge cost) among all valid paths. If no valid path exists, return -1.

 

 **Example 1:** 

 **Input:**  edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]], online = [true,true,true,true], k = 10

 **Output:**  3

 **Explanation:** 

- The graph has two possible routes from node 0 to node 3: Path 0 → 1 → 3 Total cost = 5 + 10 = 15, which exceeds k (15 > 10), so this path is invalid. Path 0 → 2 → 3 Total cost = 3 + 4 = 7 <= k, so this path is valid. The minimum edge‐cost along this path is min(3, 4) = 3.
- There are no other valid paths. Hence, the maximum among all valid path‐scores is 3.

 **Example 2:** 

 **Input:**  edges = [[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], online = [true,true,true,false,true], k = 12

 **Output:**  6

 **Explanation:** 

- Node 3 is offline, so any path passing through 3 is invalid.
- Consider the remaining routes from 0 to 4: Path 0 → 1 → 4 Total cost = 7 + 5 = 12 <= k, so this path is valid. The minimum edge‐cost along this path is min(7, 5) = 5. Path 0 → 2 → 3 → 4 Node 3 is offline, so this path is invalid regardless of cost. Path 0 → 2 → 4 Total cost = 6 + 6 = 12 <= k, so this path is valid. The minimum edge‐cost along this path is min(6, 6) = 6.
- Among the two valid paths, their scores are 5 and 6. Therefore, the answer is 6.

 

 **Constraints:** 

- n == online.length
- 2 <= n <= 5 * 104
- 0 <= m == edges.length <= min(105, n * (n - 1) / 2)
- edges[i] = [ui, vi, costi]
- 0 <= ui, vi < n
- ui != vi
- 0 <= costi <= 109
- 0 <= k <= 5 * 1013
- online[i] is either true or false, and both online[0] and online[n − 1] are true.
- The given graph is a directed acyclic graph.

## Solution

**Language:** Java  
**Runtime:** 254 ms (beats 26.73%)  
**Memory:** 195.2 MB (beats 45.54%)  
**Submitted:** 2026-07-03T15:42:59.946Z  

```java
import java.util.*;

class Solution {
    int n;
    List<int[]>[] graph;
    long k;

    private boolean check(int minEdge) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 4);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > k) return false;
            if (u == n - 1) return true;
            if (d != dist[u]) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];

                if (w < minEdge) continue;

                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }

        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.k = k;
        n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (!online[u] || !online[v]) continue;

            graph[u].add(new int[]{v, w});
            left = Math.min(left, w);
            right = Math.max(right, w);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return check(left) ? left : -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/network-recovery-pathways/)