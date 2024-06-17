package array;

public class Problem7 {

    //    Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    public static void main(String[] args) {

        int ans = new Problem7().findMin(new int[]{3,1,2});
        System.out.println(ans);
    }
    public int findMin(int[] nums) {

        int n = nums.length, l = 0, r = n - 1,min = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[l] <= nums[mid]) {
                //left part is sorted
                min = Math.min(min, nums[l]); //take min from this part and move to first part
                l = mid + 1;
            }else{
                //right part is sorted
                min = Math.min(min, nums[mid]); //take min from this part and move to first part
                r = mid - 1;
            }
        }
        return min;
    }
}
