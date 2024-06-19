package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem9 {

    //Link - https://leetcode.com/problems/3sum/description/

    public static void main(String[] args) {

        List<List<Integer>> ans = new Problem9().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        //Approch - Sorting + Two Pointer
        //TC - O(NlogN) + O(N^2)
        //SC - O(1)

        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // to avoid duplicate triplets
            twoSum(i + 1,n - 1,nums,-nums[i],triplets);
        }
        return triplets;
    }

    public void twoSum(int start, int end, int[] nums, int target, List<List<Integer>> triplets) {

        while(start < end){
            int value1 = nums[start], value2 = nums[end],sum = value1 + value2;
            if(sum == target){
                triplets.add(List.of(-target,nums[start], nums[end]));
                while(start < nums.length && nums[start] == value1) start++; //to avoid duplicate triplets
                while(end >= 0 && nums[end] == value2) end--; //to avoid duplicate triplets
            }else if(sum < target){
                start++;
            }else
                end--;
        }
    }
}
