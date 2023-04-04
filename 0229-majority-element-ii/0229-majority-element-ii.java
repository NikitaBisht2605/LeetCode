class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        if(nums.length==2){
            if(nums[0]!=nums[1]){
                list.add(nums[0]);
                list.add(nums[1]);
                return list;
            }
        }
        Arrays.sort(nums);
        int n=nums.length/3;
        int count=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++; 
                if(i==nums.length-2){
                    if(count>n){
                        list.add(nums[i]);
                    }
                }
            }
            else if(nums[i]!=nums[i+1]){
                if(count>n){
                    list.add(nums[i]);
                }
                count=1;
            }
        }
          
        return list;
    }
}