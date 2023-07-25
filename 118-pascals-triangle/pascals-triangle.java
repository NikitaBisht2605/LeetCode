class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        ans.add(new ArrayList<>(list));
        list.clear();
        for(int i=1;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    list.add(1);
                }
                else{
                    int a=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    list.add(a);
                }
            }
            ans.add(new ArrayList<>(list));
            list.clear();
        }
        return ans;
    }
}