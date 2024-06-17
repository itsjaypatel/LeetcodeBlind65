package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {

//    Link: https://leetcode.com/problems/two-sum/description/

    public static void main(String[] args) {

        int[] ans = new Problem1().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ans));
    }

    static record Pair(int value, int index) {
    }

    public int[] twoSum(int[] nums, int target) {

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

}
