package dailyChallenge;

import java.util.*;

public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        for(String word : words) {
            if(count + word.length() == maxWidth) {
                sb.append(word);
                result.add(sb.toString());
                sb = new StringBuilder("");
                count = 0;
            }
            else if(count + word.length() > maxWidth) {
                sb.deleteCharAt(sb.length() - 1);
                result.add(adjustSpaces(sb, maxWidth));
                sb = new StringBuilder(word);
                sb.append(" ");
                count = word.length() + 1;
            }
            else {
                count = count + word.length() + 1;
                sb.append(word);
                sb.append(" ");
            }
        }
        if(!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            int extraSpaces = maxWidth - sb.length();
            sb.append(" ".repeat(extraSpaces));
            result.add(sb.toString());
        }


        return result;
    }

    private String adjustSpaces(StringBuilder sb, int maxWidth) {
        int extraSpaces = maxWidth - sb.length();
        String[] words = sb.toString().split(" ");

        int places = words.length - 1;

        int i = 0;

        while(extraSpaces != 0) {
            if(i >= places) {
                i = 0;
            }
            words[i] = words[i] + " ";
            extraSpaces--;
            i++;
        }


        return String.join(" ",words);
    }

    public static void main(String[] args) {
        TextJustification_68 textJustification68 = new TextJustification_68();

        System.out.println(textJustification68.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(textJustification68.fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(textJustification68.fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
        System.out.println(textJustification68.fullJustify(new String[] {"enough","to","explain","to"}, 20));

        //System.out.println(textJustification68.adjustSpaces(new StringBuilder("Science is what we"), 20));
    }


}
