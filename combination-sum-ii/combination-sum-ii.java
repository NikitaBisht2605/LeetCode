class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> flag=new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates,target,arr,0,flag);
        return arr;
    }
    static void combination(int[] candidates, int target,List<List<Integer>> arr,int ind,List<Integer> flag){
        if(target==0){
            if(!arr.contains(flag)){
                arr.add(new ArrayList<>(flag));
            }
            return;
        }
        for(int i = ind;i<candidates.length;i++){
            if(i != ind && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){break;}
            flag.add(candidates[i]);
            combination(candidates,target-candidates[i],arr,i+1,flag);
            flag.remove(flag.size()-1);
        }
    }
}
