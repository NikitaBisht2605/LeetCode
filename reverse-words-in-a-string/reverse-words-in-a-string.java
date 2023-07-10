class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String temp="";
        String[] str=s.split(" ");
        System.out.println(Arrays.toString(str));
        for(int i=str.length-1;i>=0;i--){
            if(!str[i].trim().equals("")){
                temp=temp+" "+str[i].trim(); 
            }
            //System.out.println(temp);   
        }
        return temp.trim();
    }
}
// s=s.trim();
//         String temp="";
//         String ans="";
//         for(int i=s.length()-1;i>=0;i--){
//             if(Character.isAlphabetic(s.charAt(i))){
//                 temp=s.charAt(i)+temp;
//             }
//             else{
//                 ans=ans+temp+s.charAt(i);
//                 temp="";
//             }
//         }
//         ans=ans+temp;
//         return ans;