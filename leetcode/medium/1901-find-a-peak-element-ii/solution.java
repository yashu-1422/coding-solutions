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