class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res="";
        for(int i=0;i<word1.length();i++){
            if(i<word2.length()){
                res=res+word1.charAt(i)+word2.charAt(i);
            }
            else{
                res=res+word1.substring(i,word1.length());
                return res;
            }
        }
        res=res+word2.substring(word1.length(),word2.length());
        return res;
    }
}