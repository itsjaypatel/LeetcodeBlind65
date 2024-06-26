package strings;

import java.util.*;

public class Problem5 {

    //Link - https://leetcode.com/problems/group-anagrams/solutions/
    public List<List<String>> groupAnagrams(String[] strs) {

        //Approch - HashMap + Sorting
        //TC - O(N*MLogM)
        //SC - O(M)

        int n = strs.length;
        Map<String,List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            groups.putIfAbsent(sortedWord, new ArrayList<>());
            groups.get(sortedWord).add(str);
        }
        return groups.values().stream().toList();
    }
}
