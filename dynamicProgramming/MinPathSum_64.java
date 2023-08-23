package dynamicProgramming;

public class MinPathSum_64 {
    int[][] dp;
    int[][] grid;
    int m;
    int n;
    public int minPathSum(int[][] grid) {
        // Recurrence relation
        // pathSum(m, n) = grid[0][0] if m and n are 0
        //               = grid[m][n] + pathSum(m, n - 1) if m = 0
        //               = grid[m][n] + pathSum(m - 1, n) if n = 0
        //               = grid[m][n] + min(pathSum(m, n - 1), pathSum(m - 1, n)) otherwise

        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        dp = new int[m][n];

        return recurse(m - 1, n - 1);

    }

    int recurse(int i, int j) {
        if(i == 0 && j == 0) {
            return grid[i][j];
        }

        if(dp[i][j] == 0) {
            if(i == 0) {
                dp[i][j] = grid[i][j] + recurse(i, j - 1);
            }
            else if(j == 0) {
                dp[i][j] = grid[i][j] + recurse(i - 1, j);
            }
            else {
                dp[i][j] = grid[i][j] + Math.min(recurse(i - 1, j), recurse(i, j - 1));
            }
        }

        return dp[i][j];
    }
}
