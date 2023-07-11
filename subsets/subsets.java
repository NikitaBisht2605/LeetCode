class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int i=0;
        recursion(i,nums,list,ans);
        return ans;
    }
    static void recursion(int i, int[] nums,List<Integer> list,List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        recursion(i+1,nums,list,ans);
        list.remove(list.size()-1);
        recursion(i+1,nums,list,ans);
    }
}