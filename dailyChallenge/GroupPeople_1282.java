package dailyChallenge;

import java.util.*;

public class GroupPeople_1282 {

/*
    Idea: First group all the indices having same group sizes in a map.
    Then check if the list of indices have the size equal to the group size.
    If yes, add it directly to the ans list of list.
    Else, divide it to make the size same with group size.
*/

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.get(groupSizes[i]) == null) {
                List<Integer> list = new ArrayList<>();
                map.put(groupSizes[i], list);
            }

            map.get(groupSizes[i]).add(i);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key).size() == key) {
                ans.add(map.get(key));
            } else {
                int count = 0;
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < map.get(key).size(); i++) {
                    count++;
                    temp.add(map.get(key).get(i));

                    if (count == key) {
                        ans.add(temp);
                        count = 0;
                        temp = new ArrayList<>();
                    }
                }
            }
        }


        return ans;
    }
}

