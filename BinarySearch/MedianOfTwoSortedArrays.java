import java.util.*;

import javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        return findSortedArrays(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }
        
    public double findSortedArrays(int[] a, int[] b, int start_a, int end_a, int start_b, int end_b){
        if((end_a - start_a == 1) && (end_b - start_b == 1)){
            return 1.0 * (Math.max(a[start_a], b[start_b]) + Math.min(a[end_a], b[end_b])) / 2;
        }
        
        int m1 = (start_a + end_a)/2;
        int m2 = (start_b + end_b)/2;

        int median_m1 = a[m1];
        int median_m2 = b[m2];

        if(median_m1 == median_m2) return median_m1;

        if(median_m1 < median_m2){    //pass float double int long  byte string boolean
            start_a = m1;
            end_b = m2;
        }else{
            start_b = m2;
            end_a = m1;
        }
        return findSortedArrays(a, b, start_a, end_a, start_b, end_b);
    }

    public static void main(String[] strings){
        int[] nums1 = {1,2,4,6};
        int[] nums2 = {3,5};
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        double a = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(a);
    }

}