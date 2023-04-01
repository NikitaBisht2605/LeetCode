import java.util.Arrays;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a=0;
        int b=0;
        if(n!=0){
            for(int j=nums1.length-nums2.length;j<nums1.length;j++){
                nums1[j]=nums2[b];
                b++;
            }
            Arrays.sort(nums1);
        }
    }
}