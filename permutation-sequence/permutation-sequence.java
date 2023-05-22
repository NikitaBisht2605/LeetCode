class Solution {
    public String getPermutation(int n, int k) {
        return permutation(n,k);
    }
    static String permutation(int n,int k){
        ArrayList<Integer> num= new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            num.add(i);
        }
        num.add(n);
        String s="";
        k=k-1;
        while(true){
            s=s+Integer.toString(num.get(k/fact));
            num.remove(num.indexOf(num.get(k/fact)));
            if(num.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/num.size();
        }
        return s;
    }
}