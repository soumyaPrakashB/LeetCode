public class LeetCode459 {
    public boolean repeatedSubstringPattern(String s) {

        for(int i = 1; i <= s.length()/2; i++) {
            String current = s.substring(0, i);
            int j = 0;

            while(j <= s.length()) {
                if(j == s.length()) {
                    return true;
                }
                if(j + i > s.length()) {
                    break;
                }
                if(current.equals(s.substring(j, j + i))) {
                    j = j + i;
                }
                else {
                    break;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        LeetCode459 leetCode459 = new LeetCode459();
        System.out.println(leetCode459.repeatedSubstringPattern("aaaaaaaac"));
    }
}
