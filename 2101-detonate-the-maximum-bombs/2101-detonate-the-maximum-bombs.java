class Solution {
    public int dfs(int index,ArrayList<ArrayList<Integer>>g,boolean[] visited)
    {
        visited[index]=true;
        int count=1;
        for(Integer el:g.get(index))
        {
            if(!visited[el])
            {
                count=count+dfs(el,g,visited);
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    long x=(long)bombs[i][0];
                    long y=(long)bombs[i][1];
                    long x1=(long)bombs[j][0];
                    long y1=(long)bombs[j][1];
                    if(((x-x1)*(x-x1)+(y-y1)*(y-y1))<=((long)bombs[i][2]*(long)bombs[i][2]))
                    {
                        graph.get(i).add(j);
                    }
                }
              
            }
        }
       
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
             boolean[] visited=new boolean[n];
            ans=Math.max(ans,dfs(i,graph,visited));
        }
        return ans;
    }
}