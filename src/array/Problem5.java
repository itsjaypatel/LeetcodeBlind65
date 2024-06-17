package array;

public class Problem5 {

    //    Link: https://leetcode.com/problems/maximum-subarray/description/

    public static void main(String[] args) {

        int ans = new Problem5().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,});
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {

        // Approch: Not to include subarray with negative sum
        // TC - O(n)
        // SC - O(1)

        int maxSubArrSum = 0, curSubArrSum = 0;

        for(int x : nums){
            curSubArrSum += x;
            maxSubArrSum = Math.max(maxSubArrSum, curSubArrSum);
            if(curSubArrSum < 0){
                curSubArrSum = 0;
            }
        }
        return maxSubArrSum;
    }
}
