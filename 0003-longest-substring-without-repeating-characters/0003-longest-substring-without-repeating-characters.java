class Solution {
    public int lengthOfLongestSubstring(String s) {
        String a="";
        int len=0;
        int max_len=0;
        for(int i=0;i<s.length();i++){
            String t=String.valueOf(s.charAt(i));
            if(a.contains(t)==false){
                a=a.concat(t);
                len=len+1; 
            }
            else{
                /*max_len=Math.max(len,max_len); //1,0=1 3,3
                len=1;
                a=t; */
                max_len=Math.max(len,max_len); 
                int ind=a.indexOf(t);
                a=a.substring(ind+1,a.length());
                a=a.concat(t);
                len=a.length();
            }
        }
        return Math.max(max_len,len);
    }
}