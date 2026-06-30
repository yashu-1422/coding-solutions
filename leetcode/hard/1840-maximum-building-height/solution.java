import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        // Add mandatory restrictions
        List<int[]> list = new ArrayList<>();

        // Building 1 always has height 0
        list.add(new int[]{1, 0});

        // Add all given restrictions
        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        // Add building n with maximum possible height
        // (before applying restrictions)
        list.add(new int[]{n, n - 1});

        // Sort by building index
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int m = list.size();

        // Left -> Right propagation
        for (int i = 1; i < m; i++) {

            int dist = list.get(i)[0] - list.get(i - 1)[0];

            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i - 1)[1] + dist
            );
        }

        // Right -> Left propagation
        for (int i = m - 2; i >= 0; i--) {

            int dist = list.get(i + 1)[0] - list.get(i)[0];

            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i + 1)[1] + dist
            );
        }

        int ans = 0;

        // Compute highest possible peak between every pair
        for (int i = 1; i < m; i++) {

            int x1 = list.get(i - 1)[0];
            int h1 = list.get(i - 1)[1];

            int x2 = list.get(i)[0];
            int h2 = list.get(i)[1];

            int dist = x2 - x1;

            // Maximum possible peak
            int peak = (h1 + h2 + dist) / 2;

            ans = Math.max(ans, peak);
        }

        return ans;
    }
}