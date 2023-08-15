import java.util.*;

class CombinationSumIII {

    int k, n;

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        //early optimization
        //Using k different numbers in the range [1,9], the smallest sum we can get is 1+...+k = k * (k+1)/2
        //if that sum is greater than n, there are no valid combinations
        if(k * (k + 1) > 2 * n) {
            return result;
        }


        this.k = k;
        this.n = n;

        backtrack(new ArrayList<Integer>(), 0, 1);

        return result;
    }

    private void backtrack(List<Integer> currentCombination, int sum, int index) {
        if(sum > n || currentCombination.size() > k) {
            return;
        }

        if(sum == n && currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = index; i <= 9; i++) {
            currentCombination.add(i);
            sum += i;

             if(sum > n) {
                 sum -= currentCombination.remove(currentCombination.size() - 1);
                 break;
             }

            backtrack(currentCombination, sum, i + 1);

            sum -= currentCombination.remove(currentCombination.size() - 1);
        }

    }
}

class Test {
    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();

        System.out.println(combinationSumIII.combinationSum3(3, 7));
    }
}
