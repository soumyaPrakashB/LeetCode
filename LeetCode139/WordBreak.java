import java.util.*;

public class WordBreak {
    List<String> wordDict;
    public boolean wordBreak(String inputString, List<String> wordDict) {
        this.wordDict = wordDict;

        return recurse(inputString);
    }

    boolean recurse(String remainingstring) {
        if(remainingstring.length() == 0) {
            return true;
        }
            for(int i = 1; i <= remainingstring.length(); i++) {
                if (wordDict.contains(remainingstring.substring(0, i)) && recurse(remainingstring.substring(i))) {
                    return true;
                }
            }

        return false;
    }
}

class Test {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        System.out.println(wordBreak.wordBreak("ode", Arrays.asList("od", "e")));
    }
}