import java.util.*;

public class WordBreak {

    Map<String, Boolean> map = new HashMap();

    public boolean wordBreak(String inputString, List<String> wordDict) {
        for(String word : wordDict) {
            map.put(word, true);
        }

        return recurse(inputString);
    }

    boolean recurse(String remainingString) {
        if(map.containsKey(remainingString)) {
            return map.get(remainingString);
        }

        if(remainingString.length() == 0) {
            return true;
        }
        for(int i = 1; i <= remainingString.length(); i++) {
            if (map.getOrDefault(remainingString.substring(0, i), false) && recurse(remainingString.substring(i))) {
                map.put(remainingString.substring(i), true);
                return true;
            }
        }

        map.put(remainingString, false);
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        System.out.println(wordBreak.wordBreak("ode", Arrays.asList("od", "e")));
    }
}