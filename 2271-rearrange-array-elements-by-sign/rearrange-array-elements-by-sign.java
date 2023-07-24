class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0;
        int j=0;
        int[] ans=new int[nums.length];
        int k=0;
        while(i<nums.length && j<nums.length){
            if(nums[i]>0 && nums[j]<0){
                ans[k]=nums[i];
                ans[k+1]=nums[j];
                i++;
                j++;
                k=k+2;
            }
            else if(nums[i]>0){
                j++;
            }
            else if(nums[j]<0){
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return ans;
    }
}