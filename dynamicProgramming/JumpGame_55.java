package dynamicProgramming;

import java.util.*;
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> dp = new HashMap<>();

        return canJump(nums, nums.length - 1, dp);
    }

    private boolean canJump(int[] nums, int index, Map<Integer, Boolean> dp) {
        if(index == 0) {
            return true;
        }

        System.out.println(index);

        if(dp.get(index) == null) {
            for(int i = index - 1; i >= 0; i--) {
                if(nums[i] >= index - i) {
                    dp.put(index, canJump(nums, i, dp));
                    return dp.get(index);
                }
            }
        }

        dp.put(index, false);
        return dp.get(index);
    }

    public static void main(String[] args) {
        JumpGame_55 jumpGame55 = new JumpGame_55();

        System.out.println(jumpGame55.canJump(new int[] {2,3,1,1,4}));
    }
}
