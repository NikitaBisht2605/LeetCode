class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            //System.out.println(tokens[i]);
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
                int op1=stack.pop();
                int op2=stack.pop();
                if(tokens[i].equals("+")){
                    int s=op2+op1;
                    stack.push(s);
                }
                else if(tokens[i].equals("*")){
                    int s=op2*op1;
                    stack.push(s);
                }
                else if(tokens[i].equals("-")){
                    int s=op2-op1;
                    stack.push(s);
                }
                else if(tokens[i].equals("/")){
                    int s=op2/op1;
                    stack.push(s);
                }
                //System.out.println(stack);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
                //System.out.println(stack);
            }
            
        }
        return stack.peek();
    }
}