class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        int i=0;
        recursion(i,list,ans,target,candidates);
        return ans;
    }
    static void recursion(int ind,List<Integer> list,List<List<Integer>> ans,int target,int[] candidates){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        for(int i=ind;i<candidates.length;i++){ //0-6 1-6 2-6 3-6 4-6
            if(ind!=i && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target>=candidates[i]){
                list.add(candidates[i]);
                recursion(i+1,list,ans,target-candidates[i],candidates);
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }
    }
}