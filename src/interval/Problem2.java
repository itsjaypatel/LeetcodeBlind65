package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

//    Link: https://leetcode.com/problems/merge-intervals/description/
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = new Problem2().merge(intervals);
        Arrays.stream(ans).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public int[][] merge(int[][] intervals) {

        //TC - O(NLogN + N)
        //SC - O(1)

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int n = intervals.length;
        for (int[] currInterval : intervals) {
            addIntervalToList(currInterval, result);
        }

        return result.toArray(new int[result.size()][]);
    }

    public void addIntervalToList(int[] x,List<int[]> result) {
            // add x interval to list
            int[] previousInterval =  result.isEmpty() ? null : result.get(result.size() - 1);
            if(previousInterval == null || previousInterval[1] < x[0]){
                result.add(x);
            }else if(previousInterval[1] < x[1]){
                previousInterval[1] = x[1];
            }
    }
}
