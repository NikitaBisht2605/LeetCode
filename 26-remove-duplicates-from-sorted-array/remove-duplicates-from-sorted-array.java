class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        int j=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            nums[j]=m.getKey();
            j++;
        }
        return map.size();
    }
}