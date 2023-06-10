class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char operator='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(isOperator(c) || i==s.length()-1){
                if(operator=='+'){
                    stack.push(num);
                }
                else if(operator=='*'){
                    stack.push(stack.pop()*num);
                }
                else if(operator=='/'){
                    stack.push(stack.pop()/num);
                }
                else if(operator=='-'){
                    stack.push(-num);
                }
                num=0;
                operator=c;
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum=sum+stack.pop();
        }
        return sum;
    }
    static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='/' || c=='*'){
            return true;
        }
        return false;
    }
}