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

    void backtrack(int currentSum, List<Integer> currentCombination, int index) {
        System.out.println(new ArrayList<>(currentCombination));
        if (currentSum > target) {
            //System.out.println(new ArrayList<>(currentCombination));
            return;
        }

        if (currentSum == target) {
            //System.out.println(new ArrayList<>(currentCombination));
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        //2, 7, 3
        for (int i = index; i < candidates.length; i++) { //i = 0/ 1/ 2
            currentSum += candidates[i]; //2 | 4 | 6 | 9
            currentCombination.add(candidates[i]);

            backtrack(currentSum, currentCombination, i); //2, [2], 0 | 4, [2,2], 0 | 6, [2,2,2], 0 | 4, [2,2], 1 | [2,2,7] 11

            currentSum -= currentCombination.remove(currentCombination.size() - 1); //6, [2,2,2], 0
        }
    }
}

class Test {
    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();

        System.out.println(leetCode39.combinationSum(new int[]{2, 7, 3}, 7));
    }
}