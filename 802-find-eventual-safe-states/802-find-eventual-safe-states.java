class Solution {
    boolean[] visited;
    int[] dp;
    public void dfs(int[][] graph,int index)
    {
        visited[index]=true;
        for(int j=0;j<graph[index].length;j++)
        {
            if(dp[graph[index][j]]==0)
            {
                dp[index]=0;
                visited[index]=false;
                return;
            }
            if(visited[graph[index][j]])
            {
                dp[index]=0;
                visited[index]=false;
                return;
            }
            if(dp[graph[index][j]]==-1)
            {
                dfs(graph,graph[index][j]);
                if(dp[graph[index][j]]==0)
                {
                     dp[index]=0;
                    visited[index]=false;
                    return;
                }
                   
            }
            
        }
        visited[index]=false;
        dp[index]=1;
        return;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        dp=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        List<Integer>ans=new ArrayList<>();
        visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(dp[i]==-1)
            {
                dfs(graph,i);
            }
            if(dp[i]==1)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}