class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int ind=0;
        recursion(ind,list,ans,nums);
        return ans;
    }
    static void recursion(int ind,List<Integer> list,List<List<Integer>> ans,int[] nums){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind==nums.length){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                recursion(ind+1,list,ans,nums);
                list.remove(list.size()-1);
            }
        }
        recursion(ind+1,list,ans,nums);
    }
}