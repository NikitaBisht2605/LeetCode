class Solution {
   Stack<String> reverse(Stack<String> stack){
        Stack<String> res = new Stack<>(); 
        while(!stack.empty()){
            res.push(stack.pop());
        }
        return res;
    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        //System.out.println(path);
        int i=0;
        while(i<path.length()){
            if(path.charAt(i)=='/'){
                i+=1;
                String temp = "";
                while(i<path.length() && path.charAt(i)!= '/') {
                    temp += path.charAt(i);
                    i++;
                }
                if(temp.equals(".")){
                    continue;
                }
                else if(temp.equals("..")){
                    if(!stack.empty()){
                        stack.pop();
                    }
                }
                else if(temp.length()!=0)stack.push(temp);
                //System.out.println(temp);
                //System.out.println(stack);
            }
        }
        stack = reverse(stack);
        String res = "";
        while(!stack.empty()){
            res += "/";
            res += stack.pop();
        }
        return res.length()==0?"/":res;
    }
}