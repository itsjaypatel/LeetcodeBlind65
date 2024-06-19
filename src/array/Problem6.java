package array;

public class Problem6 {

    //    Link: https://leetcode.com/problems/maximum-product-subarray/description/

    public static void main(String[] args) {

        int ans = new Problem6().maxProduct(new int[]{2,3,-2,4});
        System.out.println(ans);
    }

    public int maxProduct(int[] nums) {

        /*Approch -

        Test cases
            1. All positive numbers -> product of whole array
            2. contains even number of negatives -> product of whole array
            3. odd number of negatives -> for at all negative number index, it divides array into 2 halves.
                Left Half -> 0...i-1
                Right Half -> i+1...n-1
                Answer always lies between any of two halves.
            4. If contains 0 -> so divides array into subarray around zero and applies same rule for each individual subarray

            TC - O(n)
            SC - O(1)
        */
        int n = nums.length;

        int maxProduct = Integer.MIN_VALUE, prefixProd = 1, suffixProd = 1;
        for (int i = 0; i < n; i++) {
            prefixProd *= nums[i];
            suffixProd *= nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefixProd, suffixProd));
            if(prefixProd == 0){
                prefixProd = 1;
            }
            if(suffixProd == 0){
                suffixProd = 1;
            }
        }

        return maxProduct;
    }
}
