class MyCircularQueue {

    int front;
    int rear;
    int n;
    int[] arr;
    public MyCircularQueue(int k) {
        arr=new int[k];
        n=k;
        front=0;
        rear=0;
    }
    public boolean enQueue(int value) {
        if(size()==n)
            return false;
        arr[rear%n]=value;
        rear++;
        return true;
    }
    
    public boolean deQueue() {
        if(size()==0)
            return false;
        front++;
        return true;
    }
    
    public int Front() {
       if(size()==0)
           return -1;
        return arr[front%n];
    }
    
    public int Rear() {
        if(size()==0)
            return -1;
        return arr[(rear-1)%n];
    }
    
    public boolean isEmpty() {
        return size()==0;
    }
    
    public boolean isFull() {
        return size()==n;
    }
    public int size()
    {
        return rear-front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */