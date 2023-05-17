class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(n,k,list,ans,1);
        return ans;
    }
    static void combinations(int n, int k,List<Integer> list,List<List<Integer>> ans, int ind){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<=n;i++){
            list.add(i);
            combinations(n,k,list,ans,i+1);
            list.remove(list.size()-1);
        }
    }
}