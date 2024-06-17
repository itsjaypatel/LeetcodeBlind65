package array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {

//    Link: https://leetcode.com/problems/two-sum/description/

    public static void main(String[] args) {

        int[] ans = new Problem1().twoSumApproch1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ans));
    }

    static record Pair(int value, int index) {
    }

    public int[] twoSumApproch1(int[] nums, int target) {

        //TC - O(nlogn)
        //SC - O(n)
        int n = nums.length;
        List<Pair> pairs = IntStream
                .range(0, n)
                .mapToObj(index -> new Pair(nums[index], index))
                .sorted(Comparator.comparing(p -> p.value))
                .toList();


        int s = 0, e = n - 1;
        while (s < e) {
            int sum = pairs.get(s).value() + pairs.get(e).value();
            if (sum == target) {
                return new int[]{pairs.get(s).index, pairs.get(e).index};
            } else if (sum < target) {
                s++;
            } else {
                e--;
            }
        }

        return new int[0];
    }

    public int[] twoSumApproch2(int[] nums, int target) {

        //TC - O(n) Assuming map contains run in O(1)
        //SC - O(n)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
