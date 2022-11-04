
public class SortColors {
    public void sortColors(int[] nums) {
        int slow = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                swap(slow, i, nums);
                slow++;
            }
        }
        
        for(int i=slow; i<nums.length; i++){
            if(nums[i] == 1){
                swap(slow, i, nums);
                slow++;
            }
        }
    }
    
    public void swap(int slow, int fast, int[] nums){
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}


/**********
 * int len = nums.length;
 * if(len < 2)
 * return;
 * 
 * int left = 0;
 * int right = len - 1;
 * int current = 0;
 * while(current <= right) {
 * if(nums[current] == 0){
 * swap(nums, left, current);
 * left++;
 * current++;
 * }
 * else if(nums[current] == 1) {
 * current++;
 * }
 * else {
 * swap(nums, right, current);
 * right--;
 * }
 * }
 * }
 */
