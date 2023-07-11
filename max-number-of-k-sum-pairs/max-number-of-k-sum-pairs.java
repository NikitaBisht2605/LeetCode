class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int flag=0;
        while(i!=j && i<j){
            if(nums[i]+nums[j]==k){
                flag++;
                i++;
                j--;
            }
            else if(nums[i]+nums[j]>k){
                j--;
            } 
            else if(nums[i]+nums[j]<k){
                i++;
            }
        }
        return flag; 
    }
}