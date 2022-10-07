class MyCalendarThree {

    TreeMap<Integer,Integer> mp;
    
    public MyCalendarThree() {
        mp=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        mp.put(start,mp.getOrDefault(start,0)+1);
        mp.put(end,mp.getOrDefault(end,0)-1);
        int ans=0;
        int sum=0;
        for(Integer k:mp.keySet())
        {
            sum=sum+mp.get(k);
            ans=Math.max(ans,sum);
        }
        return ans;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */