class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Stack<Character> cha = new Stack();
        Stack<Integer> index = new Stack();
        int max=0;
        index.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                index.push(i);
                cha.push(s.charAt(i));
            }
            else{
                if(cha.isEmpty()==false){
                    cha.pop();
                    index.pop();
                    max=Math.max(max,i-index.peek());
                }
                else{
                    index.push(i);
                }
            }
        }
        return max;
    }
}