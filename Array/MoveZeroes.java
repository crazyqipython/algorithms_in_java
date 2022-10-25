
public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int insertPos = 0;

        for(int num: nums){
            if(num != 0){
                nums[insertPos] = num;
                insertPos++;
            }
        }

        for(int i = insertPos; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
