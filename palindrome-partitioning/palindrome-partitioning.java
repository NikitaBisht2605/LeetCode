class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> flag=new ArrayList<>();
        palindrome(0,ans,flag,s);
        return ans;
    }
    static void palindrome(int ind,List<List<String>> ans,List<String> flag,String s){
        if(s.length()==ind){
            ans.add(new ArrayList<>(flag));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(check(s,ind,i)){
                flag.add(s.substring(ind,i+1));
                palindrome(i+1,ans,flag,s);
                flag.remove(flag.size()-1);
            }
        }
    }
    static boolean check(String s,int j,int i){
        while(j<=i){
            if(s.charAt(j)!=s.charAt(i)){
                return false;
            }
            j++;
            i--;
        }
        return true;
    }
}