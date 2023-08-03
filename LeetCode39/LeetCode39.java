import java.util.*;

public class LeetCode39 {

    //globalizing variable to access them in other methods
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int target;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.target = target;
        this.candidates = candidates;

        backtrack(0, new ArrayList<>(), 0);

        return result;
    }

    void backtrack(int sum, List<Integer> combination, int index) {
        if (sum > target) {
            System.out.println(new ArrayList<>(combination));
            return;
        }

        if (sum == target) {
            System.out.println(new ArrayList<>(combination));
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            combination.add(candidates[i]);

            backtrack(sum, combination, i);

            sum -= combination.remove(combination.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();

        System.out.println(leetCode39.combinationSum(new int[]{2, 7, 3}, 7));
    }
}