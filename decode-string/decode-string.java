class Solution {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        String str="";
        for(int i=0;i<s.length();i++){
            //System.out.println(stack);
            char c=s.charAt(i);
            if(c==']'){
                while(!stack.isEmpty() && stack.peek()!='['){
                    str=Character.toString(stack.pop())+str;
                }
                stack.pop();
                String num="";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num=Character.toString(stack.pop())+num;
                }
                int a=Integer.parseInt(num);
                    //System.out.println(a);
                for(int j=0;j<a;j++){
                    for(int k=0;k<str.length();k++){
                        stack.push(str.charAt(k));
                    }
                }
                str="";
            }
            else{
                stack.push(c);
            }
        }
        //System.out.println(stack);
        String ans="";
        //System.out.println(stack);
        while(!stack.isEmpty()){
            //System.out.println(ans);
            ans=Character.toString(stack.pop())+ans;
        }
        return ans;
    }
}