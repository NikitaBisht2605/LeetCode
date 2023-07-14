class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            if(i==0 && nums[i]>nums[i+1]){
                return nums[i+1];
            }
            else if(i==nums.length-1 && nums[i]>nums[i-1]){
                return nums[0];
            }
            else if(i!=0 && i!=nums.length-1 && nums[i]>nums[i+1] && nums[i]>=nums[i-1]){
                return nums[i+1];
            }
        }
        return nums[0];   
    }
}