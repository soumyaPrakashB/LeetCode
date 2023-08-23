package dailyChallenge;

import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(countValidPairs(mid, nums) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    int countValidPairs(int threshold, int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] - nums[i] <= threshold) {
                count++;
                i = i + 1;
            }
        }

        return count;
    }
}
