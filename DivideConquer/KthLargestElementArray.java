package DivideConquer;

import java.util.Arrays;

public class KthLargestElementArray {
    public int KthLargestElementArray(int[] nums, int k){
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }

    public static void main(String[] args){
        int [] t = new int[]{3,2,1,5,6,4};
        KthLargestElementArray kthObj = new KthLargestElementArray();
        int res = kthObj.KthLargestElementArray(t, 2);
        System.out.println(res);
    }
}
