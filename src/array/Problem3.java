package array;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    //    Link: https://leetcode.com/problems/contains-duplicate/description/

    public static void main(String[] args) {

        boolean ans = new Problem3().containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        System.out.println(ans);
    }

    public boolean containsDuplicate(int[] nums) {

        // TC - O(n)
        // SC - O(n)

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
