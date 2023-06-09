class Solution {
    
    HashSet<List<Integer>> set = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] nums){
        if(temp.size() == nums.length){
          
            if(!set.contains(new ArrayList<>(temp))){
                 set.add(new ArrayList<>(temp));
                ans.add(new ArrayList<>(temp));
            }
           
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] != -11){
                temp.add(nums[i]);
                
                nums[i] = -11;
                helper(nums);
                nums[i] =temp.get(temp.size()-1);
                temp.remove(temp.size()-1);
            }
            
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        helper(nums);
        return ans;
    }
}