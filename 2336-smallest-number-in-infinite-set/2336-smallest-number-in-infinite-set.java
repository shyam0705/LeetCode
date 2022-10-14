class SmallestInfiniteSet {

    
    TreeSet<Integer>ts;
    int current=1;
    public SmallestInfiniteSet() {
        ts=new TreeSet<>();
       
    }
    
    public int popSmallest() {
        if(ts.isEmpty())
        {
            return current++;
        }
        else
        {
            int ans=ts.first();
            ts.remove(ans);
            return ans;
        }
        
    }
    
    public void addBack(int num) {
        if(num<current)
            ts.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */