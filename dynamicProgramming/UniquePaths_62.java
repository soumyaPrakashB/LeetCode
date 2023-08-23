package dynamicProgramming;

public class UniquePaths_62 {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        // paths(i, j) = 1 if i = 1 || j = 1
        //             = paths(i-1, j) + paths(i, j-1)
        if (dp == null) {
            dp = new int[m][n];
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m - 1][n - 1] == 0) {
            dp[m - 1][n - 1] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }

        return dp[m - 1][n - 1];
    }
}
