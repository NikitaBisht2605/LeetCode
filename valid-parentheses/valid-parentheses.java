class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        if(s.length()==1 || s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty()){
                    char c=stack.peek();
                    if(c=='(' && s.charAt(i)==')'){
                        stack.pop();
                    }
                    else if(c=='[' && s.charAt(i)==']'){
                        stack.pop();
                    }
                    else if(c=='{' && s.charAt(i)=='}'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
}