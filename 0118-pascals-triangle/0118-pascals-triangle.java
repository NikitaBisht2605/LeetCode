class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> parent=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> child = new ArrayList<>();
            if(i==0){
                child.add(1);
                parent.add(child);
                continue;
            }
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    child.add(j,1);
                }
                else{
                    int a= parent.get(i-1).get(j-1)+parent.get(i-1).get(j);
                    child.add(j,a);
                }
            }
            parent.add(child);
            
        }
        return parent;
    }
}