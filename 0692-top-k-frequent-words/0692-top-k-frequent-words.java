class Solution {
    class Pair{
        String s;
        int f;
        Pair(String s,int f)
        {
            this.s=s;
            this.f=f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>mp=new HashMap<>();
        for(String s:words)
        {
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.f==b.f)
            {
                return b.s.compareTo(a.s);
            }
            return a.f-b.f;
        });
        mp.forEach((e,v)->{
            pq.add(new Pair(e,v));
            if(pq.size()>k)
            {
                pq.remove();
            }
        });
        List<String>ans=new ArrayList<>();
        while(!pq.isEmpty())
        {
            Pair tmp=pq.remove();
            ans.add(tmp.s);
        }
        Collections.reverse(ans);
        return ans;
    }
}