package dynamicProgramming;

import java.util.*;
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<List<Integer>, Integer> dp = new HashMap<>();
        return minimumPathSum(triangle, 0, 0, dp);
    }

    private int minimumPathSum(List<List<Integer>> triangle, int index, int row, Map<List<Integer>, Integer> dp) {
        if(row == triangle.size()) {
            return 0;
        }

        if(dp.get(Arrays.asList(index, row)) == null) {
            dp.put(Arrays.asList(index, row), Math.min(minimumPathSum(triangle, index, row + 1, dp), minimumPathSum(triangle, index + 1, row + 1, dp)) + triangle.get(row).get(index));
        }

        return dp.get(Arrays.asList(index, row));
    }
}
