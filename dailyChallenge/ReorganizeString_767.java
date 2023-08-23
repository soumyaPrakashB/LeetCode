package dailyChallenge;

import java.util.*;

public class ReorganizeString_767 {
        public String reorganizeString(String s) {
            if (s.length() == 1 || s.length() == 2 && s.charAt(0) != s.charAt(1)) {
                return s;
            }

            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                pq.offer(entry);
            }

            StringBuilder sb = new StringBuilder();

            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> first = pq.poll();

                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first.getKey()) {
                    sb.append(first.getKey());
                    if (first.getValue() - 1 > 0) {
                        first.setValue(first.getValue() - 1);
                        pq.offer(first);
                    }
                } else {
                    if (pq.isEmpty()) {
                        return "";
                    }

                    Map.Entry<Character, Integer> second = pq.poll();

                    sb.append(second.getKey());
                    if (second.getValue() - 1 > 0) {
                        second.setValue(second.getValue() - 1);
                        pq.offer(second);
                    }
                    pq.offer(first);
                }
            }

            return sb.toString();
        }

    public static void main(String[] args) {
        ReorganizeString_767 reorganizeString767 = new ReorganizeString_767();
        System.out.println(reorganizeString767.reorganizeString("aba"));
    }
}
