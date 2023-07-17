class Solution {
    public String simplifyPath(String path) {
        int i=0;
        Stack<String> stack=new Stack<String>();
        while(i<path.length()){
            if(path.charAt(i)=='/'){
                i++;
                String temp="";
                while(i<path.length() && path.charAt(i)!='/'){
                    temp=temp+path.charAt(i);
                    i++;
                }
                if(temp.length()==0 || (temp.length()==1 && temp.charAt(0)=='.')){
                    continue;
                }
                else if(temp.equals("..") && !stack.isEmpty()){
                    stack.pop();
                }
                else if(!temp.equals("..")){
                    stack.push(temp);
                }
            }
        }
        String res="";
        while(!stack.isEmpty()){
            res=stack.pop()+"/"+res;
        }
        res="/"+res;
        res=res.substring(0,res.length()-1);
        if(res.length()==0){
            return "/";
        }
        return res;
    }
}