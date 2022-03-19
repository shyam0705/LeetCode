class Pair{
    int el;
    int f;
    int index;
    Pair(int el,int f,int index)
    {
        this.el=el;
        this.f=f;
        this.index=index;
    }
}
class FreqStack {
    HashMap<Integer,Integer>mp;
    PriorityQueue<Pair>pq;
    int top;
    public FreqStack() {
        top=0;
        mp=new HashMap<>();
        pq=new PriorityQueue<>((a,b)->{
            if(a.f==b.f)
            {
                return b.index-a.index;
            }
            return b.f-a.f;
        });
    }
    
    public void push(int val) {
        if(mp.containsKey(val))
        {
            int f=mp.get(val);
            pq.add(new Pair(val,f+1,top));
            top++;
            mp.put(val,f+1);
        }
        else
        {
            pq.add(new Pair(val,1,top));
            top++;
            mp.put(val,1);
        }
    }
    
    public int pop() {
        Pair tmp=pq.remove();
        int f=mp.get(tmp.el);
        if(f==1)
        {
            mp.remove(tmp.el);
        }
        else
        {
            mp.put(tmp.el,f-1);
        }
        return tmp.el;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */