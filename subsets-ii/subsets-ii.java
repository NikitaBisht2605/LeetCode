class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<Integer>();
        Arrays.sort(nums);
        subset(nums,0,list,ans);
        return ans;
    }
    static void subset(int[] nums,int ind,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            subset(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }

}