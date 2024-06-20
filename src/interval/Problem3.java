package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

//    Link: https://leetcode.com/problems/non-overlapping-intervals/
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        int ans = new Problem3().eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        //TC - O(NLogN + N)
        //SC - O(1)

        Arrays.sort(intervals,(a,b) -> {
            return a[1] - b[1];
        });

        int n = intervals.length, prevEndTime = Integer.MIN_VALUE;

        int overlap = 0;
        for(int i = 0; i < n; i++){
            int x = intervals[i][0];
            int y = intervals[i][1];

            if(x >= prevEndTime){
                prevEndTime = y;
            }else{
                overlap++;
            }
        }

        return overlap;
    }
}
