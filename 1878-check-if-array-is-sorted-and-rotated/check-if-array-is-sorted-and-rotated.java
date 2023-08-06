class Solution {
    public boolean check(int[] nums) {
        int max=0;
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(max<=nums[i]){
                max=nums[i];
                ind=i;
            }
        }
        if(ind!=nums.length-1){
            for(int j=ind+1;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    return false;
                }
            }
            if(ind!=0){
                for(int j=0;j<ind;j++){
                    if(nums[j]>nums[j+1]){
                        return false;
                    }
                }
            }
            if(nums[0]<nums[nums.length-1]){
                return false;
            }
        }
        else{
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]!=max && nums[i]>nums[i+1]){
                    return false;
                }
            }
        }
        return true;        
    }
}