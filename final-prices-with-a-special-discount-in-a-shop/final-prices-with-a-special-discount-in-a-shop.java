class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int[] nsr=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(prices[i]);
                nsr[i]=0;
            }
            else{
                if(stack.peek()<=prices[i]){
                    nsr[i]=stack.peek();
                    stack.push(prices[i]);
                }
                else{
                    while(!stack.isEmpty()){
                        if(stack.peek()<=prices[i]){
                            nsr[i]=stack.peek();
                            stack.push(prices[i]);
                            break;
                        }
                        stack.pop();
                    }
                    stack.push(prices[i]);
                    if(stack.isEmpty()){
                        stack.push(prices[i]);
                        nsr[i]=0;
                    }
                }
            }
        }
        for(int i=0;i<prices.length;i++){
            nsr[i]=prices[i]-nsr[i];
        }
        return nsr;
    }
}