package TwoPointers;
import java.util.*;

public class ContainerWithMostWater {
    public int ContainerWithMostWater(int[] height){
        int area = 0;
        int left = 0;
        int right = height.length;

        while(left < right){
            area = Math.max(area, Math.min(height[left], height[right]));

            if(height[left] > height[right]) right--;
            else left++;
        }
        
        return area;
    }
}
