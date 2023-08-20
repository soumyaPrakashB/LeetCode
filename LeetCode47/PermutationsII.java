import java.util.*;
public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();

    int[] nums;

    Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);

        for(int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
        }

        System.out.println(map);

        List<Integer> currentPermutation = new ArrayList<>();

        backtrack(map, currentPermutation);

        return result;
    }

    void backtrack(Map<Integer, Integer> map, List<Integer> currentPermutation) {
        System.out.println(currentPermutation);
        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int count = entry.getValue();

            if(count == 0) {
                continue;
            }

            currentPermutation.add(value);
            map.put(value, count - 1);

            backtrack(map, currentPermutation);

            currentPermutation.remove(currentPermutation.size() - 1);
            map.put(value, count);
        }
    }
}

class Test {
    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();

        System.out.println(permutationsII.permuteUnique(new int[] {1, 1, 2})); // 112, 121, 211
    }
}
