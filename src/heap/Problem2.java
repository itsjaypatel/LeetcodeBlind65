package heap;

import java.util.PriorityQueue;

public class Problem2 {

    //Link - https://leetcode.com/problems/find-median-from-data-stream/

    static class MedianFinder {

        private PriorityQueue<Integer> maxHeap; //keep track of lower half elements
        private PriorityQueue<Integer> minHeap; // keep track of upper half elements
        private int size;
        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>((a,b) -> b -a);
            this.minHeap = new PriorityQueue<>();
            this.size = 0;
        }

        public void addNum(int num) {
            if(maxHeap.isEmpty()){
                maxHeap.offer(num);
                size++;
                return;
            }
            if((size % 2 == 0)){
                //our goal to add element in maxHeap(lower half elements).
                if(num <= maxHeap.peek()){
                    //our new element already less than max of maxHeap so we can direclty insert it
                    maxHeap.offer(num);
                }else{
                    //take smallest from minHeap(right side) and insert into maxHeap(left side)
                    //insert new element into minHeap(right side)
                    int top = minHeap.poll();
                    maxHeap.offer(top);
                    minHeap.offer(num);
                }
            }else{
                //our goal to add element in minHeap(upper half elements)
                if(num < maxHeap.peek()){
                    //take smallest from maxHeap(left side) and insert into minHeap(right side)
                    //insert new element into maxHeap(left side)
                    int top = maxHeap.poll();
                    minHeap.offer(top);
                    maxHeap.offer(num);
                }else{
                    //our new element already greater than max of maxHeap so we can direclty insert it into minHeap(right side)
                    minHeap.offer(num);
                }
            }
            size++;
        }

        public double findMedian() {
            if((size % 2) == 0) {
                return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }
    }
}
