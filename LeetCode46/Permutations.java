import java.util.*;

public class Permutations {

    int[] nums;

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        backtrack(0, new ArrayList<Integer>());

        return result;
    }

    void backtrack(int index, List<Integer> currentPermutation) {
        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(currentPermutation.contains(nums[i])) {
                continue;
            }

            currentPermutation.add(nums[i]);

            backtrack(i + 1, currentPermutation);

            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        System.out.println(permutations.permute(new int[] {1, 2, 3}));
    }
}
