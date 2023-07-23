class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int a=nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])>a){
                    return nums[i];
                }
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>a){
                    return nums[i];
                }
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        for(Map.Entry m:map.entrySet()){
            if((int)m.getValue()>a){
                return (int)m.getKey();
            }
        }
        return -1;
    }
}