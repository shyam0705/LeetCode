class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        int m=roads.length;
        for(int i=0;i<m;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            int time=roads[i][2];
            int[] tmp1={v,time};
            int[] tmp2={u,time};
            graph.get(u).add(tmp1);
            graph.get(v).add(tmp2);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        pq.add(new int[]{0,0});
        int[] distance=new int[n];
        long[] count=new long[n];
        long mod=1000000007;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        count[0]=1;
        while(!pq.isEmpty())
        {
            int[] tmp=pq.remove();
            for(int[] el:graph.get(tmp[0]))
            {
                int v=el[0];
                if(tmp[1]+el[1]<distance[el[0]])
                {
                   distance[el[0]]=tmp[1]+el[1];
                    count[el[0]]=count[tmp[0]];
                    pq.add(new int[]{el[0],distance[el[0]]});
                }
                else if(tmp[1]+el[1]==distance[el[0]])
                {
                    count[el[0]]=(count[el[0]]+count[tmp[0]])%mod;
                }
            }
        }
        return (int)count[n-1];
    }
}