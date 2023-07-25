class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max_len=0;
        int len=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                len++;
            }
            else if(nums[i+1]-nums[i]!=1 && nums[i+1]!=nums[i]){
                max_len=Math.max(len,max_len);
                len=1;
            }
        }
        return Math.max(max_len,len);
    }
}