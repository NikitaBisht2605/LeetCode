//import java.lang.math;
class Solution {
    public int maxSubArray(int[] nums) {
        int mx=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int a=nums[i]+sum;
            if(a>0){
                sum=a;
                mx=Math.max(mx,sum);
            }
            else{
                sum=0;
                mx=Math.max(mx,a);
            }
        }
        return mx;
    }
}