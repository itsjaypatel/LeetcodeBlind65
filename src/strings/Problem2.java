package strings;

import java.util.Arrays;

public class Problem2 {
    public int characterReplacement(String s, int k) {
        //Approch - Sliding Window
        //TC - O(N*26)
        //SC - O(N)

        int n = s.length();
        int maxFreq = 0, maxLen = 0;
        int[] map = new int[26];
        for(int start = 0,end = 0; end < n; end++){

            int ch1 = s.charAt(end) - 'A';
            map[ch1]++;
            if(map[ch1] > maxFreq){
                maxFreq = map[ch1];
            }
            while((end - start + 1 - maxFreq) > k){
                int ch2 = s.charAt(start) - 'A';
                map[ch2]--;
                maxFreq = Arrays.stream(map).max().getAsInt();
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
