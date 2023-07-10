class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0 && i!=nums.length-1){
                int j=i+1;
                while(j<nums.length && nums[j]!=0){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    i=j;
                    j++;
                }
            }
        }
    }
}