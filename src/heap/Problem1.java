package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1 {

    //Link - https://leetcode.com/problems/top-k-frequent-elements/

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
