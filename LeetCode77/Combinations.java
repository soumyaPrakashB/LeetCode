import java.util.*;

class Combinations {

    List<List<Integer>> result = new ArrayList<>();

    int n;

    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        backtrack(1, new ArrayList<>());

        return result;
    }

    private void backtrack(int index, List<Integer> currentCombination) {
        if(currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = index; i <= n; i++) {
            currentCombination.add(i);

            backtrack(i + 1, currentCombination);

            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}