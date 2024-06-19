package binary;

import java.util.Arrays;

public class Problem4 {

    //Link - https://leetcode.com/problems/missing-number/description/
    public static void main(String[] args) {
        int ans = new Problem4().missingNumber(new int[]{3,0,1});
        System.out.println(ans);
    }

    public int missingNumber(int[] nums) {

        //Approch - Using xor (Intuition - xor of same elements are zero)
        //TC - O(n)
        //SC - O(1)

        int n = nums.length;

        int xor= 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
