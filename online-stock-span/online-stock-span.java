class StockSpanner {
    ArrayList<Integer> vector = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> input = new ArrayList<>();
    int a=0;
    int i;
    int index=0;
    public StockSpanner() {
        i=0;
    }
    
    public int next(int price) {
        input.add(price);
        if(stack.isEmpty()){
            vector.add(-1);
            stack.push(i);
        }
        else{
            while(stack.isEmpty()==false && a==0)
            {
                if(input.get(stack.peek())<=price)
                {
                    stack.pop();
                }
                else{
                    vector.add(stack.peek());
                    stack.push(i);
                    a=1;
                }
            }
            if(a==0){
                stack.push(i);
                vector.add(-1);
            }
            else{
                a=0;
            }
        }
        int output=index-vector.get(index);
        index=index+1;
        i++;
        return output;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */