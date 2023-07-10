class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res="";
        int n=word1.length();
        int m=word2.length();
        for(int i=0;i<n;i++){
            if(i<m){
                res=res+word1.charAt(i)+word2.charAt(i);
            }
            else{
                res=res+word1.substring(i,n);
                return res;
            }
        }
        res=res+word2.substring(n,m);
        return res;
    }
}