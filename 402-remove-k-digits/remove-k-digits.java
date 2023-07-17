class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && stack.peek()>num.charAt(i) && k>0){
                System.out.println(stack.pop());
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(!stack.isEmpty() && k>0)
        {
            stack.pop();
            k--;
        }
        if(stack.size()==0)
            return "0";

        StringBuilder result= new StringBuilder();
        while(!stack.isEmpty())
            result.append(stack.pop());

        String res= result.reverse().toString();
        int i=0;
        while(i<res.length() && res.charAt(i)=='0')
            i++;

        res= res.substring(i,res.length());

        if(res.length()==0)
            return "0";
        return res;    
    }
}