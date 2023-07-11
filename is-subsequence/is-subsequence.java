class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if(s.length()>t.length()){
            return false;
        }
        int n=s.length()-1;
        char c=s.charAt(n);
        int flag=0;
        int i=t.length()-1;
        while(i>=0 && flag!=s.length()){
            if(t.charAt(i)==c){
                flag++;
                n--;
                if(n>=0){
                    c=s.charAt(n); 
                }               
            }
            i--;
        }
        if(flag==s.length()){
            return true;
        }
        return false;
    }
}