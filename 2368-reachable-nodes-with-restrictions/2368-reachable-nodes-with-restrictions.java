class Solution {
    boolean[] visited;
    ArrayList<ArrayList<Integer>> g;
    public int dfs(int current,HashSet<Integer>hs)
    {
        int count=1;
        for(int el:g.get(current))
        {
            if(!hs.contains(el) && !visited[el])
            {
                visited[el]=true;
                count=count+dfs(el,hs);
            }
        }
        return count;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        g=new ArrayList<>();
        HashSet<Integer>hs=new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        
        for(int i=0;i<restricted.length;i++)
        {
            hs.add(restricted[i]);
        }
        
        visited=new boolean[n];
        visited[0]=true;
        return dfs(0,hs);
    }
}