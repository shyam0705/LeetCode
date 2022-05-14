class Solution {
    class Pair{
        int node;
        int distance;
        Pair(int x,int y)
        {
            this.node=x;
            this.distance=y;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited=new boolean[n+1];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return a.distance-b.distance;
        });
        int[] distance=new int[n+1];
        ArrayList<ArrayList<Pair>>list=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            list.add(new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<times.length;i++)
        {
            list.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        distance[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty())
        {
            Pair tmp=pq.remove();
            visited[tmp.node]=true;
            int dis=tmp.distance;
            for(Pair pair:list.get(tmp.node))
            {
                if(!visited[pair.node] && (dis+pair.distance)<distance[pair.node])
                {
                    pq.add(new Pair(pair.node,dis+pair.distance));
                    distance[pair.node]=dis+pair.distance;
                }
                    
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            max=Math.max(max,distance[i]);
        }
        if(max==Integer.MAX_VALUE)
            return -1;
        return max;
        
    }
}