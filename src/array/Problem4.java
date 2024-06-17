package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {

    //    Link: https://leetcode.com/problems/product-of-array-except-self/description/

    public static void main(String[] args) {

        int[] ans = new Problem4().productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ans));
    }

    public int[] productExceptSelf(int[] nums) {

        /*
            Approch:
             1. store suffix product for ith index in array
             2. Create an variable prefix with initial value 1
             3. traverse nums from left
               for i index, ans[i] = prefix * ans[i]
               Note. prefix has product of all previous element before ith index and
               ans[i] as product of all next elemnet after ith index which turns out as product of array without
               elment itself

            TC - O(2n)
            SC - O(1) Assuming result array wont count in space complexity
         */


        int n = nums.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                ans[i] = 1;
            }else{
                ans[i] = nums[i + 1]*ans[i + 1];
            }
        }

        int prefix = 1;
        for(int i = 0; i < n; i++) {
            if(i == n - 1){
                ans[i] = prefix;
            }else{
                ans[i] = prefix * ans[i];
            }
            prefix *= nums[i];
        }
        return ans;

    }
}
