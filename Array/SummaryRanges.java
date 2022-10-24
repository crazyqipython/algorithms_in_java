import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums){

        List<String> res = new ArrayList<String>();

        for(int i = 0; i<nums.length; i++){
            int start = nums[i];

            while(i < nums.length - 1 && nums[i] + 1 == nums[i+1]){
                i++;
            }
            
            if(start == nums[i]){
                res.add(""+start);
            }else{
                res.add(""+start+"->"+nums[i]);
            }
        }

        return res;
    }
}
