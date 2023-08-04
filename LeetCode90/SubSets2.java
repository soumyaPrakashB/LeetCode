import java.util.*;

public class SubSets2 {

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        this.nums = nums.clone();
        Arrays.sort(this.nums);

        backtrack(0, new ArrayList<Integer>());

        return result;
    }

    void backtrack(int index, List<Integer> combination) {
        result.add(new ArrayList<>(combination));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            combination.add(nums[i]);

            backtrack(i + 1, combination);

            combination.remove(combination.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        SubSets2 subSets2 = new SubSets2();

        System.out.println(subSets2.subsetsWithDup(new int[] {0}));
    }
}