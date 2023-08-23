package dynamicProgramming;

public class UniquePathsII_63 {
    int m;
    int n;
    int[][] obstacleGrid;
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }

        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;

        dp = new int[this.m][this.n];

        return recurse(m - 1, n - 1);
    }

    // Recurrence relation
    // paths(i, j) = 0 if obstacleGrid[i][j] == 1 //because no path from here
    //             = 0 if i == 0 && j == 0 //there is only one way to be at first cell
    //             = paths(i, j - 1) if i == 0 //if we are at first row only consider the left cell of current cell
    //             = paths(i - 1, j) if j == 0 //if we are at first column, only consider the top cell of current cell
    //             = paths(i - 1, j) + paths(i, j - 1) otherwise
    int recurse(int i, int j) {
        if(obstacleGrid[i][j] == 1) {
            return 0;
        }

        if(i == 0 && j == 0) {
            return 1;
        }

        if(dp[i][j] == 0) {
            if(i == 0) {
                dp[i][j] = recurse(i, j - 1);
            }
            else if(j == 0) {
                dp[i][j] = recurse(i - 1, j);
            }
            else {
                dp[i][j] = recurse(i - 1, j) + recurse(i, j - 1);
            }
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        UniquePathsII_63 uniquePathsII63 = new UniquePathsII_63();
        System.out.println(uniquePathsII63.uniquePathsWithObstacles(new int[][] {{0, 0}, {1, 1}, {0, 0}}));
    }
}
