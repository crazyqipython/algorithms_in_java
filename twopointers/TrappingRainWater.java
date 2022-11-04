class Solution {
    public int trap(int[] height) {
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = height.length - 1;
        
        while(i <= j){
            if(leftMax > rightMax){
                rightMax = Math.max(height[j], rightMax);
                water += rightMax - height[j];
                j--;
            }else{
                leftMax = Math.max(height[i], leftMax);
                water += leftMax - height[i];
                i++;
            }
        }
        
        return water;
    }
}