import java.util.*;
public class CoinChangeII {
    int amount;
    int[] nums;
    int count = 0;

    Set<List<Integer>> set = new HashSet<>();
    public int change(int amount, int[] coins) {
        this.amount = amount;
        this.nums = coins;

        backtrack(0, new ArrayList<Integer>());

        return count;
    }

    void backtrack(int sum, List<Integer> list) {
        //System.out.println(sum);
        if(sum == amount) {

            List<Integer> tempList = new ArrayList<Integer>(list);
            Collections.sort(tempList);
            if(set.add(tempList)) {
                //System.out.println(tempList);
                count++;
            }
            return;
        }

        if(sum > amount) {
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            list.add(nums[i]);

            backtrack(sum, list);

            sum -= nums[i];
            list.remove(list.size() - 1);
        }

    }
}

class Test {
    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();

        System.out.println(coinChangeII.change(5, new int[] {1, 2, 5}));
    }
}
