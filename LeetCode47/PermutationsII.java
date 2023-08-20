import java.util.*;
public class PermutationsII {

    Set<List<Integer>> result = new HashSet<>();

    int[] nums;

    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        System.out.println(map);

        List<Integer> currentPermutation = new ArrayList<>();

        backtrack(0, currentPermutation);

        return new ArrayList<>(result);
    }

    void backtrack(int index, List<Integer> currentPermutation) {
        System.out.println(currentPermutation);
        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(i > index && nums[i-1] == nums[i]) {
                continue;
            }

            if(map.get(nums[i]) == 0) {
                continue;
            }

            currentPermutation.add(nums[i]);
            map.put(nums[i], map.get(nums[i]) - 1);

            backtrack(i, currentPermutation);

            currentPermutation.remove(currentPermutation.size() - 1);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();

        System.out.println(permutationsII.permuteUnique(new int[] {1, 1, 2})); // 112, 121, 211
    }
}
