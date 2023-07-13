class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        recursion(0,list,res,s);
        return res;
    }
    static void recursion(int ind,List<String> list,List<List<String>> res,String s){
        if(ind==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(ind,i,s)){
                list.add(s.substring(ind,i+1));
                recursion(i+1,list,res,s);
                list.remove(list.size()-1);
            }
        }
    }
    static boolean isPalindrome(int ind, int i,String s){
        while(ind<=i){
            if(s.charAt(ind)!=s.charAt(i)){
                return false;
            }
            i--;
            ind++;
        }
        return true;
    }
}