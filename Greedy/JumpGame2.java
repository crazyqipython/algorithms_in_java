import java.util.*;

public class JumpGame2{
    public int JumpGame(int[] nums){
        int steps = 0;
        int farthest = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                steps ++;
                end = farthest;
            }
        }
        return steps;
    }

    public int JumpGameRecursive(int [] nums){
        int steps = 0;
        JumpGame2 JumpObj = new JumpGame2();
        steps = JumpObj.helper(nums, 0);
        return steps;
    }

    public int helper(int[] nums, int pos){
        if(pos >= nums.length - 1 ) return 0;
        else{
            int minSteps = 10001;
            for (int j = 1; j <= nums[pos]; j++){
                minSteps = Math.min(minSteps, 1 + helper(nums, pos + j));
            }
            return minSteps;
        }
    }

    public static void main(String [] args){
        JumpGame2 jumpObj = new JumpGame2();
        int[] a = new int[]{2,3,1,1,4};
        int steps = jumpObj.JumpGameRecursive(a);
        System.out.println(steps);
    }
}