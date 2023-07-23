class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }
        int j=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                while(nums[j]==0 && j>0){
                    j--;
                }
                if(nums[j]!=0){
                    int a=i;
                    while(a<j){
                        nums[a]=nums[a+1];
                        a++;
                    }
                    nums[a]=0;
                }
            }
            //System.out.println(Arrays.toString(nums));
        }
    }
}