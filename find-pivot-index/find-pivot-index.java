class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int right=0;
        for(int i=1;i<nums.length;i++){
            right=right+nums[i];
        }
        int j=0;
        while(left!=right && j+1<nums.length){
            left=left+nums[j];
            right=right-nums[j+1];
            j++;
        }
        if(left==right){
            return j;
        }
        return -1;
    }
}