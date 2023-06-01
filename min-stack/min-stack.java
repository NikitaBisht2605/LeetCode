class MinStack {
    int minEle;
    Stack<Integer> s1;
	Stack<Integer> s2;
    
    public MinStack() {
        s1=new Stack<>();
		s2=new Stack<>();
    }
    
    public void push(int val) {
        if(s1.isEmpty()){
            s1.push(val);
            s2.push(val);
        }
        else{
            if(val<=s2.peek()){
                s2.push(val);
                s1.push(val);
            }
            else{
                s1.push(val);
                s2.push(s2.peek());
            }
        }       
    }
    
    public void pop() {
        if(!s1.isEmpty()){
            s1.pop();
            s2.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        if(s2.isEmpty()){
	        return -1;
	    }
	    else{
	        return s2.peek();
	    }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */