import java.util.*;

public class RestoreIpAddress {

    String s;

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        if(s.length() > 12) {
            return result;
        }

        this.s = s;

        backtrack(0, new ArrayList<String>());

        return result;
    }

    private void backtrack(int index, List<String> current) {

        // Below two if cases are base conditions.

        // This if case makes sure IP address doesn't contain more than 4 numbers
        if(current.size() > 4) {
            return;
        }

        // This if case ensures we have taken care of all the characters present in input string.
        if(index == s.length() && current.size() == 4) {
            // Before adding to result, put dots between numbers to make it an IP address
            result.add(String.join(".", new ArrayList<String>(current)));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            // Similar to Palindrome partitioning problem. Only consider the numbers that are eligible to be part of IP
            // As in palindrome partitioning, only consider those strings which are palindrome by themselves
            if(isValidNumberForIp(s.substring(index, i + 1))) {
                current.add(s.substring(index, i + 1));

                backtrack(i + 1, current);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValidNumberForIp(String num) {
        if(num.length() == 0 || num.length() > 4) {
            return false;
        }

        if(num.length() > 1 && num.charAt(0) == '0') {
            return false;
        }
        return Integer.valueOf(num) <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddress restoreIpAddress = new RestoreIpAddress();

        System.out.println(restoreIpAddress.restoreIpAddresses("25525511135"));
    }
}
