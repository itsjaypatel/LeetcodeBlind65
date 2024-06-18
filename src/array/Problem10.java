package array;

public class Problem10 {

    //    Link: https://leetcode.com/problems/container-with-most-water/description/

    public static void main(String[] args) {

        int ans = new Problem10().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }

    public int maxArea(int[] height) {


        /*
            Approch - Brute Force
            TC - O(N^2)
            SC - O(1)

            int n = height.length, maxArea = 0;
            for (int i = 0; i < n - 1; i++) {
                for(int j = i+1; j < n; j++) {
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return maxArea;
        */


        /*
        * Approch - 2 Pointer
        * TC - O(n)
        * SC - O(1)
        * */

        int n = height.length, left = 0, right = n - 1,maxArea = 0;

        while(left <= right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]){
                // looking for area with better height on right side
                left++;
            }else{
                // looking for area with better height on left side
                right--;
            }
        }

        return maxArea;
    }
}
