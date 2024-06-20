package interval;

import java.util.Arrays;

public class Problem4 {

    //Link - https://www.interviewbit.com/problems/repeat-and-missing-number-array/

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 5, 3};
        int[] ans = new Problem4().repeatedNumber(nums);
        System.out.println(Arrays.toString(ans));
    }
    public int[] repeatedNumber(int[] nums) {

        //TC - O(N)
        //SC - O(1)

        int n = nums.length, xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        //now xor contains xor between missing number and repeated number
        int mask = xor & -xor;

        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < n; i++) {
            if((nums[i] & mask) == 0) {
                number1 ^= nums[i];
            }else{
                number2 ^= nums[i];
            }

        }

        for (int i = 1; i <= n; i++) {
            if((i & mask) == 0) {
                number1 ^= i;
            }else{
                number2 ^= i;
            }
        }


        int count = 0;
        for(int x : nums){
            if(x == number1){
                count++;
            }
        }
        if(count == 0){
            //number1 = missing, number2 = repeated
            return new int[]{number1,number2};
        }else{
            //number1 = repeated, number2 = missing
            return new int[]{number2,number1};
        }
    }
}
