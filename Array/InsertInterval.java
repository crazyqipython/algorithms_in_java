import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();

        for(int i=0; i<intervals.length; i++){

            if(newInterval[0] > intervals[i][1]){
                res.add(intervals[i]);  
            }else if(newInterval[1] < intervals[i][0]){
                res.add(newInterval);   
                newInterval = intervals[i];
            }else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);

    }
}
