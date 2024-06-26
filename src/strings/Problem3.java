package strings;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3 {


    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        String ans = new Problem3().minWindow(s,t);
        System.out.println(ans);
    }

    public String minWindow(String str1, String str2) {

        /*
        //Approch - Brute Force
        //TC - O(N*N)
        //SC - O(N)

        int n = str1.length(), m = str2.length();
        int[] minWindow = {0,n + 1};
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < m; i++){
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        System.out.println(map2);

        for(int i = 0; i < n - (m - 1); i++){
            Map<Character, Integer> map1 = new HashMap<>();
            for(int j = i; j < n; j++){
                map1.put(str1.charAt(j), map1.getOrDefault(str1.charAt(j), 0) + 1);
                if((j - i + 1) >= m && isValidWindow(map1,map2)){
                    if((j - i) < (minWindow[1] - minWindow[0])){
                        minWindow[0] = i;
                        minWindow[1] = j;
                    }
                    break;
                }
            }
        }
        if(minWindow[0] == 0 && minWindow[1] == n + 1){
            return "";
        }
        return str1.substring(minWindow[0], minWindow[1] + 1);

         */

        //Approach - Sliding Window
        //TC - O(N)
        //SC - O(M)

        int n = str1.length(), m = str2.length();
        int[] minWindow = {0,n + 1};
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < m; i++){
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        int unique = map2.size();


        for(int i = 0, j = 0; j < n; j++){
            char ch = str1.charAt(j);
            if(map2.containsKey(ch)){
                map2.put(ch, map2.get(ch) - 1);
                if(map2.get(ch) == 0){
                    unique--;
                }
            }

            while(unique == 0){
                if((j - i) < (minWindow[1] - minWindow[0])){
                    minWindow[0] = i;
                    minWindow[1] = j;
                }
                char ch0 = str1.charAt(i);
                if(map2.containsKey(ch0)){
                    map2.put(ch0, map2.get(ch0) + 1);
                    if(map2.get(ch0) == 1){
                        unique++;
                    }
                }
                i++;
            }
        }

        if(minWindow[0] == 0 && minWindow[1] == n + 1){
            return "";
        }
        return str1.substring(minWindow[0], minWindow[1] + 1);
    }

    public boolean isValidWindow(Map<Character, Integer> map1,Map<Character, Integer> map2) {
        for(Map.Entry<Character, Integer> entry : map2.entrySet()){
            if(!(map1.containsKey(entry.getKey()) && map1.get(entry.getKey()) >= entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
