package dynamicProgramming;

import java.util.*;

public class ClimbingStairs_70 {
    //Memoization map
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        else {
            if(map.get(n) == null) {
                map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            }

            return map.get(n);
        }
    }

    public static void main(String[] args) {
        ClimbingStairs_70 climbingStairs70 = new ClimbingStairs_70();

        System.out.println(climbingStairs70.climbStairs(5));
    }
}
