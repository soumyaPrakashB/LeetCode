import java.util.*;

public class LeetCode40 {

    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates.clone();
        this.target = target;
        Arrays.sort(this.candidates);

        backtrack(0, new ArrayList<>(), 0);

        return new ArrayList<>(result);
    }

    void backtrack(int sum, List<Integer> combination, int index) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        //we will do 3 things inside the for loop
        //1. add the current element to the combination
        //2. explore other options by recursively calling the backtrack method
        //3. remove the last element to backtrack
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue; //candidates array is sorted. This way we are ensuring not to take any duplicate combination
            }
            sum += candidates[i];
            combination.add(candidates[i]);

            backtrack(sum, combination, i + 1);

            sum -= combination.remove(combination.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        System.out.println(leetCode40.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }
}
