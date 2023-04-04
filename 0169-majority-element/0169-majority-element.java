class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length/2;
        int count=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
                if(count>n){
                    return nums[i];
                }
            }
            else{
                count=1;
            }
        }
        return 1;
    }
}