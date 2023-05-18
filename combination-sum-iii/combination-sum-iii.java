class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> flag=new ArrayList<>();
        int nums[]={1,2,3,4,5,6,7,8,9};
        combination(0,k,n,ans,flag,nums);
        return ans;
    }
    static void combination(int ind,int k,int target, List<List<Integer>> ans, List<Integer> flag, int[] nums){
        if(flag.size()==k && target==0){
            ans.add(new ArrayList<>(flag));
            return;
        }
        if(ind==nums.length || flag.size()>k || target<nums[ind]){
            return;
        }
        else if(target>=nums[ind]){
            flag.add(nums[ind]);
            combination(ind+1,k,target-nums[ind],ans,flag,nums);
            flag.remove(flag.size()-1);
        }
        combination(ind+1,k,target,ans,flag,nums);
    }
}