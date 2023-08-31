package dailyChallenge;

import java.util.*;
public class MinimumTaps_1326 {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0; // Base case

        for(int i = 0; i <= n; i++) {
            int tap_start = Math.max(0, i - ranges[i]);
            int tap_end = Math.min(n, i + ranges[i]);

            for(int j = tap_start; j <= tap_end; j++) {
                dp[tap_end] = Math.min(dp[j] + 1, dp[tap_end]);
            }
        }

        if(dp[n] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        MinimumTaps_1326 minimumTaps1326 = new MinimumTaps_1326();

        System.out.println(minimumTaps1326.minTaps(5, new int[] {3,4,1,1,0,0}));
    }
}
