package Array;

import java.util.*;;

public class MergeIntervals {
    public int[][] MergeIntervals(int[][] intervals){

        if(intervals == null) return intervals;

        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> res = new ArrayList<int[]>();
        
        res.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++){
            if(res.get(res.size() - 1)[1] >= intervals[i][0]){
                int[] temp = res.remove(res.size() - 1);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                res.add(temp);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
    
}
