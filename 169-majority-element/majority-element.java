class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int a=nums.length/2;
        for(Map.Entry m:map.entrySet()){
            if((int)m.getValue()>a){
                return (int)m.getKey();
            }
        }
        return -1;
    }
}