import java.util.*;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Problem statement: Given a digit combination (2 to 9) return all possible combinations of letters
 */
public class LeetCode17 {

    String[] digitToLetterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> result = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return result;
        }
        //set the digits field with the argument to the function.
        this.digits = digits;

        backtrack(0, new StringBuilder());

        return result;
    }

    void backtrack(int index, StringBuilder currentCombination) {
        //Base case: if we reach the end of digits then add current combination to result list and return
        //If backtrack method is called inside the for loop at line 39, the control will go back to line 47 of the previous recursive call stack
        if(index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        int currentDigit = Integer.valueOf(digits.charAt(index) - '0');
        String letters = digitToLetterMap[currentDigit - 2]; //fetching corresponding letters for the currentDigit from the digitToLetterMap array

        //Three things will be performed inside for loop
        for(int i = 0; i < letters.length(); i++) {
            //1. current letter will be appended to the currentCombination
            currentCombination.append(letters.charAt(i));

            //2. explore next letter to add to the combination
            backtrack(index + 1, currentCombination);

            //3. backtrack by removing the last letter
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

}

class Test {
    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }
}
