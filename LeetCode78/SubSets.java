import java.util.*;

public class SubSets {

    List<List<Integer>> result = new ArrayList<>();

    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;

        backtrack(0, new ArrayList<Integer>());
        return result;
    }

    void backtrack(int index, List<Integer> combination) {

        result.add(new ArrayList<>(combination));

        for(int i = index; i < nums.length; i++) {
            combination.add(nums[i]);

            backtrack(i + 1, combination);

            combination.remove(combination.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        SubSets subSets = new SubSets();

        System.out.println(subSets.subsets(new int[] {1,2,3}));
//        System.out.println(subSets.subsets(new int[] {0}));

    }
}
