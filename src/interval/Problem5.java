package interval;

import java.util.*;

public class Problem5 {

    //    Link: https://www.interviewbit.com/problems/meeting-rooms/
    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13},
        };
        int ans = new Problem5().findMinRooms(intervals);
        System.out.println(ans);
    }

    public int findMinRooms(int[][] meetings) {

        //TC - O(NLogN + N*LogK) //Assuming k rooms needed
        //SC - O(N + K) // internal sorting space

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int n = meetings.length;

        PriorityQueue<Integer> preferOnEndTime = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            Integer minEndTime  = preferOnEndTime.peek();
            if (minEndTime == null || minEndTime > meetings[i][0]) {
                preferOnEndTime.add(meetings[i][1]);
            } else {
                preferOnEndTime.poll();
                preferOnEndTime.add(meetings[i][1]);
            }
        }

        return preferOnEndTime.size();
    }
}
