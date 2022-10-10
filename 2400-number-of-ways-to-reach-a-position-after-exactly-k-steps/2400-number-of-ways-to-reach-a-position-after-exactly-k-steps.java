class Solution {
    
    HashMap<String,Integer>mp;
    public int recur(int current,int end,int k)
    {
        int diff=end-current;
        if(k<0)
        {
            return 0;
        }
        if(k==0)
        {
            if(current==end)
                return 1;
            return 0;
        }
        if(diff==k)
        {
            return 1;
        }
        if(diff>k)
        {
            return 0;
        }
        String key=current+"$"+k;
        if(mp.containsKey(key))
        {
            return mp.get(key);
        }
        int tmp=(recur(current-1,end,k-1)
                 +
                 recur(current+1,end,k-                                                     1))%1000000007;
        mp.put(key,tmp);
        return tmp;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        mp=new HashMap<>();
        return recur(startPos,endPos,k);
    }
}