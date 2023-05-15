class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> flag=new ArrayList<>();
        combination(candidates,target,arr,0,flag);
        return arr;
    }
    static void combination(int[] candidates, int target,List<List<Integer>> arr,int ind,List<Integer> flag){
        if(ind==candidates.length && target==0){
            arr.add(new ArrayList<>(flag));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        if(target>=candidates[ind]){
            flag.add(candidates[ind]);
            combination(candidates,target-candidates[ind],arr,ind,flag);
            flag.remove(flag.size()-1);
        }
        combination(candidates,target,arr,ind+1,flag);
    }
}