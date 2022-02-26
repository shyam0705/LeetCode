class Solution {
    int limit;
    ArrayList<ArrayList<Integer>>graph;
    int n;
    int ans;
    int[][][] dp;
    int visited;
    public int dfs(int[][] graph,int i,int current,int count)
    {
        if(current>limit | current>ans)
        {
            dp[i][visited][current]=Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if(count==n)
        {
            dp[i][visited][current]=0;
            return 0;
        }
        if(dp[i][visited][current]!=-1)
        {
            return dp[i][visited][current];
        }
        int tmp1=Integer.MAX_VALUE;
        for(int j=0;j<graph[i].length;j++)
        {
            int el=graph[i][j];
            if(!checkSetBit(el))
            {
                setBit(el);
                int tmp=dfs(graph,el,current+1,count+1);
                if(tmp!=Integer.MAX_VALUE)
                {
                    tmp1=Math.min(tmp1,1+tmp);
                }
                unSetBit(el);
            }
            else
            {
                int tmp=dfs(graph,el,current+1,count);
                if(tmp!=Integer.MAX_VALUE)
                {
                    tmp1=Math.min(tmp1,1+tmp);
                }
            }
        }
       dp[i][visited][current]=tmp1;
       return tmp1;
    }
    public int shortestPathLength(int[][] graph) {
        n=graph.length;
        limit=2*n;
        ans=Integer.MAX_VALUE;
        visited=0;
        dp=new int[n][5000][limit+10];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<5000;j++)
            {
                for(int k=0;k<=limit+9;k++)
                {
                    dp[i][j][k]=-1;
                }
                
            }
        }
        for(int i=0;i<n;i++)
        {
            visited=0;
            setBit(i);
            ans=Math.min(ans,dfs(graph,i,0,1));
            unSetBit(i);
            // System.out.print(ans+" ");
        }
        return ans;
    }
    public boolean checkSetBit(int i)
    {
        int tmp=(visited>>i)&1;
        return tmp==1;
    }
    public void setBit(int i)
    {
        visited=visited+(1<<i);
    }
    public void unSetBit(int i)
    {
        visited=visited-(1<<i);
    }
}