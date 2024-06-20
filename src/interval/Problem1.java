package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem1 {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3},{6, 9}};
        int[] newInterval = new int[]{10, 12};
        int[][] ans = new Problem1().insert(intervals, newInterval);
        Arrays.stream(ans).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        //TC - O(N)
        //SC - O(1)

        List<int[]> result = new ArrayList<>();
        boolean inserted = false; //flag to check whether newInterval is inserted or not

        int n = intervals.length, ci = 0;

        while(!inserted || ci < n){
            int[] curInterval = ci < n ? intervals[ci]: null;
            if(inserted){
                if(curInterval != null){
                    addIntervalToList(curInterval,result);
                    ci++;
                }
            }else{
                if(curInterval == null || curInterval[0] > newInterval[0]){
                    addIntervalToList(newInterval,result);
                    inserted = true;
                }else{
                    addIntervalToList(curInterval,result);
                    ci++;
                }
            }
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
