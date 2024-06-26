package strings;

public class Problem4 {

    public boolean isAnagram(String s, String t) {
        //Approch - Using HashMap
        //TC - O(N)
        //SC - O(N)

        int n = s.length(), m = t.length();
        if(n != m) return false;
        int[] frequency = new int[26];
        for(char c : s.toCharArray()) frequency[c - 'a']++;
        for(char c : t.toCharArray()) {
            if(frequency[c - 'a'] == 0)
                return false;
            frequency[c - 'a']--;
        }
        for(int i : frequency) if(i != 0) return false;
        return true;
    }
}
