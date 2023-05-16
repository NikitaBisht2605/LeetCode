class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<Integer>();
        permutation(nums,list,ans);
        return ans;
    }
    static void permutation(int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                permutation(nums,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}