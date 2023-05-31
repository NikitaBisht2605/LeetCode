class MyStack {
    Queue<Integer> q1 =new LinkedList<>();
    Queue<Integer> q2 =new LinkedList<>();
    public MyStack() {
        
    }
    public void push(int x) {
        q2.add(x);
        System.out.println(q2);
        while(!q1.isEmpty()){
            q2.add(q1.poll());
            System.out.println(q2);
        }
        swap(q1,q2);
        System.out.println(q2);
        System.out.println(q1);
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        if(!q1.isEmpty()){
            return q1.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
    public static void swap(Queue<Integer> q1,Queue<Integer> q2){
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */