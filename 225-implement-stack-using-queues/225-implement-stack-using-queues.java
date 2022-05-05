class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        this.q1=new LinkedList<>();
         this.q2=new LinkedList<>();
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.clear();
        q2.addAll(q1);
        q1.clear();
        q1.add(x);
        q1.addAll(q2);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return q1.remove();
        
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
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