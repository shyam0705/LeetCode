class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++)
        {
            color[i]=-1;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                q.add(i);
                color[i]=0;
                while(!q.isEmpty())
                {   
                    int tmp=q.remove();
                    for(int j=0;j<graph[tmp].length;j++)
                    {
                        if(color[graph[tmp][j]]==color[tmp])
                        {
                            return false;
                        }
                        if(color[graph[tmp][j]]==-1)
                        {
                            color[graph[tmp][j]]=1-color[tmp];
                            q.add(graph[tmp][j]);
                        }
                    }
                }
            }
        }
        return true;
        
    }
}