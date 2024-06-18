package array;

public class Problem8 {

    //    Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    public static void main(String[] args) {

        int ans = new Problem8().search(new int[]{1},0);
        System.out.println(ans);
    }
    public int search(int[] nums, int target) {

        //APPROCH - same as Problem7
        //TC - O(logn)
        //SC - O(1)
        int n = nums.length, l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[l] <= nums[mid]) {
                //left part is sorted
                if(nums[l] <= target && target <= nums[mid]) { //element present in left partition
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                //right part is sorted
                if(target <= nums[mid] && nums[r] <= target) { // element present in right partition
                   l  = mid + 1;
                }else{
                   r = mid - 1;
                }
            }
        }
        return -1;
    }
}
