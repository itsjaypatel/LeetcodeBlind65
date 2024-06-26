package strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Problem8 {

    public static void main(String[] args) {


        String ans = new Problem8().longestPalindrome("abcba");
        System.out.println(ans);
    }
    public String longestPalindrome(String s) {

        //TC - O(N*N)
        //SC - O(N)

        int n = s.length();
        int[] res = new int[2];
        boolean[] prev2 = null, prev1 = null;
        for(int gap = 0; gap < n; gap++){

            boolean[] curr = new boolean[n - gap];
            for(int i = 0,j = gap; j < s.length(); i++,j++){
                char c1 = s.charAt(i), c2 = s.charAt(j);
                if(gap == 0){
                    curr[i] = true;
                }else if(gap == 1){
                    curr[i] = c1 == c2;
                }else{
                    curr[i] = c1 == c2 && prev2[i+1];
                }
                if(curr[i] && (j - i) > (res[1] - res[0])){
                    res[0] = i;
                    res[1] = j;
                }
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return s.substring(res[0], res[1] + 1);
    }
    private boolean isPalindrome(int left, int right, String s) {
        int n = s.length();
        while(left < n/2){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
