package backtracking;

import java.util.*;
public class NQueens_51 {
    List<List<String>> result = new ArrayList<>();

    String[][] resultArray;

    int n;

    public List<List<String>> solveNQueens(int n) {

        this.n = n;

        resultArray = new String[n][n];

        backtrack(resultArray, 0);

        return result;
    }

    private void backtrack(String[][] board, int m) {

        if(m == n) {
            List<String> currentSet = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if("Q".equals(board[i][j])) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                currentSet.add(sb.toString());
            }
            result.add(currentSet);

            return;
        }

        for(int j = 0; j < n; j++) {
            if (isPossibleToPlace(board, m, j)) {
                board[m][j] = "Q";

                backtrack(board, m + 1);

                board[m][j] = ".";
            }
        }
    }

    private boolean isPossibleToPlace(String[][] board, int r, int c) {
        for(int i = 0; i < n; i++) {
            if("Q".equals(board[r][i])) {
                return false;
            }
            if("Q".equals(board[i][c])) {
                return false;
            }
            if(r + i < n && c + i < n) {
                if("Q".equals(board[r + i][c + i])) {
                    return false;
                }
            }
            if(r - i >= 0 && c - i >= 0) {
                if("Q".equals(board[r - i][c - i])) {
                    return false;
                }
            }
            if(r + i < n && c - i >= 0) {
                if("Q".equals(board[r + i][c - i])) {
                    return false;
                }
            }
            if(c + i < n && r - i >= 0) {
                if("Q".equals(board[r - i][c + i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens_51 nQueens51 = new NQueens_51();

        System.out.println(nQueens51.solveNQueens(2));
        System.out.println(nQueens51.solveNQueens(4));
    }
}
