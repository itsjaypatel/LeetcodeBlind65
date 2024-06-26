package strings;

import tree.Problem4;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        int ans = new Problem1().lengthOfLongestSubstring("abba");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {

        int n = s.length(), maxlen = 0;
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        for (int start = 0, end = 0; end < n; end++) {
            if(freq[s.charAt(end)] != -1) {
                start = Math.max(start,freq[s.charAt(end)] + 1);
            }
            freq[s.charAt(end)] = end;
            maxlen = Math.max(maxlen, end - start + 1);
        }
        return maxlen;
    }

    public boolean isDuplicateCharacterPresent(int[] freq) {
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 1){
                return true;
            }
        }
        return false;
    }
}
