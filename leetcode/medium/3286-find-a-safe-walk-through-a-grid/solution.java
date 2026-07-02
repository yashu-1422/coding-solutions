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