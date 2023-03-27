import java.util.Arrays;
class Solution {
    public void sortColors(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==2){
                for(int j=nums.length-1;j>i;j--){
                    if(nums[j]!=2){
                        int a=nums[j];
                        nums[j]=nums[i];
                        nums[i]=a;
                        System.out.println(Arrays.toString(nums));
                        break;
                    }
                }
            }
            if(nums[i]==0){
                for(int j=0;j<i;j++){

                    if(nums[j]!=0){
                        int a=nums[j];
                        nums[j]=nums[i];
                        nums[i]=a;
                        System.out.println(Arrays.toString(nums));
                        break;
                    }

                }
            }

        }
    }
}