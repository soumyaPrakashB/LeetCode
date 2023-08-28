package dynamicProgramming;

import java.util.*;
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();

        return climbStairs(cost, cost.length, map);
    }

    private int climbStairs(int[] cost, int n, Map<Integer, Integer> map) {
        if(n == 0) {
            return cost[0];
        }
        if(n == 1) {
            return cost[1];
        }

        if(map.get(n) == null) {
            map.put(n, Math.min(climbStairs(cost, n - 1, map), climbStairs(cost, n - 2, map)) + (n == cost.length ? 0 : cost[n]));
        }

        return map.get(n);
    }
}
