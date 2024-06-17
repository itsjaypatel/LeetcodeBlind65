package array;

import java.util.Arrays;

public class Problem2 {

    //    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    public static void main(String[] args) {

        int ans = new Problem2().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {

        /*
        * Approch : Suppose we buy at ith day then, if we sell at max price in future days, it will generate profit
        * TC - O(n)
        * SC - O(1)
        * */

        int n = prices.length, maxProfit = 0;
        int maxSellingPrice = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxSellingPrice - prices[i]);
            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
        }
        return maxProfit;
    }
}
