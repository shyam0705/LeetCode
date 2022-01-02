class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=time.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            int m=60-(time[i]%60);
            if(m==60)
            {
                m=0;
            }
            if(mp.containsKey(m))
            {
                count=count+mp.get(m);
            }
            mp.put(time[i]%60,mp.getOrDefault(time[i]%60,0)+1);
        }
        return count;
    }
}