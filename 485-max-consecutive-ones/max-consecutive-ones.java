class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=0;
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                len++;
            }
            else{
                maxlen=Math.max(len,maxlen);
                len=0;
            }
        }
        return Math.max(len,maxlen);
    }
}