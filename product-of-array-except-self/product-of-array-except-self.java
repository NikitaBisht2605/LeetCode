class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int zero=0;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                prod=prod*nums[i];
            }
            else{
                zero++;
            }
        }
        if(zero>1){
            for(int i=0;i<ans.length;i++){
                ans[i]=0;
            }
            return ans;
        }
        else if(zero==1){
            for(int i=0;i<ans.length;i++){
                if(nums[i]!=0){
                    ans[i]=0;
                }
                else{
                    ans[i]=prod;
                }
            }
            return ans;
        }
        else{
            for(int i=0;i<ans.length;i++){
                ans[i]=prod/nums[i];
            }
            return ans;
        }
    }
}