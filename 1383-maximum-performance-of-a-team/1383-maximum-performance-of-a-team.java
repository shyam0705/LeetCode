class Solution {
    class Node{
        int s,n;
        Node(int s,int n)
        {
            this.s=s;
            this.n=n;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<Node>l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            l.add(new Node(speed[i],efficiency[i]));
        }
        Collections.sort(l,(a,b)->{
            return a.n-b.n;
        });
        long sum=0;
        long ans=0;
        long mod=1000000007;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });
        for(int i=n-1;i>=n-k;i--)
        {
            sum=(sum+(long)l.get(i).s);
            long tmp=(sum*l.get(i).n);
            ans=Math.max(ans,tmp);
            pq.add(l.get(i).s);
        }
        // ans=Math.ma(sum*l.get(n-k).n)%mod;
        for(int i=n-k-1;i>=0;i--)
        {
            sum=(sum+(long)l.get(i).s-(long)pq.remove());
            long tmp=(sum*l.get(i).n);
            ans=Math.max(ans,tmp);
            pq.add(l.get(i).s);
        }
        return (int)(ans%mod);
    }
}