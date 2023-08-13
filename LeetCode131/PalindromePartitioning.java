import java.util.*;
public class PalindromePartitioning {

    String s;

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.s = s;

        backtrack(new ArrayList<String>(), 0);

        return result;
    }

    private void backtrack(List<String> currentCombination, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(index, i)) {
                currentCombination.add(this.s.substring(index, i + 1));

                backtrack(currentCombination, i + 1);

                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        while(start < end) {
            if(this.s.charAt(start++) != this.s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

        System.out.println(palindromePartitioning.partition("aab"));
    }
}
