package binary;

import java.util.Arrays;

public class Problem3 {

    //Link - https://leetcode.com/problems/counting-bits/
    public static void main(String[] args) {
        int[] ans = new Problem3().countBits(11);
        System.out.println(Arrays.toString(ans));
    }

    public int[] countBits(int n) {

        //Approch - No of bits of number = number of bits half + (isOdd ? 1 : 0)
        //TC - O(n)
        //SC - O(1)

        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
